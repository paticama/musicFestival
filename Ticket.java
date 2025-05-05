public class Ticket {
    int id;
    Artist forWho;

    public Ticket(int id, Artist art){
        this.id = id;
        this.forWho = art;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }
    
    public Artist getforWho(){
        return forWho;
    }

    public void setforWho(Artist art){
        forWho = art;
    }

    public String toString(){
        String str = "ID: " + id + "Artist info: " + forWho.toString();
        return str;
    }

}
