package langile;

import java.util.Scanner;

import funtzioKomplementarioak.KontsolaGarbi;
import menuPrintzipala.Menu;

public class Langileak {
	
	

	public Langileak() {
	}
	
	public void langileMenu() {
		
		KontsultaLangile kontsulta = new KontsultaLangile();
		NagusiZerrenda zerrenda = new NagusiZerrenda();
		
		Scanner sc = new Scanner(System.in);
		
		KontsolaGarbi.garbitu();
		
		System.out.println("***** < LANGILE FUNTZIOAK > *****");
		System.out.println("1. Kontsultatu langile baten informazio");
		System.out.println("2. Nagusi baten langileen zerrenda erakutsi");
		System.out.println("3. Menu Printzipalara Joan");
		System.out.println("********************************");

		int aukera;
		
		do {
			System.out.println("Zer egin nahi duzu? (Bakarrik 1, 2 edo 3)");
			aukera = sc.nextInt();
			if (aukera == 1) {
				kontsulta.informazioLangile();
				break;
			}
			if (aukera == 2) {
				zerrenda.nagusiLangile();
				break;
			}
			if (aukera == 3) {
				new Menu().menuPrintzipala();
				break;
			} else {
				KontsolaGarbi.garbitu();
				System.out.println("Zenbaki hori ez dago pantaila honetan, saiatu berriro:");
			}
		} while (aukera != 1 && aukera != 2 && aukera != 3);
		
		sc.close();

	}
	
}
