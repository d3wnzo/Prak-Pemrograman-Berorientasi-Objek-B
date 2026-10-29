class Kendaraan {
    public void bergerak() {
        System.out.println("Kendaraan sedang bergerak.");
    }
}

class Mobil extends Kendaraan {
    @Override
    public void bergerak() {
        System.out.println("Mobil berjalan diatas jalan raya dengan roda berputar.");
    }
}

class Perahu extends Kendaraan {
    @Override
    public void bergerak() {
        System.out.println("Perahu melaju di atas air dengan baling-baling.");
    }
}

class Pesawat extends Kendaraan {
    @Override
    public void bergerak() {
        System.out.println("Pesawat terbang menembus awan dengan mesin jet.");
    }

    public static void main(String[] args) {
        Kendaraan[] armada = new Kendaraan[3];
        armada[0] = new Mobil();
        armada[1] = new Perahu();
        armada[2] = new Pesawat();

        for (Kendaraan k : armada) {
            k.bergerak();
        }
    }
}