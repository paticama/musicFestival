
public class Festival {
    String name, city; 
    Artist[] artistList;
    Attendee[] atendeeList;
    SecurityCompany sec;
    
    public Festival(String n, String c, Artist[] arList, Attendee[] attList){
        this.name = n;
        this.city = c;
        this.artistList = arList;
        this.atendeeList = attList;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        name = this.name;
    }

    public String getCity(){
        return city;
    }
    public void setCity(String c){
        city = c;
    }

    public Artist[] getArtList(){
        return artistList;
    }
    public void setArtList(Artist[] arList){
        artistList = arList;
    }

    public Attendee[] getAttenList(){
        return atendeeList;
    }
    public void setAttenList(Attendee[] atList){
        atendeeList = atList;
    }

    public String toString(){
        String str = "Name: " + name + " City: " + city + " Artists: " ;
        for (int i = 0; i < artistList.length; i++) {
           str +=  artistList.toString();
           str += "\n";
        }
        str +=  " Attendee: ";
        for (int i = 0; i < atendeeList.length; i++) {
            str +=  atendeeList.toString();
            str += "\n";
         }
        
        return str;
    }

    public String showAllArtistInfo(Artist[] art){
        String str = "";
        for (int i = 0; i < art.length; i++) {
            str += (art[i].toString() + "\n"); 
        }
        return str;
    }

    public double calculateSecurityCost(Artist[] art, SecurityCompany sec){
        int assistance = 0;
        int numSec = 0;
        double price;

        for (int i = 0; i < art.length; i++) {
            assistance += art[i].getCapacity(); 
            if (art[i] instanceof Group && art[i].getSellMerch()){
                numSec += 2;
            }
            else if (art[i] instanceof Solo && art[i].getDressingRoom()){
                numSec += 1;
            }
        }
        numSec += assistance*1000/500;
        
        price = numSec * sec.getCharge();
        return price;
    }

    public boolean checkRegistedAttendee(String attId, Attendee[] att){
        double priceTicket = 0;
        boolean nameReal = false;

        for (int i = 0; i < att.length; i++) {
            if (attId.equalsIgnoreCase(att[i].getId())){
                nameReal = true;
            }
        }
        return nameReal;
    }

    public boolean checkRealArtist(String wantToAttend, Artist[] art){
        boolean nameReal = false;

        for (int i = 0; i < art.length; i++) {
            if (wantToAttend.equalsIgnoreCase(art[i].getName())){
                nameReal = true;
            }
        }
        return nameReal;
    }


    public double calcPrice(Attendee[] att, Artist[] art, String artName, String attId){
        double priceArt = 0;
       for (int i = 0; i < att.length; i++) {
            if (att[i].getId().equalsIgnoreCase(attId)) {
                for (int j = 0; j < art.length; j++) {
                    if (art[j].getName().equalsIgnoreCase(artName)) {
                        priceArt = art[j].getPrice();
                        if (att[i].getPrevAtt() == true) {
                            priceArt = priceArt - (priceArt * iConstants.TICKETPREVATTENDEDISCOUNT);
                            if (att[i] instanceof VIPAttendee) {
                                priceArt = priceArt - (priceArt* iConstants.TICKETVIP);
                            }
                        }
                        else if (att[i] instanceof VIPAttendee) {
                            priceArt = priceArt - (priceArt * iConstants.TICKETVIP);
                            
                        }
                    }
                }
            }
        } 
        return priceArt;
    }

    public double estimateMoney(Artist[] art){
        double expectedSpent = 0;
        for (int i = 0; i < art.length; i++) {
            if (art[i].getConfirmedAtt()){
                expectedSpent += art[i].getPrice();
            } else if (art[i] instanceof Group && art[i].getSellMerch()){
                expectedSpent += iConstants.TSHIRTPRICE;
            }
        }
        return expectedSpent;
    }

    public String showInfoTickets(String attId, Attendee[] att){
        int pos = 0; 
        String str = "";

        for (int i = 0; i < att.length; i++) {
            if (att[i].getId().equals(attId)){
                pos = i;
            }
        }
        for(int i = 0; i < att[pos].ticketList.length; i++){
            if (att[pos].ticketList[i] != null) {
                str += (att[pos].ticketList[i].toString());
            }
        }
        return str;
    }

    public String showInfoConcerts(Attendee[] att){
        //Un for que recorra artistas y un if para ser vip y que tenga mercha ese grupo
        String str = "";

        for (int i = 0; i < att.length; i++) {
            for (int j = 0; j < att[i].ticketList.length; j++){
                if (att[i] instanceof VIPAttendee && att[i].ticketList[j] != null ){
                    if(att[i].ticketList[j].forWho.getSellMerch()){
                        str += att[i].ticketList[j].forWho.toString();
                    }
                }
            }
        }
        return str;
    }

    public static int attPosition(Attendee[] att, String attId){
        int c = 0;
        for (int i = 0; i < att.length; i++) {
            if (att[i].getId().equalsIgnoreCase(attId)){
                c = i;
            }
        } 
        return c;
    }


}    
