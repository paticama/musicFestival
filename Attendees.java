public class Attendees{
    String name, id, creditNum; 
    boolean prevAtt, isVIP;
    
    Tickets[] ticketList = new Tickets[iConstants.TICKETS - 1];

    public Attendees(String n, String i, String cred, boolean prev, boolean vip){
        name = n;
        id = i;
        creditNum = cred;
        isVIP = vip;
        prevAtt = prev;
    }

    public void setName(String n){
        name = n;
    }

    public String getName(){
        return name;
    }

    public void setId(String i){
        id = i;
    }

    public String getId(){
        return id;
    }

    public void setCredNum(String cred){
    creditNum = cred;
    }

    public String getCredNum(){
        return creditNum;
    }

    public void setPrevAtt(boolean prev){
        prevAtt = prev;
    }

    public boolean getPrevAtt(){
        return prevAtt;
    }

    public void setTicketList(Tickets[] ticklst){
        ticketList = ticklst;
    }

    public Tickets[] getTicketList(){
        return ticketList;
    }

    @Override
    public String toString(){
        String str = "name: " + name + " ID: " + id + " credit card number " + creditNum + " has previously attended?: " + prevAtt;
        return str;
    }

    public boolean buyTickets(int howManyTickets){
        boolean allRight = true;
        if (howManyTickets > 7) {
            allRight = false;
        }
        else{

        }
        return allRight;
    }
    
    public String checkTicketInfo(Tickets ticket){ 
        String info = ticket.toString();
        return info;
    }
    
    
}

