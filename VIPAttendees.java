public class VIPAttendees extends Attendees {
    int VIPNum;

    public VIPAttendees(String n, String id, String crNum, int vipNum, boolean prevAtt, boolean isVIP){
        super(n,id,crNum,prevAtt,isVIP);
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

}
