public class Pemilik {
    private TransferBank tf;

    public Pemilik(TransferBank tf) {
        this.tf = tf;
    }

    void transfer() {
        System.out.println("Nomor Rekening: " + tf.nomorRekening);
        System.out.println("Jumlah Transfer: " + tf.jumlahTransfer);
    }

    void bayar() {
        System.out.println("Pembayaran berhasil dilakukan.");
    }
}
