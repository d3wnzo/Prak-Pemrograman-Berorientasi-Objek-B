class MobilSport {
    private String nama;

    public MobilSport(String nama) {
        this.nama = nama;
    }

    public void gigi(int g) {
        System.out.println(this.nama + " masuk gigi ke-" + g);
    }

    public void gigi(int g, int t) {
        System.out.println(this.nama + " masuk gigi ke-" + g + " dengan turbo " + t);
    }

    public static void main(String[] args) throws Exception {
        MobilSport jaguar = new MobilSport("Jaguar");

        jaguar.gigi(1);
        jaguar.gigi(2);
        jaguar.gigi(3);
        jaguar.gigi(4);
        jaguar.gigi(5);
        jaguar.gigi(1, 1);
        jaguar.gigi(2, 1);
        jaguar.gigi(3, 1);
        jaguar.gigi(4, 1);
        jaguar.gigi(5, 1);
        jaguar.gigi(5, 2);
        jaguar.gigi(5, 3);
        jaguar.gigi(5, 4);
        jaguar.gigi(5, 5);
    }
}