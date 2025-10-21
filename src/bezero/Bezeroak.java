package bezero;

import java.util.Scanner;

import funtzioKomplementarioak.KontsolaGarbi;
import menuPrintzipala.Menu;

public class Bezeroak {

	KontsolaGarbi garbi = new KontsolaGarbi();

	Scanner sc = new Scanner(System.in);

	BezeroKontsulta bezeroKontsulta = new BezeroKontsulta();
	BezeroFaktura faktura = new BezeroFaktura();


	public Bezeroak() {

	}

	public void bezeroMenu() {
		garbi.garbitu();

		System.out.println("***** < BEZERO FUNTZIOAK > *****");
		System.out.println("1. Bezeroaren kontaktuak kontsultatu ");
		System.out.println("2. Bezero batek egindako erosketa baten faktura sortu ");
		System.out.println("3. Atzera joan ");
		System.out.println("********************************");

		int aukera = sc.nextInt();

		switch (aukera) {
		case 1:
			bezeroKontsulta.bezeroKontaktuak();
			break;
		case 2:
			faktura.faktura();
			break;
		case 3:
			Menu menu = new Menu();
			menu.menuPrintzipala();
			break;
		default:
			System.out.println("Zenbaki hori ez dago bezeroaren menu...");

		}

	}
}
