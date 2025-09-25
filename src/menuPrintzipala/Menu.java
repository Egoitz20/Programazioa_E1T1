package menuPrintzipala;

import java.util.Scanner;

import bezero.Bezeroak;
import index.KontsolaGarbi;
import langile.Langileak;
import sarbidea.Sarbidea;

public class Menu {

	// PIJADITAK
	KontsolaGarbi garbi = new KontsolaGarbi();
	Logotipoa lg = new Logotipoa();

	// ERRONKA ESKATZEN DUEN PAUTAK
	Langileak langile = new Langileak();
	Bezeroak bezero = new Bezeroak();

	// DEKLARAZIOAK
	Scanner sc = new Scanner(System.in);
	int aukera;

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

		do {
			System.out.println("Non sartu nahi duzu? (Bakarrik 1, 2 edo 3)");
			aukera = sc.nextInt();
			if (aukera == 1) {
				langile.langileInformazioa();
				break;
			}
			if (aukera == 2) {
				bezero.bezeroInformazioa();
				break;
			}
			if (aukera == 3) {
				garbi.garbitu();
				Sarbidea sarbide = new Sarbidea();
				sarbide.login();
				break;
			} else {
				garbi.garbitu();
				System.out.println("Zenbaki hori ez dago pantaila honetan, saiatu berriro:");
			}
		} while (aukera != 1 && aukera != 2 && aukera != 3);

	}

}
