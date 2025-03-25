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

    //TODO: Implement the CalculateSecurity method, which needs to read the maximum num of attendants from Asistentes.txt
}
