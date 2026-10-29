package com.Buku;

class Buku {
    
    String judul;
    String penulis;
    int tahunTerbit;
    boolean isDipinjam;

    public Buku(String judul, String penulis, int tahunTerbit) {
        this.judul = judul;
        this.penulis = penulis;
        this.tahunTerbit = tahunTerbit;
        this.isDipinjam = false;
    }

    public void Dipinjam() {
        if (!isDipinjam) {
            isDipinjam = true;
            System.out.println("Buku '" + judul + "' berhasil dipinjam.");
        } else {
            System.out.println("Buku '" + judul + "' sedang dipinjam oleh orang lain.");
        }
    }

    public void Dikembalikan() {
        if (isDipinjam) {
            isDipinjam = false;
            System.out.println("Buku '" + judul + "' berhasil dikembalikan.");
        } else {
            System.out.println("Buku '" + judul + "' belum pernah dipinjam.");
        }
    }

    public void MenampilkanInfo() {
        System.out.println("===================================");
        System.out.println("Judul        : " + judul);
        System.out.println("Penulis      : " + penulis);
        System.out.println("Tahun Terbit : " + tahunTerbit);
        System.out.println("Status       : " + (isDipinjam ? "Sedang Dipinjam" : "Tersedia"));
        System.out.println("===================================");
    }

    public static void main(String[] args) {
        Buku buku1 = new Buku("Laskar Pelangi", "Andrea Hirata", 2005);
        Buku buku2 = new Buku("Bumi Manusia", "Pramoedya Ananta Toer", 1980);
        Buku buku3 = new Buku("Filosofi Teras", "Henry Manampiring", 2018);
        Buku buku4 = new Buku("Cantik Itu Luka", "Eka Kurniawan", 2002);

        System.out.println("=== DAFTAR BUKU ===");
        buku1.MenampilkanInfo();
        buku2.MenampilkanInfo();
        buku3.MenampilkanInfo();
        buku4.MenampilkanInfo();

        System.out.println("=== SIMULASI TRANSAKSI ===");
        buku1.Dipinjam();
        buku3.Dipinjam();
        
        buku1.Dipinjam(); 

        buku1.Dikembalikan();

        System.out.println("=== STATUS BUKU 1 TERBARU ===");
        buku1.MenampilkanInfo();
    }
}