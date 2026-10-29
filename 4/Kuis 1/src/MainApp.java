import Media.FileAkun;
import Media.AkunVerified;
public class MainApp {
    public static void main(String[] args) {
        FileAkun akunBiasa = new FileAkun("krisna");

        AkunVerified akunVerified = new AkunVerified();

        akunBiasa.displayInfo();
        akunVerified.displayInfo();
    }
}