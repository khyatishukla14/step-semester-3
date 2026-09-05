package session3;
class MovieBookingProfile {
    private String name;
    private boolean confirmed;
    private String otp;                      // write-only: no getter anywhere

    public MovieBookingProfile() { }
    public MovieBookingProfile(String name) { this(); setName(name); }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public boolean isConfirmed() { return confirmed; }
    public void setConfirmed(boolean confirmed) { this.confirmed = confirmed; }
    public void setOtp(String otp) { this.otp = otp; }
}

public class Problem4 {
    public static void main(String[] args) {
        System.out.println(new MovieBookingProfile("Rahul Dev").getName());
        MovieBookingProfile p = new MovieBookingProfile("Rahul Dev");
        p.setConfirmed(true);
        System.out.println(p.isConfirmed());
        p.setOtp("4471");                    // no observable output
    }
}
