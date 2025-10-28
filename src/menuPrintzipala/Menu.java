package menuPrintzipala;

import java.util.Scanner;

import bezero.Bezeroak;
import funtzioKomplementarioak.KargaPantaila;
import funtzioKomplementarioak.KontsolaGarbi;
import langile.Langileak;
import sarbidea.Sarbidea;

public class Menu {
	
	public Menu() {
	}
	
	public void menuPrintzipala() {
		
		int aukera;
		
		KontsolaGarbi.garbitu();
		new Logotipoa().logo(); //Deitzen da logo objektuari terminalean ikusteko
		
		Scanner sc = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		
		String itxi;
		
		Langileak langile = new Langileak(); // Langile objektua (Menu Printzipala)
		Bezeroak bezero = new Bezeroak(); // Bezero objektua (Menu Printzipala)

		for (int i = 0; i < 3; i++) { //3 linea saltatzen ditu 
			System.out.println("");
		}
		
		System.out.println("***** < MENU PRINTZIPALA > *****");
		System.out.println("1. Langileak");
		System.out.println("2. Bezeroak");
		System.out.println("3. Saioa Itxi");
		System.out.println("********************************");

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
					KontsolaGarbi.garbitu();
					System.out.println("Saioa itxi nahi duzu? Bai/Ez");
					itxi = sc2.nextLine();
					itxi = itxi.toUpperCase();
					if (itxi.equals("BAI")) {
						System.out.println("Saioa ixten...");
						KargaPantaila.kargatu();
						KontsolaGarbi.garbitu();
						Sarbidea sarbide = new Sarbidea();
						sarbide.login();
					} else {
						KontsolaGarbi.garbitu();
						menuPrintzipala();
					}
				break;
			} else {
				KontsolaGarbi.garbitu();
				System.out.println("Zenbaki hori ez dago pantaila honetan, saiatu berriro:");
			}
		} while (aukera != 1 && aukera != 2 && aukera != 3);
		
		sc.close();
		sc2.close();

	}

}
