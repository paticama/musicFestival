
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


    /*
    public double calculateSecurity(SecurityCompany secComp, int attendance, int numMerch, int numSoloistDressroom){
        
        // We pass the class Security Company, where we find how much they charge per security person, as well as how many people attend, 
        // how many merchandise stands there are and how many dressing rooms soloist have.

        // As it's specified, we know that there's a security member every 500 Attendee, two for every merchandise stand and one for every dressing rooms. 
        // attendance, numMerch and numSoloistDressroom needs to be passed after reading txt files. 

        

        int numSecurity = (attendance/500) + 2*numMerch + numSoloistDressroom;
        return numSecurity * secComp.getCharge();

    }

    //public int CheckPrice(Tickets ticket){
    //int price;
    //return price;
    //}
    
    public String checkTicketInfo(Tickets ticket){ //NEEDS TO RETURN A SPECIFIC ATENDEE
        String info = ticket.toString();
        return info;
    } */
}    

// Show all info regarding artist - Query 1
// Calculate cost - Done - Query 2
// Calculate ticket price - Query 3
// Query 4
// Query 5 
// Query 6
// Query 7 