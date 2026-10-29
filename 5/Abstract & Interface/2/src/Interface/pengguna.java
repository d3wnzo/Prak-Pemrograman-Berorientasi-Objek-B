package Interface;

public class pengguna {
    private Handphone phone;

    public pengguna(Handphone phone) {
        this.phone = phone;
    }

    void nyalakanHP() {
        this.phone.nyalakanHP();
    }

    void matikanHP() {
        this.phone.matikanHP();
    }

    void besarkanSuara() {
        this.phone.besarkanSuara();
    }

    void kecilkanSuara() {
        this.phone.kecilkanSuara();
    }
}