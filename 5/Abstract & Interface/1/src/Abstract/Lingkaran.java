package Abstract;

public class Lingkaran extends BangunDatar {
    private int jariJari;

    public Lingkaran(int jariJari, String warna) {
        this.jariJari = jariJari;
        this.warna = warna;
    }

    public void luas() {
        float luas;

        luas = (float) ((22.0 / 7) * this.jariJari * this.jariJari);

        System.out.println("Luas Lingkaran : " + luas);
    }
}