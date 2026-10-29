package com.Warnet;

public class Komputer {
    protected String merk;
    protected String processor;
    protected int ram;

    public Komputer(String merk, String processor, int ram) {
        this.merk = merk;
        this.processor = processor;
        this.ram = ram;
    }

    public void displayInfo() {
        System.out.println("Merk      : " + merk);
        System.out.println("Processor : " + processor);
        System.out.println("RAM       : " + ram + " GB");
    }
}