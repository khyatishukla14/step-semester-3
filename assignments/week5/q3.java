import java.util.Arrays;
class GymMember{
    protected String memberId;
    protected int monthlyFee;
    private int[] lateFees = new int[10];
    private int feeCount = 0;
    GymMember(String memberId, int monthlyFee){
        this.memberId = memberId;
        this.monthlyFee = monthlyFee;
    }
    protected void chargeLateFee(int amount){
        lateFees[feeCount] = amount;
        feeCount++;
    }
    int[] getLateFeeHistory(){
        int[] copy = new int[feeCount];
        for(int i = 0; i<feeCount; i++){
            copy[i] = lateFees[i];
        }
        return copy;
    }
    int getTotalLateFees(){
        int total = 0;
        for(int i = 0; i<feeCount; i++){
            total = total + lateFees[i];
        }
        return total;
    }
}
class PremiumMember extends GymMember{
    private String trainerName;
    PremiumMember(String memberId, int monthlyFee, String trainerName){
        super(memberId, monthlyFee);
        this.trainerName = trainerName;
    }
    @Override
    protected void chargeLateFee(int amount){
        super.chargeLateFee(amount / 2);
    }
}
public class q3{
    public static void main(String args[]){
        PremiumMember p = new PremiumMember("MEM5", 2000, "Coach Riya");
        p.chargeLateFee(200);
        System.out.println(p.getTotalLateFees());
        int[] history = p.getLateFeeHistory();
        history[0] = 999;
        System.out.println(Arrays.toString(p.getLateFeeHistory()));
    }
}
