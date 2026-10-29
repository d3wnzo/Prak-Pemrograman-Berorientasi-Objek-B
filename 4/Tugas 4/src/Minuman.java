public class Minuman extends Produk {
    private String ukuran;

    public Minuman(String nama, int hargaDasar, String ukuran) {
        super(nama, hargaDasar);
        this.ukuran = ukuran;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Ukuran      : " + ukuran);
    }
}