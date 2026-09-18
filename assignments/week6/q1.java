class LibraryMember{
    private String membershipPin;
    String branchCode;
    protected double finesOwed;
    public String displayName;
}
class AccessChecker{
    static String classifyAccess(String fieldModifier, String accessorContext){
        boolean allowed;
        switch(fieldModifier){
            case "private":
                allowed = accessorContext.equals("SAME_CLASS");
                break;
            case "default":
                allowed = accessorContext.equals("SAME_CLASS") || accessorContext.equals("SAME_PACKAGE");
                break;
            case "protected":
                allowed = accessorContext.equals("SAME_CLASS")
                        || accessorContext.equals("SAME_PACKAGE")
                        || accessorContext.equals("SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE");
                break;
            case "public":
                allowed = true;
                break;
            default:
                allowed = false;
        }
        return allowed ? "ALLOWED" : "DENIED";
    }
    static String summarizeByModifier(String[][] attempts){
        String[] modifiers = {"private", "default", "protected", "public"};
        int[] allowedCounts = new int[4];
        int[] deniedCounts = new int[4];
        for(int i = 0; i<attempts.length; i++){
            String modifier = attempts[i][0];
            String context = attempts[i][1];
            String result = classifyAccess(modifier, context);
            int idx = -1;
            for(int j = 0; j<modifiers.length; j++){
                if(modifiers[j].equals(modifier)){
                    idx = j;
                    break;
                }
            }
            if(result.equals("ALLOWED")){
                allowedCounts[idx]++;
            } else {
                deniedCounts[idx]++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<modifiers.length; i++){
            sb.append(modifiers[i] + ": " + allowedCounts[i] + " allowed / " + deniedCounts[i] + " denied");
            if(i < modifiers.length - 1){
                sb.append(" | ");
            }
        }
        return sb.toString();
    }
}
public class q1{
    public static void main(String args[]){
        System.out.println(AccessChecker.classifyAccess("private", "SAME_CLASS"));
        System.out.println(AccessChecker.classifyAccess("protected", "DIFFERENT_PACKAGE"));
        System.out.println(AccessChecker.summarizeByModifier(new String[][]{
            {"private", "SAME_CLASS"},
            {"private", "SAME_PACKAGE"},
            {"default", "SAME_PACKAGE"},
            {"default", "DIFFERENT_PACKAGE"},
            {"protected", "SAME_PACKAGE"},
            {"protected", "SAME_CLASS"},
            {"public", "DIFFERENT_PACKAGE"}
        }));
    }
}
