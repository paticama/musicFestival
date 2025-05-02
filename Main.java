import java.util.*;
import java.io.IOException;

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
        while (nameReal == false) {
            System.out.println("Tell me the ID of the Attendee");
            attId = INPUT.next();
            priceTicket = calcprice(att, art, attId, nameReal);
        }
        System.out.println("your price ticket would be: "+ priceTicket);
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

        for (int i = 0; i < att.length; i++) {
            if (!att[i].getId().equals(attId)) {
                System.out.println("We need your information, please give us the next data: ");
                System.out.println("name: ");
                name = INPUT.next();
                System.out.println("ID: ");
                id = INPUT.next();
                System.out.println("Credit card number: ");
                crednum = INPUT.next();
                System.out.println("Have you assisted previously? (true or false)");
                prevAtt = INPUT.nextBoolean();
                while (prevAtt != true || prevAtt != false) {
                    System.out.println("Try again please");
                    prevAtt = INPUT.nextBoolean();
                }
                System.out.println("Are you VIP? (true or false)");
                vip = INPUT.nextBoolean();
                while (vip != true || vip != false) {
                    System.out.println("Try again please");
                    vip = INPUT.nextBoolean();
                }
                if (vip == true) {
                    System.out.println("Tell me your vip number: ");
                    vipnum = INPUT.nextInt();
                    VIPAttendees newatt = new VIPAttendees(name, id, crednum,vipnum, prevAtt, vip, numtick);
                }
                else{
                    
                }

            }
        }
        
        

        //Query 6


        //Query 7


    }
        
}
