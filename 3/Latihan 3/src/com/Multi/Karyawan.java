package com.Multi;

class Karyawan {
    double gaji = 5000000;

    void infoGaji() {
        System.out.println("Gaji Pokok: " + gaji);
    }
}

class Programmer extends Karyawan {
    double bonus = 1000000;

    void infoBonus() {
        System.out.println("Bonus: " + bonus);
    }
}

class seniorProgrammer extends Programmer {
    double tunjangan = 2000000;

    void totalGaji() {
        double total = gaji + bonus + tunjangan;
        System.out.println("Total Gaji: " + total);
    }

    void infoLengkap() {
        infoGaji();
        infoBonus();
        System.out.println("Tunjangan: " + tunjangan);
        totalGaji();
    }

    public static void main(String[] args) {
        seniorProgrammer sp = new seniorProgrammer();
        sp.infoLengkap();
    }
}