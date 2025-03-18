public class Attendees{
    String name; 
    int id, creditNum;
    boolean prevAtt;
    Tickets ticketList[];

    public Attendees(String n, int i, int cred, boolean prev, Tickets tickLst[]){
        name = n;
        id = i;
        creditNum = cred;
        prevAtt = prev;
        ticketList = tickLst;
    }

    public void setName(String n){
        name = n;
    }

    public String getName(){
        return name;
    }

    public void setId(int i){
        id = i;
    }

    public int getId(){
        return id;
    }

    public void setCredNum(int cred){
    creditNum = cred;
    }

    public int getCredNum(){
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

    /*  public boolean buyTickets(int howManyTickets){
        //Check if the atendee is in the file
        if (howManyTickets > 7){
            return false;
        }
        else{
            //Decrease the number of tickets artist have
            
        }
    }
    */
}

