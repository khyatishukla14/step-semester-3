class LibraryMember{
    private String membershipId;
    private boolean membershipIdSet = false;
    private String name;
    private boolean premiumMember;
    private String securityAnswerHash;
    public LibraryMember(){}
    public String getMembershipId(){
        return membershipId;
    }
    public void setMembershipId(String id){
        if(!membershipIdSet){
            membershipId = id;
            membershipIdSet = true;
        }
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public boolean isPremiumMember(){
        return premiumMember;
    }
    public void setPremiumMember(boolean premium){
        this.premiumMember = premium;
    }
    public void setSecurityAnswer(String answer){
        this.securityAnswerHash = transform(answer);
    }
    private String transform(String input){
        int hash = 0;
        for(int i = 0; i<input.length(); i++){
            hash = hash * 31 + input.charAt(i);
        }
        return Integer.toString(hash);
    }
}
public class q4{
    public static void main(String args[]){
        LibraryMember m = new LibraryMember();
        m.setMembershipId("LIB-8841");
        m.setName("Priya Nair");
        m.setPremiumMember(true);
        System.out.println(m.getMembershipId());
        m.setMembershipId("FAKE-0000");
        System.out.println(m.getMembershipId());
        System.out.println(m.isPremiumMember());
        m.setSecurityAnswer("BlueMountain");
    }
}
