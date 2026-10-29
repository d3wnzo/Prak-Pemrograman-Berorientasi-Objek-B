package Interface;

public class Vivo implements Handphone {
    private int volume;
    private boolean menyala;

    public Vivo() {
        this.volume = 50;
    }

    @Override
    public void nyalakan() {
        menyala = true;
        System.out.println("Handphone menyala");
        System.out.println("Selamat datang di Vivo");
        System.out.println("Android version 11");
    }

    @Override 
    public void matikan() {
        menyala = false;
        System.out.println("Handphone dimatikan");
    }

    @Override 
    public void besarkanSuara() {
        if (menyala) {
            if (this.volume == MAX_VOLUME) {
                this.volume += 10;
                System.out.println("Volume Full");
            }
            else {
                System.out.println("sudah " + this.getVolume() + "%");
            }
            else {
                System.out.println("Handphone mat");
            }
        }

        public int getVolume() {
            return this.volume;
        }
    }
}