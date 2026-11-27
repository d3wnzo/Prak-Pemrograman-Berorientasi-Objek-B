import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Server {
    public static void main(String[] args) throws IOException {
        int port = 8080;
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        
        // --- ENDPOINT SERVER ---
        server.createContext("/api/login", new LoginHandler());
        server.createContext("/api/kategori", new KategoriHandler());
        server.createContext("/api/pesan", new PesanHandler());
        server.createContext("/api/admin/pesanan", new AdminPesananHandler());
        server.createContext("/api/admin/update-status", new UpdateStatusHandler());
        server.createContext("/api/customer/pesanan", new CustomerPesananHandler());
        
        server.setExecutor(null);
        server.start();
        
        System.out.println("=== SERVER JAVA BERHASIL JALAN DI http://localhost:8080 ===");
    }

    // 1. Handler Login (Mengakses Akun)
    static class LoginHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            setupCORS(exchange);
            if ("OPTIONS".equals(exchange.getRequestMethod())) {
                exchange.sendResponseHeaders(204, -1);
                return;
            }

            if ("POST".equals(exchange.getRequestMethod())) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(exchange.getRequestBody()));
                StringBuilder body = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    body.append(line);
                }

                String reqBody = body.toString();
                String email = extractJsonValue(reqBody, "email");
                String password = extractJsonValue(reqBody, "password");

                String jsonResponse = "{\"status\":\"failed\",\"message\":\"Email atau password salah!\"}";

                try (Connection conn = KoneksiDB.getConnection()) {
                    String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    stmt.setString(1, email);
                    stmt.setString(2, password);
                    ResultSet rs = stmt.executeQuery();

                    if (rs.next()) {
                        int idUser = rs.getInt("id_user");
                        String nama = rs.getString("nama_lengkap"); 
                        String role = rs.getString("role");
                        
                        jsonResponse = String.format("{\"status\":\"success\",\"id_user\":%d,\"nama\":\"%s\",\"role\":\"%s\"}", idUser, nama, role);
                        System.out.println("[LOGIN SUKSES] " + nama + " (" + role + ")");
                    }
                } catch (SQLException e) {
                    System.out.println("[ERROR LOGIN]: " + e.getMessage());
                }

                exchange.getResponseHeaders().set("Content-Type", "application/json");
                exchange.sendResponseHeaders(200, jsonResponse.getBytes().length);
                OutputStream os = exchange.getResponseBody();
                os.write(jsonResponse.getBytes());
                os.close();
            }
        }
    }

    // 2. Handler Kategori Bibit (Melihat Katalog)
    static class KategoriHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            setupCORS(exchange);
            if ("OPTIONS".equals(exchange.getRequestMethod())) {
                exchange.sendResponseHeaders(204, -1);
                return;
            }

            if ("GET".equals(exchange.getRequestMethod())) {
                StringBuilder jsonBuilder = new StringBuilder("[");
                try (Connection conn = KoneksiDB.getConnection();
                     Statement stmt = conn.createStatement();
                     ResultSet rs = stmt.executeQuery("SELECT * FROM kategori_bibit")) {
                    
                    boolean first = true;
                    while (rs.next()) {
                        if (!first) jsonBuilder.append(",");
                        jsonBuilder.append(String.format("{\"id\":%d,\"nama_kategori\":\"%s\"}", rs.getInt("id_kategori"), rs.getString("nama_kategori")));
                        first = false;
                    }
                } catch (Exception e) {
                    System.out.println("[ERROR KATEGORI]: " + e.getMessage());
                }
                jsonBuilder.append("]");
                
                String response = jsonBuilder.toString();
                exchange.getResponseHeaders().set("Content-Type", "application/json");
                exchange.sendResponseHeaders(200, response.getBytes().length);
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            }
        }
    }

    // 3. Handler Melakukan Pemesanan (Checkout - Tanpa Ongkir)
    static class PesanHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            setupCORS(exchange);
            if ("OPTIONS".equals(exchange.getRequestMethod())) {
                exchange.sendResponseHeaders(204, -1);
                return;
            }

            if ("POST".equals(exchange.getRequestMethod())) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(exchange.getRequestBody()));
                StringBuilder body = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    body.append(line);
                }

                String reqBody = body.toString();
                String idUserStr = extractJsonValue(reqBody, "id_user");
                int idUser = idUserStr != null ? Integer.parseInt(idUserStr) : 1;

                int totalHarga = 15000; // Harga tetap bibit

                // Simpan ke database MySQL (Tanpa kolom ongkir)
                try (Connection conn = KoneksiDB.getConnection()) {
                    String sql = "INSERT INTO pesanan (id_user, total_harga, status_pesanan) VALUES (?, ?, ?)";
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    stmt.setInt(1, idUser);              
                    stmt.setInt(2, totalHarga);          
                    stmt.setString(3, "Pending");   

                    stmt.executeUpdate();
                    System.out.println("[SUKSES] Pesanan dari User ID " + idUser + " masuk ke database!");
                } catch (SQLException e) {
                    System.out.println("[ERROR DATABASE PESAN]: " + e.getMessage());
                }

                String response = "Sukses! Pesanan berhasil diproses backend Java.";
                exchange.sendResponseHeaders(200, response.getBytes().length);
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            }
        }
    }

    // 4. Handler Admin - Melihat & Mengelola Pesanan (GET - Tanpa Ongkir)
    static class AdminPesananHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            setupCORS(exchange);
            if ("OPTIONS".equals(exchange.getRequestMethod())) {
                exchange.sendResponseHeaders(204, -1);
                return;
            }

            if ("GET".equals(exchange.getRequestMethod())) {
                StringBuilder jsonBuilder = new StringBuilder("[");

                try (Connection conn = KoneksiDB.getConnection();
                     Statement stmt = conn.createStatement();
                     ResultSet rs = stmt.executeQuery(
                         "SELECT p.id_pesanan, COALESCE(u.nama_lengkap, 'Guest') AS nama_customer, " +
                         "p.total_harga, p.status_pesanan, p.tanggal_pesanan " +
                         "FROM pesanan p LEFT JOIN users u ON p.id_user = u.id_user"
                     )) {
                    
                    boolean first = true;
                    while (rs.next()) {
                        if (!first) jsonBuilder.append(",");
                        jsonBuilder.append("{");
                        jsonBuilder.append("\"id_pesanan\":").append(rs.getInt("id_pesanan")).append(",");
                        jsonBuilder.append("\"nama_customer\":\"").append(rs.getString("nama_customer")).append("\",");
                        jsonBuilder.append("\"total_harga\":").append(rs.getInt("total_harga")).append(",");
                        jsonBuilder.append("\"status_pesanan\":\"").append(rs.getString("status_pesanan")).append("\",");
                        jsonBuilder.append("\"tanggal_pesanan\":\"").append(rs.getString("tanggal_pesanan") != null ? rs.getString("tanggal_pesanan") : "-").append("\"");
                        jsonBuilder.append("}");
                        first = false;
                    }
                } catch (Exception e) {
                    System.out.println("[ERROR ADMIN PESANAN]: " + e.getMessage());
                }

                jsonBuilder.append("]");
                String response = jsonBuilder.toString();

                exchange.getResponseHeaders().set("Content-Type", "application/json");
                exchange.sendResponseHeaders(200, response.getBytes().length);
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            }
        }
    }

    // 5. Handler Admin - Memproses Pembayaran / Update Status (POST)
    static class UpdateStatusHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            setupCORS(exchange);
            if ("OPTIONS".equals(exchange.getRequestMethod())) {
                exchange.sendResponseHeaders(204, -1);
                return;
            }

            if ("POST".equals(exchange.getRequestMethod())) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(exchange.getRequestBody()));
                StringBuilder body = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    body.append(line);
                }

                String reqBody = body.toString();
                String idPesananStr = extractJsonValue(reqBody, "id_pesanan");
                String statusBaru = extractJsonValue(reqBody, "status");

                try (Connection conn = KoneksiDB.getConnection()) {
                    String sql = "UPDATE pesanan SET status_pesanan = ? WHERE id_pesanan = ?";
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    stmt.setString(1, statusBaru);
                    stmt.setInt(2, Integer.parseInt(idPesananStr));
                    stmt.executeUpdate();
                    
                    System.out.println("[STATUS DIUPDATE] Pesanan #" + idPesananStr + " menjadi " + statusBaru);
                } catch (SQLException e) {
                    System.out.println("[ERROR UPDATE STATUS]: " + e.getMessage());
                }

                String response = "Status pesanan berhasil diperbarui!";
                exchange.sendResponseHeaders(200, response.getBytes().length);
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            }
        }
    }

    // 6. Handler Customer - Melihat Status Pesanan Sendiri (POST - Tanpa Ongkir)
    static class CustomerPesananHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            setupCORS(exchange);
            if ("OPTIONS".equals(exchange.getRequestMethod())) {
                exchange.sendResponseHeaders(204, -1);
                return;
            }

            if ("POST".equals(exchange.getRequestMethod())) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(exchange.getRequestBody()));
                StringBuilder body = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    body.append(line);
                }

                String idUserStr = extractJsonValue(body.toString(), "id_user");
                int idUser = idUserStr != null ? Integer.parseInt(idUserStr) : 0;

                StringBuilder jsonBuilder = new StringBuilder("[");
                try (Connection conn = KoneksiDB.getConnection()) {
                    String sql = "SELECT id_pesanan, total_harga, status_pesanan, tanggal_pesanan FROM pesanan WHERE id_user = ?";
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    stmt.setInt(1, idUser);
                    ResultSet rs = stmt.executeQuery();

                    boolean first = true;
                    while (rs.next()) {
                        if (!first) jsonBuilder.append(",");
                        jsonBuilder.append("{");
                        jsonBuilder.append("\"id_pesanan\":").append(rs.getInt("id_pesanan")).append(",");
                        jsonBuilder.append("\"total_harga\":").append(rs.getInt("total_harga")).append(",");
                        jsonBuilder.append("\"status_pesanan\":\"").append(rs.getString("status_pesanan")).append("\",");
                        jsonBuilder.append("\"tanggal_pesanan\":\"").append(rs.getString("tanggal_pesanan") != null ? rs.getString("tanggal_pesanan") : "-").append("\"");
                        jsonBuilder.append("}");
                        first = false;
                    }
                } catch (SQLException e) {
                    System.out.println("[ERROR CUSTOMER PESANAN]: " + e.getMessage());
                }
                jsonBuilder.append("]");

                String response = jsonBuilder.toString();
                exchange.getResponseHeaders().set("Content-Type", "application/json");
                exchange.sendResponseHeaders(200, response.getBytes().length);
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            }
        }
    }

    private static String extractJsonValue(String json, String key) {
        try {
            String searchKey = "\"" + key + "\":";
            int start = json.indexOf(searchKey);
            if (start == -1) return null;
            start += searchKey.length();
            char firstChar = json.charAt(start);
            int end;
            if (firstChar == '"') {
                start++;
                end = json.indexOf('"', start);
            } else {
                end = json.indexOf(',', start);
                if (end == -1) end = json.indexOf('}', start);
            }
            return json.substring(start, end).trim();
        } catch (Exception e) {
            return null;
        }
    }

    private static void setupCORS(HttpExchange exchange) {
        exchange.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
        exchange.getResponseHeaders().add("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
        exchange.getResponseHeaders().add("Access-Control-Allow-Headers", "Content-Type");
    }
}