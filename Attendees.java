public class Attendees{
    String name, id, creditNum; 
    boolean prevAtt;
    int numTickets;
    Tickets[] ticketList;

    public Attendees(String n, String i, String cred, boolean prev, int numTickets){
        name = n;
        id = i;
        creditNum = cred;
        prevAtt = prev;

        Tickets[] ticketList = new Tickets[numTickets];
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
    
    public String checkTicketInfo(Tickets ticket){ //NEEDS TO RETURN A SPECIFIC ATENDEE
        String info = ticket.toString();
        return info;
    }
    //TODO: EstimateHeadliners, cannot be done as we can't read from txt files, y como carajo le saco el precio, que soy? vidente?
    
}

