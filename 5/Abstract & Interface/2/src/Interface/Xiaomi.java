package Interface;

public class Xiaomi implements Handphone {
    private int volume;
    private boolean menyala;

    public Xiaomi() {
        this.volume = 50;
        this.menyala = false;
    }

    @Override
    public void nyalakan() {
        menyala = true;
        System.out.println("Handphone menyala");
        System.out.println("Selamat datang di Xiaomi");
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