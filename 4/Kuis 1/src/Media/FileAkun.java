package Media;

public class FileAkun {
    private String username;

    public FileAkun(String username) {
        this.username = username;
    }
        public void displayInfo() {
            System.out.println("Username: " + username + "(Akun Biasa)");
        }
        public static void main(String[] args) {
        FileAkun akun = new FileAkun("Krisna");
        akun.displayInfo();
    }
}