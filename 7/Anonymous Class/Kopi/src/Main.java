public class Main {
    public static void main(String[] args) {

        Kopi kopiBiasa = new Kopi();

        Kopi kopiSusu = new Kopi() {
            @Override 
            public void racik() {
                System.out.println("Racikan 1: Espresso + Susu UHT + Gula Aren cair.");
            }
        };

        Kopi kopiAlpukat = new Kopi() {
            @Override 
            public void racik() {
                System.out.println("Racikan 2: Jus alpukat kental + 1 shot Espresso + Es krim cokelat.");
            }
        };

        kopiBiasa.racik();

        System.out.println("\n--- Pesanan Pertama ---");
        kopiSusu.racik();

        System.out.println("\n--- Pesanan Kedua ---");
        kopiAlpukat.racik();
    }
}
