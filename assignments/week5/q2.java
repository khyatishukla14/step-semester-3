class GymMember{
    protected String memberId;
    protected int monthlyFee;
    protected int sessionsAttended;
    GymMember(String memberId, int monthlyFee){
        this.memberId = memberId;
        this.monthlyFee = monthlyFee;
    }
    void attendSession(){
        sessionsAttended++;
    }
    int getSessionsAttended(){
        return sessionsAttended;
    }
    String displayInfo(){
        return "Standard Member | Sessions: " + sessionsAttended;
    }
}
class PremiumMember extends GymMember{
    protected String trainerName;
    PremiumMember(String memberId, int monthlyFee, String trainerName){
        super(memberId, monthlyFee);
        this.trainerName = trainerName;
    }
    String displayInfo(){
        return "Premium Member | Trainer: " + trainerName + " | Sessions: " + sessionsAttended;
    }
}
class EliteMember extends PremiumMember{
    private String lockerNumber;
    EliteMember(String memberId, int monthlyFee, String trainerName, String lockerNumber){
        super(memberId, monthlyFee, trainerName);
        this.lockerNumber = lockerNumber;
    }
    String displayInfo(){
        return "Elite Member | Trainer: " + trainerName + " | Locker: " + lockerNumber + " | Sessions: " + sessionsAttended;
    }
}
class GroupClassMember extends GymMember{
    private String className;
    GroupClassMember(String memberId, int monthlyFee, String className){
        super(memberId, monthlyFee);
        this.className = className;
    }
    String displayInfo(){
        return "Group Class Member | Class: " + className + " | Sessions: " + sessionsAttended;
    }
}
public class q2{
    static String classifyGeneration(GymMember member){
        if(member instanceof EliteMember){
            return "Multilevel descendant (3 generations deep)";
        } else if(member instanceof GroupClassMember){
            return "Hierarchical sibling (independent branch)";
        } else if(member instanceof PremiumMember){
            return "Direct child (2 generations deep)";
        } else {
            return "Root class (base generation)";
        }
    }
    static int getTotalSessionsAttended(GymMember[] members){
        int total = 0;
        for(int i = 0; i<members.length; i++){
            total = total + members[i].getSessionsAttended();
        }
        return total;
    }
    public static void main(String args[]){
        GymMember g = new GymMember("MEM1", 1000);
        PremiumMember pm = new PremiumMember("MEM2", 2000, "Coach Riya");
        EliteMember em = new EliteMember("MEM3", 3000, "Coach Arjun", "L12");
        GroupClassMember gcm = new GroupClassMember("MEM4", 1500, "Zumba");
        System.out.println(g.displayInfo());
        System.out.println(pm.displayInfo());
        System.out.println(em.displayInfo());
        System.out.println(gcm.displayInfo());
        System.out.println(classifyGeneration(em));
        System.out.println(classifyGeneration(gcm));
        for(int i = 0; i<3; i++){ pm.attendSession(); }
        for(int i = 0; i<2; i++){ em.attendSession(); }
        for(int i = 0; i<4; i++){ gcm.attendSession(); }
        System.out.println(getTotalSessionsAttended(new GymMember[]{pm, em, gcm}));
    }
}
