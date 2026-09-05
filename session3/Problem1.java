package session3;
import java.util.*;

class MovieTicket {
    private String seatNumber;      // internal booking detail
    String screenId;                // default: package-level scheduling code
    protected double ticketPrice;   // subclasses (PremiumMovieTicket) need it
    public String movieTitle;       // shown everywhere
}

public class Problem1 {
    static final List<String> MODS = List.of("private", "default", "protected", "public");
    static final List<String> CTX = List.of("SAME_CLASS", "SAME_PACKAGE", "DIFFERENT_PACKAGE");
    static final int[] NEED = {0, 1, 3};   // minimum modifier level each context requires

    static String classifyAccess(String fieldModifier, String accessorContext) {
        int f = MODS.indexOf(fieldModifier), c = CTX.indexOf(accessorContext);
        return f >= 0 && c >= 0 && f >= NEED[c] ? "ALLOWED" : "DENIED";
    }

    static String summarizeBatch(String[][] attempts) {
        int a = 0;
        for (String[] t : attempts) if (classifyAccess(t[0], t[1]).equals("ALLOWED")) a++;
        return "Allowed: " + a + " | Denied: " + (attempts.length - a);
    }

    public static void main(String[] args) {
        System.out.println(classifyAccess("private", "SAME_CLASS"));
        System.out.println(classifyAccess("protected", "DIFFERENT_PACKAGE"));
        System.out.println(summarizeBatch(new String[][]{{"default", "SAME_PACKAGE"},
                {"default", "DIFFERENT_PACKAGE"}, {"public", "DIFFERENT_PACKAGE"}}));
    }
}
