
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

    public Artist[] getArtList(){
        return artistList;
    }

    public Attendee[] getAttendeeList(){
        return atendeeList;
    }

    public String showAllArtistInfo(Artist[] art){
        String str = "";
        for (int i = 0; i < art.length; i++) {
            str += (art[i].toString() + "\n"); 
        }
        return str;
    }

    public double calculateSecurityCost(Artist[] art, SecurityCompany sec){
        int assistance = 0;
        int numSec = 0;
        double price;

        for (int i = 0; i < art.length; i++) {
            assistance += art[i].getCapacity(); 
            if (art[i].getSellMerch()){
                numSec += 2;
            }
            else if (art[i].getDressingRoom()){ 
                numSec += 1;
            }
        }
        numSec += assistance*1000/500;
        
        price = numSec * sec.getCharge();
        return price;
    }

    public boolean checkRegistedAttendee(String attId, Attendee[] att){
        boolean nameReal = false;

        for (int i = 0; i < att.length; i++) {
            if (attId.equalsIgnoreCase(att[i].getId())){
                nameReal = true;
            }
        }
        return nameReal;
    }

    public boolean checkRealArtist(String wantToAttend, Artist[] art){
        boolean nameReal = false;

        for (int i = 0; i < art.length; i++) {
            if (wantToAttend.equalsIgnoreCase(art[i].getName())){
                nameReal = true;
            }
        }
        return nameReal;
    }


    public double calcPrice(Attendee[] att, Artist[] art, String artName, String attId){  //TODO: REPLANTEARSE LOS DESCUENTOS, SE APLICAN DE UNA? SE DESCUENTA UNO Y LUEGO OTRO???????
        double priceArt = 0;
        double toDiscount = 0;
        double[] toReturn = new double[1];
        for (int i = 0; i < att.length; i++) {
            if (att[i].getId().equalsIgnoreCase(attId)) {
                for (int j = 0; j < art.length; j++) {
                    if (art[j].getName().equalsIgnoreCase(artName)) {
                        priceArt = art[j].getPrice();
                        toReturn[0] = priceArt;
                        if (att[i].getPrevAtt() == true) {
                            priceArt = priceArt - (priceArt * iConstants.TICKETPREVATTENDEDISCOUNT);
                            if (att[i] instanceof VIPAttendee) {
                                priceArt = priceArt - (priceArt * iConstants.TICKETVIP);
                            }
                        }
                        else if (att[i] instanceof VIPAttendee) {
                            priceArt = priceArt - (priceArt * iConstants.TICKETVIP);
                            
                        }
                    }
                }
            }
        } 
        toReturn[1] = priceArt;
        return priceArt;
    }

    public double estimateMoney(Artist[] art, String att){
        int c = attPosition(atendeeList, att);
        double expectedSpent = 0;
        double discount = 0;
        for (int i = 0; i < art.length; i++) {
            if (art[i].getConfirmedAtt() && art[i].getHeadliner()){ //TODO: De nuevo, REPLANTEARSE LOS DESCUENTOS Y EL MÉTODO ENTERO AAAAAAAAAAAAAH
                if (atendeeList[c] instanceof VIPAttendee) {
                    discount += iConstants.TICKETVIP;
                }
                if (atendeeList[c].getPrevAtt()) {
                    discount += iConstants.TICKETPREVATTENDEDISCOUNT;
                }

                expectedSpent += art[i].getPrice() * (1 - discount);
            } else if (art[i] instanceof Group && art[i].getSellMerch()){
                if(atendeeList[c].getPrevAtt()){
                    expectedSpent += iConstants.TSHIRTPRICE * iConstants.MERCHANDISCOUNTS;
                } else {
                    expectedSpent += iConstants.TSHIRTPRICE;
                }
            }
        }
        return expectedSpent;
    }

    public String showInfoTicket(String attId, Attendee[] att){
        int pos = 0; 
        String str = "";

        for (int i = 0; i < att.length; i++) {
            if (att[i].getId().equalsIgnoreCase(attId)){
                pos = i;
            }
        }
        for(int i = 0; i < att[pos].ticketList.length; i++){
            if (att[pos].ticketList[i] != null) {
                str += (att[pos].ticketList[i].toString());
            }
        }
        return str;
    }

    public String showInfoConcerts(Attendee[] att){
        //Un for que recorra artistas y un if para ser vip y que tenga mercha ese grupo
        String str = "";

        for (int i = 0; i < att.length; i++) {
            for (int j = 0; j < att[i].ticketList.length; j++){
                if (att[i] instanceof VIPAttendee && att[i].ticketList[j] != null ){
                    if(att[i].ticketList[j].forWho.getSellMerch()){
                        str += att[i].ticketList[j].forWho.toString();
                    }
                }
            }
        }
        return str;
    }

    public static int attPosition(Attendee[] att, String attId){
        int c = 0;
        for (int i = 0; i < att.length; i++) {
            if (att[i].getId().equalsIgnoreCase(attId)){
                c = i;
            }
        } 
        return c;
    }

    public static int artPosition(Artist[] art, String name){
        int c = 0;
        for (int i = 0; i < art.length; i++) {
            if (art[i].getName().equalsIgnoreCase(name)){
                c = i;
            }
        } 
        return c;
    }

    public boolean buyTicket(Attendee att, Artist art){
        boolean ticketBought = false;

        for (int i = 0; i < iConstants.TICKETS; i++) {
            if (!ticketBought && att.ticketList[i] == null){
                int randomNum = (int)(Math.random() * 1001); //Asked about the random ID. Told it was OK
                //Llamar aquí al precio
                att.ticketList[i] = new Ticket(randomNum, art); 
                ticketBought = true;  
            } 
        }
        return  ticketBought;
    }

}    
