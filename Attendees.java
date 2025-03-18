public class Attendees{
    String name; 
    int id, creditNum;
    boolean prevAtt;
    //Ticket tickets; TODO: IMPLEMENT

    public Attendees(String n, int i, int cred, boolean prev){
        name = n;
        id = i;
        creditNum = cred;
        prevAtt = prev;
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

    public String toString(){
        String str = "name: " + name + " ID: " + id + " credit card number " + creditNum + " has previously attended?: " + prevAtt;
        return str;
    }
}

