package menuPrintzipala;

import java.util.Scanner;

import index.KontsolaGarbi;
import logotipoa.Logotipoa;
import sarbidea.Sarbidea;

public class Menu {

	// PIJADITAK
	KontsolaGarbi garbi = new KontsolaGarbi();
	Logotipoa lg = new Logotipoa();

	Scanner sc = new Scanner(System.in);
	// ERRONKA ESKATZEN DUEN PAUTAK
	Langileak langile = new Langileak();
	Bezeroak bezero = new Bezeroak();

	public Menu() {
	}

	public void menuPrintzipala() {

		garbi.garbitu();
		lg.logo();

		for (int i = 0; i < 3; i++) {
			System.out.println("");
		}

		System.out.println("***** < MENU PRINTZIPALA > *****");
		System.out.println("1. Langileak");
		System.out.println("2. Bezeroak");
		System.out.println("3. Saioa Itxi");
		System.out.println("********************************");
		
		System.out.println("Non sartu nahi duzu? (Bakarrik 1, 2 edo 3)");
		int aukera = sc.nextInt();
		do {
			if (aukera == 1) {
				garbi.garbitu();
				langile.langileInformazioa();
			}
			if (aukera == 2) {
				garbi.garbitu();
				bezero.bezeroInformazioa();
			}
			if (aukera == 3) {
				garbi.garbitu();
				Sarbidea sarbide = new Sarbidea();
				sarbide.login();
			} else {
				System.out.println("Zenbaki hori ez dago pantaila honetan, saiatu berriro:");
			}
		} while (aukera == 1 || aukera == 2 || aukera == 3);
	}

}
