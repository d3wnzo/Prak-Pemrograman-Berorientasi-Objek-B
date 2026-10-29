public class PemesananKafe {
    private static String namaBrand = "Kopi Senja Utama";
    private String namaCabang;
    private String menuMinuman;
    private int hargaDasar;

    public PemesananKafe(String namaCabang, String menuMinuman, int hargaDasar) {
        this.namaCabang = namaCabang;
        this.menuMinuman = menuMinuman;
        this.hargaDasar = hargaDasar;
    }

    public class Pesanan {
        private String namaPelanggan;
        private int jumlahGelas;
        private String catatan;

        public Pesanan(String namaPelanggan, int jumlahGelas, String catatan) {
            this.namaPelanggan = namaPelanggan;
            this.jumlahGelas = jumlahGelas;
            this.catatan = catatan;
        }

        public int hitungTotalBayar() {
            return jumlahGelas * hargaDasar;
        }

        public void tampilkanPemesanan() {
            System.out.println("Brand Kafe       : " + namaBrand);
            System.out.println("Cabang           : " + namaCabang);
            System.out.println("Menu Minuman     : " + menuMinuman);
            System.out.println("Harga Dasar      : Rp" + hargaDasar);
            System.out.println("Nama Pelanggan   : " + namaPelanggan);
            System.out.println("Jumlah Gelas     : " + jumlahGelas);
            System.out.println("Catatan          : " + catatan);
            System.out.println("Total Bayar      : Rp" + hitungTotalBayar());
            System.out.println("----------------------------------------");
        }
    }

    public static void main(String[] args) {
        PemesananKafe kafe1 = new PemesananKafe("Kemang", "Caramel Macchiato", 28000);
        PemesananKafe.Pesanan pesanan1 = kafe1.new Pesanan("Dimas", 2, "Less Sugar");

        PemesananKafe kafe2 = new PemesananKafe("Dago", "Americano", 20000);
        PemesananKafe.Pesanan pesanan2 = kafe2.new Pesanan("Alya", 3, "Extra Ice");

        System.out.println("=== SISTEM PEMESANAN MINUMAN KAFE ===\n");
        pesanan1.tampilkanPemesanan();
        pesanan2.tampilkanPemesanan();
    }
}