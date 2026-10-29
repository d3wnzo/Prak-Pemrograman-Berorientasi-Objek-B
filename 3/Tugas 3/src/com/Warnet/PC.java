package com.Warnet;

public class PC extends Komputer {
    protected String tipePC;

    public PC(String merk, String processor, int ram, String tipePC) {
        super(merk, processor, ram);
        this.tipePC = tipePC;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Tipe PC   : " + tipePC);
    }

    public void displayPcDetails() {
        System.out.println("=== DETAIL PC ===");
        displayInfo();
    }
}