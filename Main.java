
import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException {

        Principal reader = new Principal();
        Artist art[] = reader.readArtist("Artistas.txt");

        for (int i = 0; i < art.length; i++) {
            System.out.println(art[i].toString());
        }
 

    }

    

}
