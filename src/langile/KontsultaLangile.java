package langile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
		
		try {
			FileReader fr = new FileReader("src/LANGILE.txt");
			BufferedReader br = new BufferedReader(fr);
			String buskadorea;
			while ((buskadorea = br.readLine()) != null) {
				String[] separadore = buskadorea.split("	");
				System.out.println("Izena: " + separadore[1]);
				System.out.println("Abizena: " + separadore[2]);
				System.out.println("Telefonoa: " + separadore[4]);
				System.out.println("Alta: " + separadore[5]);
			}
		} 
		catch (FileNotFoundException e) {
			System.out.println("Fitxategia ez da aurkitu");
		}
		catch(IOException e) {
			System.out.println("Zerbait pasatu da fitxategian...");
		}


	}

}
