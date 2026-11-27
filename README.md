Nih, bro! Gue bikinin versi **README.md** yang ringkas dan udah include langsung cara *compile* sama *running* lewat terminal/CMD biar lu tinggal *copy-paste* aja:

```markdown
# 🌿 Aplikasi Penjualan Bibit Pepaya (Java Native & Web)

Aplikasi berbasis web untuk sistem penjualan dan pemesanan bibit pepaya yang dibangun menggunakan **Java HttpServer (Backend)**, **MySQL / HeidiSQL (Database)**, dan **HTML/JavaScript (Frontend)**.

---

## 🛠️ Tech Stack
* **Backend**: Java Native (`com.sun.net.httpserver.HttpServer`)
* **Frontend**: HTML5, CSS3, JavaScript (Vanilla JS dengan Fetch API)
* **Database**: MySQL / HeidiSQL
* **Driver**: MySQL Connector/J (`mysql-connector-j.jar`)

---

## ⚙️ Cara Compile & Menjalankan Program

### 1. Persiapan Database
1. Buka **HeidiSQL** atau MySQL Client.
2. Buat database baru bernama `bibit_pepaya` dan jalankan file script `.sql` yang tersedia untuk membuat struktur tabel beserta data akun/kategori awal.
3. Pastikan konfigurasi di file `KoneksiDB.java` sudah sesuai dengan username & password MySQL lokalmu.

### 2. Compile & Run Backend (Via Terminal / CMD)
Pastikan file driver **MySQL Connector/J** (`.jar`) berada di dalam folder project yang sama dengan file `.java`.

1. Buka **Terminal / Command Prompt (CMD)** dan masuk ke direktori folder project:
   ```bash
   cd path/ke/folder/project

```

2. **Compile** file Java (`Server.java` dan `KoneksiDB.java`):
* **Windows:**
```cmd
javac -d . -cp "../lib/mysql-connector-j-26.10.0.jar" Server.java KoneksiDB.java
```
*(Catatan: Sesuaikan `mysql-connector-j.jar` dengan nama file driver `.jar` yang digunakan).*
3. **Jalankan** Server Java:
* **Windows:**
```cmd
java -cp ".;../lib/mysql-connector-j-26.10.0.jar" Server
```

4. Jika berhasil, terminal akan menampilkan pesan:
```text
=== SERVER JAVA BERHASIL JALAN DI http://localhost:8080 ===
```



### 3. Menjalankan Frontend

1. Buka folder project di file explorer.
2. Buka file **`login.html`** menggunakan browser (Chrome/Edge/Firefox) atau jalankan melalui ekstensi *Live Server* di VS Code.

---

## 👥 Akun Demo (Testing)

* **Admin**:
* **Email**: `admin@bibit.com`
* **Password**: `admin123`


* **Customer**:
* **Email**: `cust@gmail.com`
* **Password**: `cust123`
