public class Solo extends Artist {

    boolean dressingRoom;
    int managerNum;

    public Solo(String name, String genre, boolean headliner,  int capacity, int duration, double price,boolean confirmedAtt, boolean dressingRoom, int managerNum) {
            super(name, genre, headliner, capacity, duration, price, confirmedAtt);
            this.dressingRoom = dressingRoom;
            this.managerNum = managerNum;
    }

    
    public boolean hasStand() {
        return false;
    }
    public int getManagerNum() {
        return managerNum;
    }
    public void setManagerNum(int managerNum) {
        this.managerNum = managerNum;
    }
    public boolean getDressingRoom(){
        return dressingRoom;
    }
    public void setDressingRoom(boolean dressingRoom) {
        this.dressingRoom = dressingRoom;
    }

    public boolean getSellMerch(){
        return false; //THIS SHOULD NEVER HAPPEN!!
    }

    @Override
    public String toString() {
        
        return (super.toString() + "Do they need a dressing room?: " + dressingRoom + " Manager phone number: " + managerNum);
    }
}

