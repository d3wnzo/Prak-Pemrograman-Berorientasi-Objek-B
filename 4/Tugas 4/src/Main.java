public class Main {
    public static void main(String[] args) {
        Produk p1 = new Makanan("Roti Tawar", 15000, "10-10-2026");
        Produk p2 = new Minuman("Kopi Susu", 20000, "Large");

        System.out.println("=== PRODUK 1 (MAKANAN) ===");
        p1.displayInfo();
        System.out.println("Hitung 1 Pcs                  : Rp" + p1.hitungHarga());
        System.out.println("Hitung 3 Pcs                  : Rp" + p1.hitungHarga(3));
        System.out.println("Hitung 3 Pcs (Potongan 5000)  : Rp" + p1.hitungHarga(3, 5000));

        System.out.println("=== PRODUK 2 (MINUMAN) ===");
        p2.displayInfo();
        System.out.println("Hitung 1 Pcs                  : Rp" + p2.hitungHarga());
        System.out.println("Hitung 2 Pcs                  : Rp" + p2.hitungHarga(2));
        System.out.println("Hitung 2 Pcs (Potongan 2000)  : Rp" + p2.hitungHarga(2, 2000));
    }
}