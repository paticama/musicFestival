//Rafael Camilo Rubio and Patricia Camacho

import java.io.*;
import java.util.*;

    
public class Assignment1 {   
    
    public void readArtist(String cadena) throws IOException {
        //Opens given file and reads from it
		File f = new File(cadena);
		Scanner nombre_f = new Scanner(f);
        
        //Initialization
        char group;
        double price;
        int duration, maxAudience, memberNum, phoneNum;
        String name, genre; 
        boolean principal, dressing, merchandising, confirmedAssistance;
		
        //We use the while to say that while we have text, it has to keep reading, introducing every data in every line of the terminal
        while (nombre_f.hasNext()) {
            group = nombre_f.next().charAt(0);
            name = nombre_f.next();
            genre = nombre_f.next();
            principal = nombre_f.nextBoolean();
            price = nombre_f.nextDouble();
            duration = nombre_f.nextInt();
            maxAudience = nombre_f.nextInt();
            confirmedAssistance = nombre_f.nextBoolean();
            //if its a group, it will have different parameters than a solist, a group will have merchandise and the number of members while the solist will have its phone number and if he wants a dressing room
			if (group == 'g') {
                memberNum = nombre_f.nextInt();
                merchandising = nombre_f.nextBoolean();
                System.out.println(group + " " + name + " " + genre + " " +  principal + " " + price+ " " + duration + " " + maxAudience + " " + confirmedAssistance + " " + memberNum + " " + merchandising);
            }
            else {
                dressing = nombre_f.nextBoolean();
                phoneNum = nombre_f.nextInt();
                System.out.println(group + " " + name + " "+ genre + " " + principal + " " + price+ " " + duration + " " + maxAudience + " " + confirmedAssistance + " " + dressing + " " + phoneNum);
            }
	    }
    }
}
