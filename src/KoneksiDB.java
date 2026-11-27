import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class KoneksiDB {
    private static final String URL = "jdbc:mysql://localhost:3306/bibit_pepaya?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";     
    private static final String PASSWORD = "";     

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("[ERROR] Driver MySQL JDBC tidak ditemukan: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("[ERROR] Gagal konek ke MySQL: " + e.getMessage());
        }
        return conn;
    }
}