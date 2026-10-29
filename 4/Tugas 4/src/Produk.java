public class Produk {
    protected String nama;
    protected int hargaDasar;

    public Produk(String nama, int hargaDasar) {
        this.nama = nama;
        this.hargaDasar = hargaDasar;
    }

    public void displayInfo() {
        System.out.println("Nama Produk : " + nama);
        System.out.println("Harga Dasar : Rp" + hargaDasar);
    }

    public int hitungHarga() {
        return hargaDasar;
    }

    public int hitungHarga(int jumlah) {
        return hargaDasar * jumlah;
    }

    public int hitungHarga(int jumlah, int potonganHarga) {
        return (hargaDasar * jumlah) - potonganHarga;
    }
}