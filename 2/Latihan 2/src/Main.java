import com.Biodata.Mahasiswa;
public class Main {
    public static void main(String[] args) {
        Mahasiswa krisna = new Mahasiswa(
            "4524210077",
            "Nayunda ",
            "Krisna",
            "06-06-2006",
            "Bogor",
            "20"
        );

        Mahasiswa nafero =  new Mahasiswa(
            "4524210074",
            "Nafero ",
            "Rafif",
            "10-04-2006",
            "Tebet",
            "20"
        );

        krisna.displayInfo();
        nafero.displayInfo();

        krisna.belajar();
        nafero.ujian();
    }    
}