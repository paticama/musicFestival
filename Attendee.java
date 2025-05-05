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

    public void setTicketList(Ticket[] ticklst){
        ticketList = ticklst;
    }

    public Ticket[] getTicketList(){
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

    //public int CheckPrice(Tickets ticket){
        //int price;
        //return price;
    //}
    
    public String checkTicketInfo(Ticket ticket){ //NEEDS TO RETURN A SPECIFIC ATENDEE
        String info = ticket.toString();
        return info;
    }
    //TODO: EstimateHeadliners, cannot be done as we can't read from txt files, y como carajo le saco el precio, que soy? vidente?
    
}

