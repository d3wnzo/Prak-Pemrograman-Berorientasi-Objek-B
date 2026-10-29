package Abstract;

public class App {
    public static void main(String[] args) throws Exception {
        Segitiga s1 = new Segitiga(10, 6, "Biru");
        Lingkaran l1 = new Lingkaran(10, "Merah");

        s1.luas();
        l1.luas();
    }
}