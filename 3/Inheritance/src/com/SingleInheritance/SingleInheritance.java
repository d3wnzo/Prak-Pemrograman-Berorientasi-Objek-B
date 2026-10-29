package com.SingleInheritance;

class Hewan {
    void makan() {
        System.out.println("Hewan sedang makan");
    }
}

class Kucing extends Hewan {
    void suara() {
        System.out.println("Meow Meow");
    }
}

public class SingleInheritance {
    public static void main(String[] args) {
        Kucing k = new Kucing();
        k.makan();
        k.suara();
    }
}