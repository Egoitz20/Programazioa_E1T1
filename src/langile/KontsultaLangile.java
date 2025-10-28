package langile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import funtzioKomplementarioak.KontsolaGarbi;

public class KontsultaLangile {

	public KontsultaLangile() {
	}

	public void informazioLangile() {

		Scanner sc = new Scanner(System.in);
		String erantzuna = "";
		
		do {
			KontsolaGarbi.garbitu();

			System.out.println("Ipini langile bated ID bat kontsulta egiteko: ");
			int id = sc.nextInt();
			sc.nextLine(); 

			System.out.println("Bilatzen...");
			try {
				Thread.sleep(1000); // 1000 milisegundu = 1 segundu
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println();

			// Fitxategia

			try {
				FileReader fr = new FileReader("LANGILE.txt");
				BufferedReader br = new BufferedReader(fr);

				String lerroa;
				boolean aurkitua = false;

				// Lehen lerroa salto egiten du
				br.readLine();

				while ((lerroa = br.readLine()) != null) {
					String[] separadore = lerroa.split("\t");
					int fitxategiId = Integer.parseInt(separadore[0]);

					if (fitxategiId == id) {
						System.out.println("Izena: " + separadore[1]);
						System.out.println("Abizena: " + separadore[2]);
						System.out.println("Telefonoa: " + separadore[4]);
						System.out.println("Kontratazio Data: " + separadore[5]);
						aurkitua = true;
						break; // Aurkituta dago, ateratzen da
					}
				}

				if (!aurkitua) {
					System.out.println("Ez da langilea aurkitu ID honekin: " + id);
				}

				br.close();
			}

			catch (FileNotFoundException e) {
				System.out.println("Fitxategia ez da aurkitu");
			} catch (IOException e) {
				System.out.println("Zerbait pasatu da fitxategian...");
			}
			System.out.println();

			System.out.println("Nahi duzu beste langile bat informazio atera? Bai / Ez");
			erantzuna = sc.nextLine().toUpperCase();
			if (!erantzuna.equals("BAI")) {
				System.out.println("Ateratzen...");

				try {
					Thread.sleep(1000); // 1000 milisegundu = 1 segundu
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				KontsolaGarbi.garbitu();
				Langileak langileMenu = new Langileak();
				langileMenu.langileMenu();

			}

		} while (erantzuna.equals("BAI"));
		sc.close();

	}
}
