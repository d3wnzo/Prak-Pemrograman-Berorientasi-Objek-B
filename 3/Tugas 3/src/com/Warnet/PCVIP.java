package com.Warnet;

public class PCVIP extends PC {
    private String fasilitas;

    public PCVIP(String merk, String processor, int ram, String fasilitas) {
        super(merk, processor, ram, "VIP");
        this.fasilitas = fasilitas;
    }

    @Override
    public void displayPcDetails() {
        super.displayPcDetails();
    }

    public void showFasilitasDetails() {
        System.out.println("Fasilitas VIP  : " + fasilitas);
    }
}