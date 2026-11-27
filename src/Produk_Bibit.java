public class Produk_Bibit {
    private int idBibit;
    private String namaBibit;
    private int harga;
    private int stok;
    private String umurBibit;
    private String deskripsi;

    // Constructor
    public Produk_Bibit(int idBibit, String namaBibit, int harga, int stok, String umurBibit, String deskripsi) {
        this.idBibit = idBibit;
        this.namaBibit = namaBibit;
        this.harga = harga;
        this.stok = stok;
        this.umurBibit = umurBibit;
        this.deskripsi = deskripsi;
    }

    // Method OOP untuk mengurangi stok
    public void kurangiStok(int jumlah) {
        if (this.stok >= jumlah) {
            this.stok -= jumlah;
            System.out.println("[INFO] Stok " + this.namaBibit + " berhasil dikurangi. Sisa stok: " + this.stok);
        } else {
            System.out.println("[WARNING] Stok tidak mencukupi!");
        }
    }

    // Getter (sekarang semua variabel terpakai atau siap dipanggil kapan aja)
    public int getIdBibit() { return idBibit; }
    public String getNamaBibit() { return namaBibit; }
    public int getHarga() { return harga; }
    public int getStok() { return stok; }
    public String getUmurBibit() { return umurBibit; }
    public String getDeskripsi() { return deskripsi; }
}