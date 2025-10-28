package sarbidea;

import java.util.Arrays;
import java.util.Scanner;

import funtzioKomplementarioak.KargaPantaila;
import funtzioKomplementarioak.KontsolaGarbi;
import menuPrintzipala.Menu;

public class Sarbidea {

	// Atal honetan, erabiltzailea eta pasahitza eskatzen ditu, eta aurrez
	// definituta dagoenarekin bat egiten du erabiltzaileari programan sartzen
	// uzteko edo ez uzteko.
	
	public Sarbidea() {
	}

	public void login() {

		Scanner sc = new Scanner(System.in);

		String erabiltzaile;
		
		// Forma estatiko batean gordentezen dira erabiltzaile derrigorrezkoak.
		String erabiltzailea[] = { "eguerras", "aantillaque", "aolmo", "gmaroto" }; 
		
		String pasahitza;
		String login = "";
		int saikera = 4;

		do {
			
			System.out.println("Erabiltzailea: ");
			erabiltzaile = sc.nextLine();

			System.out.println("Pasahitza: ");
			pasahitza = sc.nextLine();
			
			// Linea horretan, terminaletik sartzen den erabiltzailea 24 linearen array-an gordeta dagoenera eramaten du, eta zuzena den ala ez egiaztatzen du.
			if (Arrays.asList(erabiltzailea).contains(erabiltzaile) && pasahitza.equals("ikasle123")) {  
				//Terminaletik sartutako erabiltzailea eta pasahitza bat badatoz programan dagoeneko jarrita dagoenarekin, menu nagusira bideratzen ditu zuzenean.
				KontsolaGarbi.garbitu();
				System.out.println("Sartzen...");
				KargaPantaila.kargatu();
				new Menu().menuPrintzipala();

			} else {
				//Eta egokia ez bada, saio bat kendu eta programak galdetuko du ea berriro saiatu nahi duzun ala ez. Erantzunaren arabera, gauza bat edo bestea egingo du
				saikera--;
				if (saikera > 0) {
					System.out.println("Izena edo Pasahitza ez dago ondo. Saiatu berriro? Bai / Ez");
					System.out.println("Gainerako Saikera: " + saikera);
					login = sc.nextLine().toUpperCase();
					KontsolaGarbi.garbitu();
					if (!(login.equals("BAI"))) {
						System.out.println("Ixten...");
						KargaPantaila.kargatu();
						KontsolaGarbi.garbitu();
						System.exit(0);
					}
					
				} else {
					//Eta saiakera kopurua agortzen denean, automatikoki programa itxi egiten da
					System.out.println("Saiakeren mugara iritsi zara, programa ixten...");
					KargaPantaila.kargatu();
					System.exit(0);
				}
			}

		} while (login.equals("BAI"));

		sc.close();
	}

}
