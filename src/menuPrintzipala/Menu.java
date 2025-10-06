package menuPrintzipala;

import java.util.Scanner;

import bezero.Bezeroak;
import index.KargaPantaila;
import index.KontsolaGarbi;
import langile.Langileak;
import sarbidea.Sarbidea;

public class Menu {

	// PIJADITAK
	KontsolaGarbi garbi = new KontsolaGarbi();
	Logotipoa lg = new Logotipoa();
	KargaPantaila karga = new KargaPantaila();

	// ESKATZEN DUEN MENUAK
	Langileak langile = new Langileak(); // Langile objektua (Menu Printzipala)
	Bezeroak bezero = new Bezeroak(); // Bezero objektua (Menu Printzipala)
	

	// DEKLARAZIOAK
	Scanner sc = new Scanner(System.in);
	Scanner sc2 = new Scanner(System.in);
	int aukera;
	String itxi;

	
	//Eraikitzailea hutsa sortzen 
	public Menu() {
	}

	public static void menuEgitura() {
		
		System.out.println("***** < MENU PRINTZIPALA > *****");
		System.out.println("1. Langileak");
		System.out.println("2. Bezeroak");
		System.out.println("3. Saioa Itxi");
		System.out.println("********************************");
		
	}
	
	
	public void menuPrintzipala() {

		garbi.garbitu(); // garbitzen da terminala
		lg.logo(); //Deitzen da logo objektuari terminalean ikusteko

		for (int i = 0; i < 3; i++) {
			System.out.println("");
		}
		
		menuEgitura();

		do {
			System.out.println("Non sartu nahi duzu? (Bakarrik 1, 2 edo 3)");
			aukera = sc.nextInt();
			if (aukera == 1) {
				langile.langileMenu();
				break;
			}
			if (aukera == 2) {
				bezero.bezeroMenu();
				break;
			}
			if (aukera == 3) {
					garbi.garbitu();
					System.out.println("Saioa itxi nahi duzu? Bai/Ez");
					itxi = sc2.nextLine();
					itxi = itxi.toUpperCase();
					if (itxi.equals("BAI")) {
						System.out.println("Saioa ixten...");
						karga.kargatu();
						garbi.garbitu();
						Sarbidea sarbide = new Sarbidea();
						sarbide.login();
					} else {
						garbi.garbitu();
						menuPrintzipala();
					}
				break;
			} else {
				garbi.garbitu();
				System.out.println("Zenbaki hori ez dago pantaila honetan, saiatu berriro:");
			}
		} while (aukera != 1 && aukera != 2 && aukera != 3);

	}

}
