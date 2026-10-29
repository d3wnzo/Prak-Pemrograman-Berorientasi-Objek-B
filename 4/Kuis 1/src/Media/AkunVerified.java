package Media;

public class AkunVerified {
    public void displayInfo() {
        System.out.println("Username: " + "krisna" + "(Akun Verified)");
    }
}

class user extends AkunVerified {
    @Override 
    public void displayInfo() {
        System.out.println("Username: " + "krisna" + "(Akun Verified)");
    }
}