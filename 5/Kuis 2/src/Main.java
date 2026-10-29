public class Main {
    public static void main(String[] args) throws Exception {
        TransferBank transfer = new TransferBank(123456, 1000000);
        Pemilik pemilik = new Pemilik(transfer);
        pemilik.transfer();
        pemilik.bayar();
    }
}
