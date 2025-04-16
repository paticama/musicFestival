public class Group extends Artist {

    public boolean sellMerch;
    public int memberNum;
    public Group(String name, String genre, boolean headliner,  int capacity, int duration, double price,boolean confirmedAtt, int memberNum,boolean sellMerch) {
            super(name, genre, headliner,capacity, duration, price,  confirmedAtt);
            this.sellMerch = sellMerch;
            this.memberNum = memberNum;
        }
    
    public int getMemberNum(){
        return memberNum;
    }
    public void setMemberNum(int memberNum){
        this.memberNum= memberNum;
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
        
        return ("name: " + name + " genre: " + genre + " headliner: " + headliner + " confirmed assistance: " + confirmedAtt + " capacity: " + capacity + " duration: " + duration + " price: " + price + "how many in the group"+memberNum+ "Do they sell merchandising?" + sellMerch);
    }

    
}
