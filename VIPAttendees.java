public class VIPAttendees extends Attendees {
    int VIPNum;

    public VIPAttendees(String n, String id, String crNum, int vipNum, boolean prevAtt, boolean isVIP, int numTickets){
        super(n,id,crNum,prevAtt,isVIP,numTickets);
        VIPNum = vipNum;
    }

    public void setVipNum(int vipNum){
        VIPNum = vipNum;
    }

    public int getVipNum(){
        return VIPNum;
    }
    
    public String toString(){
        String str = super.toString() + "VIP number: " + VIPNum;
        return str;
    }

    //TODO: Show info. of the concerts with merchandising stands for which a VIP has purchased tickets  
}
