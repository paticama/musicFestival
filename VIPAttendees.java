public class VIPAttendees extends Attendees {
    String name; 
    int id, creditNum, VIPNum;
    boolean prevAtt;
    Tickets[] ticketList;


    public VIPAttendees(String n, int id, int crNum, int vipNum, boolean prevAtt, Tickets[] tickLst){
        super(n, id, crNum, prevAtt, tickLst);
        VIPNum = vipNum;
    }

    public void setVipNum(int vipNum){
        VIPNum = vipNum;
    }

    public int getVipNum(){
        return VIPNum;
    }

    public String toString(){
        String str = "name: " + name + " ID: " + id + " credit card number " + creditNum + " has previously attended?: " + prevAtt + "VIP number: " + VIPNum;
        return str;
    }

    //TODO: Show info. of the concerts with merchandising stands for which a VIP has purchased tickets  
}
