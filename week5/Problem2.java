package week5;
import java.util.*;

public class Problem2 {
    static final List<String> MODS = List.of("private", "default", "protected", "public");
    static final List<String> CTX = List.of("SAME_CLASS", "SAME_PACKAGE", "DIFFERENT_PACKAGE",
            "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE", "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE");
    static final int[] NEED = {0, 1, 3, 2, 3};   // OWN_TYPE lets protected through; PARENT_TYPE does not

    static String classifyAccess(String fieldModifier, String accessorContext) {
        int f = MODS.indexOf(fieldModifier), c = CTX.indexOf(accessorContext);
        return f >= 0 && c >= 0 && f >= NEED[c] ? "ALLOWED" : "DENIED";
    }

    public static void main(String[] args) {
        System.out.println(classifyAccess("protected", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"));
        System.out.println(classifyAccess("protected", "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"));
        System.out.println(classifyAccess("private", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"));
    }
}
