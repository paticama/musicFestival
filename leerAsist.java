import java.io.*;
import java.util.*;

public class leerAsist {
	public static void main (String[]args) throws IOException { 
    	leerAsistentes ("Asistentes.txt");
	}

	// Método que lee los asistentes del fichero de texto
	public static void leerAsistentes(String cadena) throws IOException {
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
			System.out.print(nombre +" "+ dni+" "+ tarjeta+" "+ frecuente+" "+ vip);
			if (vip) { 
				tarjetaVIP = nombre_f.nextInt();
				System.out.println(" "+tarjetaVIP);
			} else 
			{
				System.out.println();
			}
		}
	} 
}

public Artist leerAsistentes2(String cadena){
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
		if (vip){
			tarjetaVIP = nombre_f.nextInt();
		}

		

	}
}