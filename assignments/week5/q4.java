class GymMember{
    protected String memberId;
    protected int monthlyFee;
    protected int sessionsAttended;
    GymMember(String memberId, int monthlyFee){
        this.memberId = memberId;
        this.monthlyFee = monthlyFee;
    }
    String displayInfo(){
        return "Standard | Sessions: " + sessionsAttended;
    }
}
class PremiumMember extends GymMember{
    String trainerName;
    PremiumMember(String memberId, int monthlyFee, String trainerName){
        super(memberId, monthlyFee);
        this.trainerName = trainerName;
    }
    String displayInfo(){
        return "Premium | Trainer: " + trainerName + " | Sessions: " + sessionsAttended;
    }
}
public class q4{
    static String batchPrint(GymMember[] members){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<members.length; i++){
            sb.append(members[i].displayInfo());
            if(members[i] instanceof PremiumMember){
                PremiumMember pm = (PremiumMember) members[i];
                sb.append(" [Trainer via downcast: " + pm.trainerName + "]");
            }
            sb.append(" | ");
        }
        return sb.toString();
    }
    public static void main(String args[]){
        GymMember[] members = { new GymMember("MEM6", 1000), new PremiumMember("MEM7", 2000, "Coach Riya") };
        System.out.println(batchPrint(members));
        try{
            GymMember plain = new GymMember("MEM8", 1000);
            PremiumMember bad = (PremiumMember) plain;
        } catch(ClassCastException e){
            System.out.println("ClassCastException at runtime");
        }
    }
}
