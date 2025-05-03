public class Tickets {
    int id;
    double prevAttDiscount, vipDiscount;
    Artist[] listArtists;
    public Tickets(int id, Artist[] ltArt){
        this.id = id;
        listArtists = ltArt;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }
    
    public Artist[] getListArtist(){
        return listArtists;
    }

    public void setListArtist(Artist[] lArtists){
        listArtists = lArtists;
    }

    public String toString(){
        String str = "ID: " + id + "Artist info: "; // + Artist.toString();
        return str;
    }

}
