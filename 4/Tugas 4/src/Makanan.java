public class Makanan extends Produk {
    private String tanggalKadaluarsa;

    public Makanan(String nama, int hargaDasar, String tanggalKadaluarsa) {
        super(nama, hargaDasar);
        this.tanggalKadaluarsa = tanggalKadaluarsa;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Kadaluarsa  : " + tanggalKadaluarsa);
    }
}