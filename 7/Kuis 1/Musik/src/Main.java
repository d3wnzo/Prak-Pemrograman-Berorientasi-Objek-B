public class Main {
    public static void main(String[] args) {

        Musik musik = new Musik() {
            @Override 
            public void putar() {
                System.out.println("Musik Rock sedang diputar.");
            }
        };

        System.out.println("\n--- Lagu yang diputar ---");
        musik.putar();
    }
}