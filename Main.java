import java.io.*;
import java.util.*;


public class Main {
    static final Scanner INPUT = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        Artist[] artList = readArtist("Artistas.txt");
        Attendee[] attList = readAttendee("Asistentes.txt");

        Scanner INPUT = new Scanner(System.in);

        String festName, festCity;

        System.out.println("Welcome to our festival management system!");
        System.out.println("IMPORTANT!! Do not use spaces, instead use underscores!!");

        System.out.println("Please, indicate the festival name: ");
        festName = "ViñaRock"; //INPUT.next();

        System.out.println("Thanks, now please indicate the city the festival will be held on: ");
        festCity = "Viñarrobledo"; //INPUT.next(); //TODO: VOLVER A PONER INPUT.NEXT!!

        Festival ourFestival = new Festival(festName, festCity, artList, attList);

        ShowMenu(ourFestival);
        
    }

        
    public static Attendee[] readAttendee(String file) throws IOException {
		//We read from a file and create a list of attendees with the given info
		File f = new File(file);
		Scanner countf = new Scanner(f);

		String name, dni, creditCard;
		boolean frequent, vip;
		int tarjetaVIP;

		int count = 0;
		while (countf.hasNextLine()) {
			countf.nextLine();
			count++;
		}

		countf.close();

		Attendee[] att = new Attendee[count];
		
		Scanner nombre_f = new Scanner(f);
		count = 0;
		while (nombre_f.hasNext()) {
			name = nombre_f.next();
			dni = nombre_f.next();
			creditCard = nombre_f.next();	
			frequent = nombre_f.nextBoolean();
			vip = nombre_f.nextBoolean();
            
			if (vip){
				tarjetaVIP = nombre_f.nextInt();
				att[count] = new VIPAttendee(name, dni, creditCard, tarjetaVIP, frequent, vip); 
			} 
			else{
				att[count] = new Attendee(name, dni, creditCard, frequent, vip); 
			}
			count++;
		}

		nombre_f.close();
		return att;
	}

    public static Artist[] readArtist(String cadena) throws IOException {
        //We read from a file and create a list of artists with the given info

        //Opens given file and reads from it
		File f = new File(cadena);
		Scanner countf = new Scanner(f);
        
        //Initialization
		
        char group;
        double price;
        int duration, maxAudience, memberNum, phoneNum;
        String name, genre; 
        boolean principal, dressing, merchandising, confirmedAssistance;
		int count = 0;

		while (countf.hasNextLine()) {
			countf.nextLine();
				count++;
			
		}
		countf.close();

		Scanner nombre_f = new Scanner(f);


		Artist[] art = new Artist[count];
        //We use the while to say that while we have text, it has to keep reading, introducing every data in every line of the terminal
		count = 0;
        while (nombre_f.hasNext()) {
            group = nombre_f.next().charAt(0);
            name = nombre_f.next();
            genre = nombre_f.next();
            principal = nombre_f.nextBoolean();
            price = nombre_f.nextDouble();
            duration = nombre_f.nextInt();
            maxAudience = nombre_f.nextInt();
            confirmedAssistance = nombre_f.nextBoolean();

			if (group == 'g') {
				memberNum = nombre_f.nextInt();
				merchandising = nombre_f.nextBoolean();
				art[count] = new Group(name, genre, principal, maxAudience, duration, price, confirmedAssistance, memberNum, merchandising);
			}

			else{
				dressing = nombre_f.nextBoolean();
				phoneNum = nombre_f.nextInt();
				art[count] = new Solo(name, genre, principal, maxAudience, duration, price, confirmedAssistance, dressing, phoneNum);
			}
			count++;
	    }
		nombre_f.close();
		return art;
    } 

    public static Attendee createNewAtt(String id){
        String name, crednum;
        boolean prevAtt, vip;
        int vipnum; //max tickets
        Attendee newAtt;

        System.out.println("We need your some more information, please give us the next data: ");
        System.out.println("name: ");
        name = INPUT.next();
        //No need to ask again for id!
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
            newAtt = new VIPAttendee(name, id, crednum,vipnum, prevAtt, vip);
        }
        else{
            newAtt = new Attendee(name, id, crednum, prevAtt, vip);
        }

        return newAtt;

    }

    public static void ShowMenu(Festival ourFestival){
        boolean finished = false;
        String attID;
        do { 
            System.out.println("Choose one of the following options: ");
            System.out.println("1. Show the information of all scheduled artists.");
            System.out.println("2. Calculate how much the festival's security service would cost.");
            System.out.println("3. Calculate the cost of a ticket. Only for registered attendees!!");
            System.out.println("4. Estimate the cost of attending to all headliners and buying a t-shirt in all merchandising stands.");
            System.out.println("5. Purchase a ticket. Only for confirmed artists!!");
            System.out.println("6. Show all ticket information someone has purchased.");
            System.out.println("7. Show the information of concerts with merchandising for which a VIP has purchased tickets.");
            System.out.println("8. Exit the system");

            int option = INPUT.nextInt();

            switch(option){
                case 1:
                    System.out.println("Here is all the information about our artists");
                    System.out.println(ourFestival.showAllArtistInfo(ourFestival.artistList));

                    break;
                case 2:
                    SecurityCompany secComp = new SecurityCompany("EventoSeguroSL", 250); //It has been written here and not asked since it is in the Problem Description
                    System.out.println("It would cost "+ ourFestival.calculateSecurityCost(ourFestival.artistList, secComp) + " euros");
                    break;
                case 3:
                    System.out.println("Please, introduce your ID: ");
                    attID = INPUT.next();
                    if (ourFestival.checkRegistedAttendee(attID, ourFestival.getAttenList())){
                        System.out.println("Alright. Which concert do you want to attend to?: ");
                        String wantToAttend = INPUT.next();
                        if(ourFestival.checkRealArtist(wantToAttend, ourFestival.getArtList())){
                            System.out.println("It would cost: " + ourFestival.calcPrice(ourFestival.getAttenList(), ourFestival.getArtList(), wantToAttend, attID) + " euros");
                        } else {
                            System.out.println("Something went wrong. That artist is not in our database");
                        }
                    } else {
                        System.out.println("Something went wrong. That attendee is not in our database. ");
                    }
                    break;
                case 4:
                    System.out.println("It would cost: " + ourFestival.estimateMoney(ourFestival.getArtList()) + " euros");
                    break;
                case 5:
                Attendee att;
                System.out.println("Please, introduce your ID: ");
                attID = INPUT.next();
                if (ourFestival.checkRegistedAttendee(attID, ourFestival.getAttenList())){
                    int pos = Festival.attPosition(ourFestival.getAttenList(), attID);
                    att = ourFestival.getAttenList()[pos];
                } else {
                    System.out.println("It seems you are not registered, so we will need some information");
                    att = createNewAtt(attID);
                }

                System.out.println("Alright, now, what Artist do you want to buy tickets for?");
                String arts = INPUT.next();
                if(ourFestival.checkRealArtist(arts, ourFestival.getArtList())){
                    int artPos = ourFestival.artPosition(ourFestival.getArtList(), arts);
                    Artist art = ourFestival.getArtList()[artPos];
                    if(ourFestival.buyTickets(att, art)){
                        System.out.println("Ticket bought for " + arts + ". Thanks!");
                    }
                    else {
                        System.out.println("It looks like something went wrong, you have already acquired 7 tickets. ");
                    }
                } else {
                    System.out.println("Something went wrong. That artist is not in our database");
                }
                    break;
                case 6:
                    System.out.println("Please, introduce your ID: ");
                    attID = INPUT.next();
                    if (ourFestival.checkRegistedAttendee(attID, ourFestival.getAttenList())){
                        System.out.println(ourFestival.showInfoTickets(attID, ourFestival.getAttenList()));
                    } else {
                        System.out.println("Something went wrong. That attendee is not in our database. ");
                    }
                        break;
                case 7:
                    System.out.println(ourFestival.showInfoConcerts(ourFestival.getAttenList()));
                    break;
                case 8:
                    System.out.println("Thanks for using our management system. We hope you enjoy the festival!");
                    finished = true;
                    break;
                default:
                    System.out.println("Sorry, that option is not in the menu.");
                    break;
            }
        } while (!finished);
    }
}