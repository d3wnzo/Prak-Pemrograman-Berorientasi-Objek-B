class Pesan {
    void pesan() {
    }
}

class Pesan1 extends Pesan {
    public void pesan(int p) {
        System.out.println("Kirim Pesan Standar " + p);
    }
    
    public void pesan(int p, int m) {
        System.out.println("Kirim Pesan ke " + p + " dengan Mode " + m);
    }

    public static void main(String[] args) {
        Pesan1 p = new Pesan1();
        p.pesan(1);
        p.pesan(2, 3);
    }
}