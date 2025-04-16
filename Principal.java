import java.io.*;
import java.util.*;

public class Principal {

	// Método que lee los asistentes del fichero de texto
	// public void leerAsistentes(String cadena) throws IOException {
	// 	File f = new File(cadena);
	// 	Scanner nombre_f = new Scanner(f);

	// 	String nombre, dni, tarjeta;
	// 	boolean frecuente, vip;
	// 	int tarjetaVIP;
				 
	// 	while (nombre_f.hasNext()) {
	// 		nombre = nombre_f.next();
	// 		dni = nombre_f.next();
	// 		tarjeta = nombre_f.next();	
	// 		frecuente = nombre_f.nextBoolean();
	// 		vip = nombre_f.nextBoolean();
	// 		System.out.print(nombre +" "+ dni+" "+ tarjeta+" "+ frecuente+" "+ vip);
	// 		if (vip) { 
	// 			tarjetaVIP = nombre_f.nextInt();
	// 			System.out.println(" "+tarjetaVIP);
	// 		} else 
	// 		{
	// 			System.out.println();
	// 		}
	// 	}
	// } 
	public void leerAsistentes(String cadena) throws IOException {
		File f = new File(cadena);
		Scanner nombre_f = new Scanner(f);

		String nombre, dni, tarjeta;
		boolean frecuente, vip;
		int tarjetaVIP;
				 
		while (nombre_f.hasNext()) {
			nombre = nombre_f.next();
			dni = nombre_f.next();
			tarjeta = nombre_f.next();	
			frecuente = nombre_f.nextBoolean();
			vip = nombre_f.nextBoolean();
		}
	}
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
           
	    }
		Artist[]artists;
    } 
}
