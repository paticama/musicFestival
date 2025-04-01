public class Festival {
    String name, city; 
    Artist[] artistList;
    Attendees[] atendeeList;

    public Festival(String n, String c, Artist[] arlist, Attendees[] atlist){
        name = n;
        city = c;
        artistList = arlist;
        atendeeList = atlist;
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
    public void setArtList(Artist[] arlist){
        artistList = arlist;
    }

    public Attendees[] getAttenList(){
        return atendeeList;
    }
    public void setAttenList(Attendees[] atlist){
        atendeeList = atlist;
    }

    public String toString(){
        String str = "Name: " + name + " City: " + city + " Artists who attend " + artistList.toString() + " Attendees " + atendeeList.toString();
        return str;
    }

    public double calculateSecurity(SecurityCompany secComp, int attendance, int numMerch, int numSoloistDressroom){
        // We pass the class Security Company, where we find how much they charge per security person, as well as how many people attend, how many merchandise stands there are and how many dressing rooms soloist have
        // As it's specified, we know that there's a security member every 500 attendees, two for every merchandise stand and one for every dressing rooms.  

        int numSecurity = (attendance/500) + 2*numMerch + numSoloistDressroom;
        return numSecurity * secComp.getCharge();

    }
}    

