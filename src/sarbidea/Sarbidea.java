package sarbidea;

import java.util.Arrays;
import java.util.Scanner;

import index.KargaPantaila;
import index.KontsolaGarbi;
import menuPrintzipala.Menu;

public class Sarbidea {

	KargaPantaila karga = new KargaPantaila();
	KontsolaGarbi garbi = new KontsolaGarbi();
	Menu menu = new Menu();

	Scanner sc = new Scanner(System.in);

	String erabiltzaile;
	String erabiltzailea[] = { "eguerras", "aantillaque", "aolmo", "gmaroto" };
	String pasahitza;
	String hasi = "";
	int saikera = 3;

	public Sarbidea() { 
		
	}
	
	public void login() {
		
		do {
			System.out.println("Erabiltzailea: ");
			erabiltzaile = sc.nextLine();

			System.out.println("Pasahitza: ");
			pasahitza = sc.nextLine();

			if (Arrays.asList(erabiltzailea).contains(erabiltzaile) && pasahitza.equals("ikasle123")) {
				garbi.garbitu();
				System.out.println("Sartzen...");
				karga.kargatu();
				menu.menuPrintzipala();
			} else {
				saikera--;
				if (saikera > 0) {
					System.out.println("Izena edo Pasahitza ez dago ondo. Saiatu berriro? Bai / Ez");
					System.out.println("Gainerako Saikera: " + saikera);
					hasi = sc.nextLine().toUpperCase();
					garbi.garbitu();
					if (!(hasi.equals("BAI"))) {
						System.out.println("Ixten...");
						karga.kargatu();
						garbi.garbitu();
						System.exit(0);
					}
				} else {
					System.out.println("Saiakeren mugara iritsi zara, programa ixten...");
					karga.kargatu();
					System.exit(0);
				}
			}

		} while (hasi.equals("BAI"));
	}

}
