package Pemesanan;

public class Main {

    public static void main(String[] args) {
        Kasir kasir = new Kasir() {
            int totalBelanja = 120000;

            @Override 
            public void hitungTotal() {
                System.out.println("Total Belanja: Rp " + totalBelanja);
            }

            @Override 
            public void tampilkanDiskon() {
                if (totalBelanja >= 100000) {
                    System.out.println("Diskon: Rp 10.000");
                    System.out.println("Total Bayar: Rp " + (totalBelanja - 10000));
                } else {
                    System.out.println("Tidak mendapat diskon.");
                }
            }
        };

        kasir.hitungTotal();
        kasir.tampilkanDiskon();
    }
}