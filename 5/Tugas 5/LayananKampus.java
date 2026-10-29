abstract class Pembayaran {
    protected String namaMahasiswa;
    protected String jenisLayanan;
    protected int jumlahPeserta;
    protected int biayaPerPeserta;

    public Pembayaran(String namaMahasiswa, String jenisLayanan, int jumlahPeserta, int biayaPerPeserta) {
        this.namaMahasiswa = namaMahasiswa;
        this.jenisLayanan = jenisLayanan;
        this.jumlahPeserta = jumlahPeserta;
        this.biayaPerPeserta = biayaPerPeserta;
    }

    public abstract int hitungTotal();

    public void tampilkanData() {
        System.out.println("Nama Mahasiswa : " + namaMahasiswa);
        System.out.println("Jenis Layanan  : " + jenisLayanan);
        System.out.println("Jumlah Peserta : " + jumlahPeserta);
        System.out.println("Biaya/Peserta  : Rp" + biayaPerPeserta);
    }
}

interface DapatDiskon {
    int hitungDiskon();
    int hitungTotalSetelahDiskon();
}

public class LayananKampus extends Pembayaran implements DapatDiskon {

    public LayananKampus(String namaMahasiswa, String jenisLayanan, int jumlahPeserta, int biayaPerPeserta) {
        super(namaMahasiswa, jenisLayanan, jumlahPeserta, biayaPerPeserta);
    }

    @Override
    public int hitungTotal() {
        return jumlahPeserta * biayaPerPeserta;
    }

    @Override
    public int hitungDiskon() {
        int total = hitungTotal();
        int persentaseDiskon = 0;

        if (jenisLayanan.equalsIgnoreCase("Seminar kampus")) {
            if (jumlahPeserta >= 5) {
                persentaseDiskon = 10;
            }
        } else if (jenisLayanan.equalsIgnoreCase("Pelatihan sertifikasi")) {
            if (jumlahPeserta >= 3) {
                persentaseDiskon = 15;
            }
        }

        return (total * persentaseDiskon) / 100;
    }

    @Override
    public int hitungTotalSetelahDiskon() {
        return hitungTotal() - hitungDiskon();
    }

    public void tampilkanRincianLengkap() {
        tampilkanData();
        System.out.println("Total Sebelum Diskon : Rp" + hitungTotal());
        System.out.println("Nominal Diskon       : Rp" + hitungDiskon());
        System.out.println("Total Setelah Diskon : Rp" + hitungTotalSetelahDiskon());
        System.out.println("----------------------------------------");
    }

    public static void main(String[] args) {
        LayananKampus mhs1 = new LayananKampus("Andi", "Seminar kampus", 6, 50000);
        LayananKampus mhs2 = new LayananKampus("Budi", "Pelatihan sertifikasi", 2, 200000);

        System.out.println("=== SISTEM PEMBAYARAN LAYANAN KAMPUS ===\n");
        mhs1.tampilkanRincianLengkap();
        mhs2.tampilkanRincianLengkap();
    }
}