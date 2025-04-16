public abstract class Artist {
    String name,genre;
    boolean headliner,confirmedAtt;
    int capacity, duration;
    double price;
    public Artist(String name, String genre, boolean headliner, int capacity, int duration, double price,  boolean confirmedAtt){
        this.name = name;
        this.genre = genre;
        this.headliner = headliner;
        this.confirmedAtt = confirmedAtt;
        this.capacity = capacity;
        this.duration = duration;
        this.price = price;
    }
    public abstract boolean hasStand();
    public int getCapacity() {
        return capacity;
    }
    public int getDuration() {
        return duration;
    }
    public String getGenre() {
        return genre;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public void setConfirmedAtt(boolean confirmedAtt) {
        this.confirmedAtt = confirmedAtt;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public void setHeadliner(boolean headliner) {
        this.headliner = headliner;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String toString(){
        return ("name: " + name + " genre: " + genre + " headliner: " + headliner + " confirmed assistance: " + confirmedAtt + " capacity: " + capacity + " duration: " + duration + " price: " + price);
    }
}
