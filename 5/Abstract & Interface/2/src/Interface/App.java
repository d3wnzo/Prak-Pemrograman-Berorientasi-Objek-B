package Interface;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Handphone Nafero = new Handphone();

        Scanner input = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("=== MENU ===");
            System.out.println("1. Nyalakan HP");
            System.out.println("2. Matikan HP");
            System.out.println("3. Besarkan Suara");
            System.out.println("4. Kecilkan Suara");
            System.out.println("5. Keluar");
            System.out.print("Pilih: ");
            pilihan = input.nextInt();

            switch (pilihan) {
                case 1 -> Nafero.nyalakanHP();
                case 2 -> Nafero.matikanHP();
                case 3 -> Nafero.besarkanSuara();
                case 4 -> Nafero.kecilkanSuara();
                case 5 -> System.out.println("Keluar dari program.");
                default -> System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 5);
        input.close();
    }
}