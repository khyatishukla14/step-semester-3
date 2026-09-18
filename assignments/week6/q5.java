import java.util.Arrays;
class LoanReceipt{
    private final String memberId;
    private final String[] bookIds;
    LoanReceipt(String memberId, String[] bookIds){
        this.memberId = memberId;
        this.bookIds = copyArray(bookIds);
    }
    String[] getBookIds(){
        return copyArray(bookIds);
    }
    String getMemberId(){
        return memberId;
    }
    LoanReceipt withCorrectedBookId(int index, String newId){
        String[] newIds = copyArray(bookIds);
        newIds[index] = newId;
        return new LoanReceipt(memberId, newIds);
    }
    private static String[] copyArray(String[] arr){
        String[] copy = new String[arr.length];
        for(int i = 0; i<arr.length; i++){
            copy[i] = arr[i];
        }
        return copy;
    }
}
class ReferenceOnlyLoanReceipt extends LoanReceipt{
    private final String roomNumber;
    public ReferenceOnlyLoanReceipt(String memberId, String[] bookIds, String roomNumber){
        super(memberId, bookIds);
        this.roomNumber = roomNumber;
    }
}
class CirculationLedger{
    static String branchCode;
    static {
        branchCode = "PT-MAIN";
    }
    static String processNightlyCirculation(LoanReceipt[] receipts){
        int processed = 0;
        int nullSkipped = 0;
        int referenceOnly = 0;
        int regular = 0;
        for(int i = 0; i<receipts.length; i++){
            if(receipts[i] == null){
                nullSkipped++;
                continue;
            }
            processed++;
            if(receipts[i] instanceof ReferenceOnlyLoanReceipt){
                referenceOnly++;
            } else {
                regular++;
            }
        }
        return processed + " processed | " + nullSkipped + " null skipped | " + referenceOnly + " reference-only | " + regular + " regular";
    }
}
public class q5{
    public static void main(String args[]){
        LoanReceipt r = new LoanReceipt("LIB-8841", new String[]{"BK-100", "BK-101"});
        String[] ids = r.getBookIds();
        ids[0] = "HACKED";
        System.out.println(r.getBookIds()[0]);

        LoanReceipt corrected = r.withCorrectedBookId(1, "BK-102");
        System.out.println(Arrays.toString(r.getBookIds()));
        System.out.println(Arrays.toString(corrected.getBookIds()));

        System.out.println(CirculationLedger.processNightlyCirculation(new LoanReceipt[]{
            new ReferenceOnlyLoanReceipt("LIB-001", new String[]{"BK-200"}, "Reading Room 3"),
            null,
            new LoanReceipt("LIB-002", new String[]{"BK-201"})
        }));
    }
}
