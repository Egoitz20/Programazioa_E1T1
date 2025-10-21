package bezero;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import funtzioKomplementarioak.KontsolaGarbi;

public class BezeroKontsulta {

	KontsolaGarbi garbi = new KontsolaGarbi();

	Scanner sc = new Scanner(System.in);
	String erantzuna = "";

	public BezeroKontsulta() {

	}

	public void bezeroKontaktuak() {

		do {
			garbi.garbitu();

			System.out.println("Ipini bezero baten ID bat kontsulta egiteko: ");
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
				FileReader fr = new FileReader("BEZERO.txt");
				BufferedReader br = new BufferedReader(fr);

				FileReader fr2 = new FileReader("BEZERO_TELEFONO.txt");
				BufferedReader br2 = new BufferedReader(fr2);

				String lerroa;
				boolean aurkitua = false;

				// Lehen lerroa salto egiten du
				br.readLine();
				br2.readLine();

				while ((lerroa = br.readLine()) != null) {
					String[] separadore = lerroa.split("\t");
					int fitxategiId = Integer.parseInt(separadore[0]);

					if (fitxategiId == id) {
						System.out.println("Izena: " + separadore[1]);
						System.out.println("Abizena: " + separadore[2]);
						System.out.println("Emaila: " + separadore[4]);

						aurkitua = true;
						break; // Aurkituta dago, ateratzen da
					}

				}

				while ((lerroa = br2.readLine()) != null) {
					String[] separadore2 = lerroa.split("\t");
					int fitxategiId2 = Integer.parseInt(separadore2[1]);

					if (fitxategiId2 == id) {
						System.out.println("Telefonoa: " + separadore2[2]);

						aurkitua = true;
						break; // Aurkituta dago, ateratzen da
					}
				}

				if (!aurkitua) {
					System.out.println("Ez da bezerorik aurkitu ID honekin: " + id);
				}

				br.close();
				br2.close();
			}

			catch (FileNotFoundException e) {
				System.out.println("Fitxategia ez da aurkitu");
			} catch (IOException e) {
				System.out.println("Zerbait pasatu da fitxategian...");
			}
			System.out.println();

			System.out.println("Nahi duzu beste bezero bat informazio atera? Bai / Ez");
			erantzuna = sc.nextLine().toUpperCase();
			if (!erantzuna.equals("BAI")) {
				System.out.println("Ateratzen...");

				try {
					Thread.sleep(1000); // 1000 milisegundu = 1 segundu
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				garbi.garbitu();
				Bezeroak bezero = new Bezeroak();
				bezero.bezeroMenu();
			}

		} while (erantzuna.equals("BAI"));

	}

}
