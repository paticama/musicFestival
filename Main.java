import java.io.IOException;
import java.util.*;

public class Main {
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
        
        //Query 3
       
        double priceArt = 0;
        String artName,attId;
        boolean nameReal = false;
        Principal readerAtt = new Principal();
        Attendees att[] = readerAtt.leerAsistentes("Asistentes.txt");
        
        while (nameReal == false) {
            System.out.println("Tell me the name of the artist you want to go");
            artName = INPUT.next();
            System.out.println("Tell me the ID of the Attendee");
            attId = INPUT.next();
            for (int i = 0; i < art.length; i++) {
                for (int j = 0; j < att.length; j++) {
                    if (art[i].getName().equals(artName) && att[i].getId().equals(attId)) {
                        priceArt = art[i].getPrice();
                        if (att[i].prevAtt == true) {
                            priceArt = art[i].getPrice() * iConstants.TICKETPREVATTENDEDISCOUNT;
                            if (att[i] instanceof VIPAttendees) {
                                priceArt = art[i].getPrice() * iConstants.TICKETPREVATTENDEDISCOUNT * iConstants.TICKETVIP;
                                nameReal = true;
                            }
                            nameReal = true;
                        }  
                        else{
                            priceArt = art[i].getPrice();
                            if (att[i] instanceof VIPAttendees) {
                                priceArt = art[i].getPrice() * iConstants.TICKETVIP;
                                nameReal = true;
                            }
                            nameReal = true;
                        }  
                    }
                } 
            }
        }
        System.out.println("your price ticket would be: "+ priceArt);
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

 
        //Query 6

        System.out.println("Tell me the ID of the Attendee: ");
        attId = INPUT.next();

        for (int i = 0; i < art.length; i++) {
            if (att[i].getId().equals(attId)){
                att[i].ticketList.toString();
            }
        }

        //Query 7

    }
}
