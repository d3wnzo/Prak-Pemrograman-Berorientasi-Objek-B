package com.Warnet;

public class PCStandar extends PC {
    private double ukuranMonitor;

    public PCStandar(String merk, String processor, int ram, double ukuranMonitor) {
        super(merk, processor, ram, "Standar");
        this.ukuranMonitor = ukuranMonitor;
    }

    @Override
    public void displayPcDetails() {
        super.displayPcDetails();
    }

    public void showMonitorDetails() {
        System.out.println("Ukuran Monitor : " + ukuranMonitor + " Inci");
    }
}