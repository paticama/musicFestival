public class Group extends Artist {

    public boolean sellMerch;
    public int numMerch;
    public Group(String name, String genre, boolean headliner, boolean confirmedAtt, int capacity, int duration,double price, boolean sellMerch, int numMerch) {
            super(name, genre, headliner, confirmedAtt, capacity, duration, price);
            this.sellMerch = sellMerch;
            this.numMerch = numMerch;
        }
    
    public int getNumMerch() {
        return numMerch;
    }
    public void setNumMerch(int numMerch) {
        this.numMerch = numMerch;
    }
    public boolean getSellMerch(){
        return sellMerch;
    }
    public void setSellMerch(boolean sellMerch) {
        this.sellMerch = sellMerch;
    }
    public boolean hasStand() {
        if (sellMerch == true) {
            return true;
        }
        else{
            return false;
        }
    }
    public String toString() {
        
        return ("name: " + name + " genre: " + genre + " headliner: " + headliner + " confirmed assistance: " + confirmedAtt + " capacity: " + capacity + " duration: " + duration + " price: " + price + "sell merchandising" + sellMerch + "number merchandising" + numMerch);
    }

    
}
