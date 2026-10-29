package com.Perpustakaan;

public class Buku {
    private String judul;
    private String penulis;
    private int tahunTerbit;
    private int stok;

    public Buku() {
        this.judul = "Belum diisi";
        this.penulis = "Belum diisi";
        this.tahunTerbit = 0;
        this.stok = 0;
    }

    public Buku(String judul, String penulis, int tahunTerbit, int stok) {
        this.judul = judul;
        this.penulis = penulis;
        this.tahunTerbit = tahunTerbit;
        this.stok = stok;
    }

    public String getJudul() { return judul; }
    public void setJudul(String judul) { this.judul = judul; }

    public String getPenulis() { return penulis; }
    public void setPenulis(String penulis) { this.penulis = penulis; }

    public int getTahunTerbit() { return tahunTerbit; }
    public void setTahunTerbit(int tahunTerbit) { this.tahunTerbit = tahunTerbit; }

    public int getStok() { return stok; }
    public void setStok(int stok) { this.stok = stok; }

    public void tampilkanInfo() {
        System.out.println("Judul        : " + judul);
        System.out.println("Penulis      : " + penulis);
        System.out.println("Tahun Terbit : " + tahunTerbit);
        System.out.println("Stok         : " + stok);
        System.out.println("===============================");
    }

    public static void main(String[] args) {
        Buku buku1 = new Buku();
        buku1.setJudul("Pemrograman Java Dasar");
        buku1.setPenulis("Budi Santoso");
        buku1.setTahunTerbit(2021);
        buku1.setStok(10);

        Buku buku2 = new Buku("Struktur Data", "Rian Ardianto", 2020, 5);
        Buku buku3 = new Buku("Sistem Basis Data", "Siti Rahma", 2019, 8);
        Buku buku4 = new Buku("Jaringan Komputer", "Dedi Kurniawan", 2022, 12);

        System.out.println("=== DAFTAR BUKU PERPUSTAKAAN ===\n");
        buku1.tampilkanInfo();
        buku2.tampilkanInfo();
        buku3.tampilkanInfo();
        buku4.tampilkanInfo();
    }
}