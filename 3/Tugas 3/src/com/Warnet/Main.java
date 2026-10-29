package com.Warnet;

public class Main {
    public static void main(String[] args) {
        PCStandar pcStandar = new PCStandar("Lenovo", "Intel i5-13900K", 16, 16.5);
        
        PCVIP pcVip = new PCVIP("Lenovo", "Intel i9-13900K", 32, "Kursi Gaming, Ruang AC, Snack Gratis");

        System.out.println("========== PC STANDAR ==========");
        pcStandar.displayPcDetails();
        pcStandar.showMonitorDetails();

        System.out.println("========== PC VIP ==========");
        pcVip.displayPcDetails();
        pcVip.showFasilitasDetails();
    }
}