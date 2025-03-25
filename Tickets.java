public class Tickets {
    int id;
    double prevAttDiscount, vipDiscount;
    Artist[] listArtists;
    public Tickets(int id, double prvDisc, double vipDisc, Artist[] ltArt){
        id = this.id;
        prevAttDiscount = prvDisc;
        vipDiscount = vipDisc;
        listArtists = ltArt;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        id = this.id;
    }
    public double getPreviousAttDiscount(){
        return prevAttDiscount;
    }
    public void setPrevAttDiscount(double prvAttDisc){
        prevAttDiscount = prvAttDisc;
    }
    public double getVipDiscount(){
        return vipDiscount;
    }
    public void setVipDiscount(double vipDisc){
        vipDiscount = vipDisc;
    }
    public Artist[] getListArtist(){
        return listArtists;
    }
    public void setListArtist(Artist[] lArtists){
        listArtists = lArtists;
    }

    public String toString(){
        String str = "ID: " + id + "Previously attended discount" + prevAttDiscount + "VIP discount" + vipDiscount + "Artist info: "; // + Artist.toString();
        return str;
    }

}
