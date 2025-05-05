public class Attendee{
    String name, id, creditNum; 
    boolean prevAtt, isVIP;
    
    Ticket[] ticketList = new Ticket[iConstants.TICKETS - 1];

    public Attendee(String n, String i, String cred, boolean prev, boolean vip){
        this.name = n;
        this.id = i;
        this.creditNum = cred;
        this.isVIP = vip;
        this.prevAtt = prev;
    }

    public void setName(String n){
        this.name = n;
    }

    public String getName(){
        return name;
    }

    public void setId(String i){
        this.id = i;
    }

    public String getId(){
        return id;
    }

    public void setCredNum(String cred){
        this.creditNum = cred;
    }

    public String getCredNum(){
        return creditNum;
    }

    public void setPrevAtt(boolean prev){
        this.prevAtt = prev;
    }

    public boolean getPrevAtt(){
        return prevAtt;
    }

    public void setTicketList(Ticket[] ticklst){
        this.ticketList = ticklst;
    }

    public Ticket[] getTicketList(){
        return ticketList;
    }

    @Override
    public String toString(){
        String str = "Name: " + name + " ID: " + id + " Credit card number: " +
        creditNum + " Has previously attended?: " + prevAtt;
        return str;
    }  
}

