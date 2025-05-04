import java.io.IOException;
import java.util.*;

public class Main {
    static double calcprice(Attendees [] att,Artist []art, String attId, boolean nameReal){
        String artName;
        double priceArt = 0;
        for (int i = 0; i < att.length; i++) {
            if (att[i].getId().equalsIgnoreCase(attId)) {
                System.out.println("Tell me the name of the artist you want to go");
                artName = INPUT.next();
                for (int j = 0; j < art.length; j++) {
                    if (art[j].getName().equalsIgnoreCase(artName)) {
                        priceArt = art[j].getPrice();
                        if (att[i].getPrevAtt() == true) {
                            priceArt = priceArt - (priceArt * iConstants.TICKETPREVATTENDEDISCOUNT);
                            if (att[i] instanceof VIPAttendees) {
                                priceArt = priceArt - (priceArt* iConstants.TICKETVIP);
                                nameReal = true;
                            }
                            nameReal = true;
                        }
                        else if (att[i] instanceof VIPAttendees) {
                            priceArt = priceArt - (priceArt * iConstants.TICKETVIP);
                            
                        }
                        nameReal = true;
                    }
                }
            }
        }
        return priceArt;
    }
    private static final Scanner INPUT = new Scanner(System.in);
    public static void main(String[] args) throws IOException {


        //Query 1
        Principal reader = new Principal();
        Artist art[] = reader.readArtist("Artistas.txt");

        for (int i = 0; i < art.length; i++) {
            System.out.println(art[i].toString()); 
        }

        //Query 2

        int assistance = 0;
        int numSec = 0;

        for (int i = 0; i < art.length; i++) {
            assistance += art[i].getCapacity(); 
            if (art[i] instanceof Group && art[i].getSellMerch()){
                numSec += 2;
            }
            else if (art[i] instanceof Solo && art[i].getDressingRoom()){
                numSec += 1;
            }
        }
        numSec += assistance*1000/500;
        double price = numSec * 250;
        System.out.println(price);
        System.out.println(art[2].getPrice());
        
        //Query 3
       
        double priceTicket = 0;
        String attId;
        boolean nameReal = false;
        Principal readerAtt = new Principal();
        Attendees att[] = readerAtt.leerAsistentes("Asistentes.txt");

        System.out.println("Tell me the ID of the Attendee");
        attId = INPUT.next();

        for (int i = 0; i < att.length; i++) {
            if (attId.equals(att[i].getId())){
                nameReal = true;
            }
        }
        if (nameReal == true) {
            priceTicket = calcprice(att, art, attId, nameReal);
            System.out.println(priceTicket);
        } else{
            System.out.println("It seems something went wrong. That Attendee is not in our database. ");
        }
    
        //Query 4

        double expectedSpent = 0;
        for (int i = 0; i < art.length; i++) {
            if (art[i].getConfirmedAtt()){
                expectedSpent += art[i].getPrice();
            } else if (art[i] instanceof Group && art[i].getSellMerch()){
                expectedSpent += iConstants.TSHIRTPRICE;
            }
        }
        System.out.println(expectedSpent);

        //Query 5
        //Preguntar a Aurora si es necesario que se guarden los no registrados
        String name, id, crednum;
        boolean prevAtt, vip;
        int numtick = 7, vipnum; //max tickets
        System.out.println("Tell me the ID");
        attId = INPUT.next();
        boolean preexAtt = false;
        int c = 0;
        for (int i = 0; i < att.length; i++) {
            if (att[i].getId().equals(attId)){
                preexAtt = true;
                c = i;
            }
        }     //From here to the end of if, I'd make a "create attendee" method
        if (preexAtt == false) {
            System.out.println("We need your some more information, please give us the next data: ");
            System.out.println("name: ");
            name = INPUT.next();
            //No need to ask again!
            id = attId;
            System.out.println("Credit card number: ");
            crednum = INPUT.next();
            
            System.out.println("Have you assisted previously? (true or false)");
            
            while (!INPUT.hasNextBoolean()) {
                System.out.println("Try again please");
                INPUT.next();
            }
            prevAtt = INPUT.nextBoolean();

            System.out.println("Are you VIP? (true or false)");

            while (!INPUT.hasNextBoolean()) {
                System.out.println("Try again please");
                INPUT.next();
            }
            vip = INPUT.nextBoolean();

            if (vip == true) {
                System.out.println("Tell me your vip number: ");
                vipnum = INPUT.nextInt();
                VIPAttendees newatt = new VIPAttendees(name, id, crednum,vipnum, prevAtt, vip);
            }
            else{
                Attendees newatt = new Attendees(name, id, crednum, prevAtt, vip);
            }
            //FALTA COMPRARLE LOS TICKETS!!!
            
        }

        System.out.println("Alright, now, what Artist do you want to buy tickets for?");
        String arts = INPUT.next();
        boolean artsExist = false;
        int b = 0;

        for (int i = 0; i < art.length; i++) {
            if (art[i].getName().equalsIgnoreCase(arts)){
                if(art[i].getConfirmedAtt()){
                    artsExist = true;
                    b = i;
                } else {
                    System.out.println("You can only buy confirmed artists tickets!");
                }

            }
            else if (i == art.length && !artsExist) {
                System.out.println("It seems something went wrong, we cannot find that artist, try again!");
            }
        } 
        if(artsExist){ // it does not matter what b is if arts don't exist
            boolean ticketBought = false;

            for (int i = 0; i < iConstants.TICKETS; i++) {
                if (!ticketBought && att[c].ticketList[i] == null){
                    //Llamar aquí al precio
                    att[c].ticketList[i] = new Tickets(23, art[b]); //CAMBIAR ESE 23!!
                    System.out.println();
                    System.out.println("Ticket bought for " + art[b].getName() + " ! enjoy the Festival!");
                    ticketBought = true;  

                } else if (!ticketBought && i == iConstants.TICKETS - 1){
                    System.out.println("It looks like you have already bought 7 tickets!!");
                }
            }
        }

        System.out.println("DEBUG: Tickets after purchase for " + att[c].getName());
        for (int i = 0; i < att[c].ticketList.length; i++) {
            if (att[c].ticketList[i] != null) {
                System.out.println("Slot " + i + ": " + att[c].ticketList[i].toString());
            } else {
                System.out.println("Slot " + i + ": Empty");
            }
        }

        //Query 6
        System.out.println("Tell me the ID");
        attId = INPUT.next();

        int a = 0; //Ponerle otro nombre?
        boolean preexAttOtro = false;

        for (int i = 0; i < att.length; i++) {
            if (att[i].getId().equals(attId)){
                preexAttOtro = true;
                a = i;
            }
        }
        if(preexAtt == true){
            System.out.println("Tickets for " + att[a].getName() + " with ID: " + att[a].getId());
            for(int i = 0; i < att[a].ticketList.length; i++){
                if (att[a].ticketList[i] != null) {
                    System.out.println(att[a].ticketList[i].toString());
                }
            }
        } else {
            System.out.println("You need to be registered!");
        }

        //Query 7
        //Un for que recorra artistas y un if para ser vip y que tenga mercha ese grupo

        for (int i = 0; i < att.length; i++) {
                for (int j = 0; j < att[i].ticketList.length; j++){
                    if (att[i] instanceof VIPAttendees && att[i].ticketList[j] != null){
                        if(att[i].ticketList[j].forWho.getSellMerch()){
                            att[i].ticketList[j].forWho.toString();
                        }
                    }
                }
        }
    }
}
        
