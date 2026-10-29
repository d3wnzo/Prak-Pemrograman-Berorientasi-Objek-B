package Interface;

public class Handphone {
    int MAX_VOLUME = 100;
    int MIN_VOLUME = 0;

    void nyalakanHP() {
        System.out.println("Handphone dinyalakan.");
    }
    void matikanHP() {
        System.out.println("Handphone dimatikan.");
    }
    void besarkanSuara() {
        System.out.println("Volume dinaikkan.");
    }
    void kecilkanSuara() {
        System.out.println("Volume diturunkan.");
    }
}