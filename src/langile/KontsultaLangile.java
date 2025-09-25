package langile;

import java.util.Scanner;

import index.KontsolaGarbi;

public class KontsultaLangile {

	KontsolaGarbi garbi = new KontsolaGarbi();

	Scanner sc = new Scanner(System.in);

	public KontsultaLangile() {

	}

	public void informazioLangile() {

		garbi.garbitu();

		System.out.println("Ipini langile bated ID bat kontsulta egiteko: ");
		int id = sc.nextInt();

		System.out.println("Bilatzen...");
		try {
			Thread.sleep(1000); // 1000 milisegundu = 1 segundu
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		//Hemen fitxategia irakurri behar da
		
		System.out.println("Kaixo! :)");

	}

}
