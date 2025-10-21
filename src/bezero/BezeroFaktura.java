package bezero;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

import funtzioKomplementarioak.KontsolaGarbi;

public class BezeroFaktura {

	KontsolaGarbi garbi = new KontsolaGarbi();

	Scanner sc = new Scanner(System.in);
	String erantzuna = "";

	public BezeroFaktura() {

	}

	public void faktura() {

		do {
			garbi.garbitu();

			System.out.println("Ipini bezero baten ID bat kontsulta egiteko: ");
			int bezeroId = sc.nextInt();
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

				FileReader fr2 = new FileReader("ESKARI.txt");
				BufferedReader br2 = new BufferedReader(fr2);

				FileReader fr3 = new FileReader("ESKARI_LERRO.txt");
				BufferedReader br3 = new BufferedReader(fr3);

				String lerroa;
				boolean aurkitua = false;
				int eskariId = -1;
				double guztira = 0.0;

				// Lehen lerroa salto egiten du
				br.readLine();
				br2.readLine();
				br3.readLine();

				// 1) Bezeroa bilatu
				while ((lerroa = br.readLine()) != null) {
					String[] cols = lerroa.split("\t");
					int idBezero = Integer.parseInt(cols[0]);

					if (idBezero == bezeroId) {
						System.out.println("IZENA: " + cols[1] + " " + cols[2]);
						System.out.println("EMAILA: " + cols[4]);
						aurkitua = true;
						break;
					}
				}
				// 2) Eskaria bilatu
				while ((lerroa = br2.readLine()) != null) {
					String[] cols = lerroa.split("\t");
					int idBezero = Integer.parseInt(cols[1]);

					if (idBezero == bezeroId) {
						eskariId = Integer.parseInt(cols[0]);
						System.out.println("ESKARI ID: " + eskariId);
						System.out.println("DATA: " + cols[3]);
						aurkitua = true;
						break;
					}
				}

				// 3) Eskariaren lerroak irakurri
				StringBuilder fakturaTestua = new StringBuilder();
				fakturaTestua.append("FAKTURA - ESKARI ID: ").append(eskariId).append("\n");
				fakturaTestua.append("=================================\n");

				while ((lerroa = br3.readLine()) != null) {
					String[] cols = lerroa.split("\t");
					int idEskari = Integer.parseInt(cols[0]);

					if (idEskari == eskariId) {
						int kopurua = Integer.parseInt(cols[3]);
						double salneurria = Double.parseDouble(cols[4].replace(",", "."));
						double subtotal = kopurua * salneurria;
						guztira += subtotal;

						fakturaTestua.append("Produktu ID: ").append(cols[2]).append(" | Kopurua: ").append(kopurua)
								.append(" | Prezioa: ").append(salneurria).append(" | Subtotal: ")
								.append(String.format("%.2f", subtotal)).append("\n");

						System.out.println("Produktu ID: " + cols[2]);
						System.out.println("Kopurua: " + kopurua);
						System.out.println("Salneurria: " + salneurria);
						System.out.println("Subtotal: " + String.format("%.2f", subtotal));
						System.out.println("----------------------");
					}
				}

				DecimalFormat df = new DecimalFormat("#.00");
				String guztiraStr = df.format(guztira);

				fakturaTestua.append("=================================\n");
				fakturaTestua.append("GUZTIRA: ").append(guztiraStr).append(" €\n");

				System.out.println("GUZTIRA: " + guztiraStr + " €");

				// 4) Fitxategian gorde faktura
				if (eskariId != -1) {
					try (BufferedWriter bw = new BufferedWriter(new FileWriter("FAKTURA_" + eskariId + ".txt"))) {
						bw.write(fakturaTestua.toString());
					}
					System.out.println(">> Faktura sortu da fitxategian: FAKTURA_" + eskariId + ".txt");
				}

				if (!aurkitua) {
					System.out.println("Ez da aurkitu bezeroa edo eskaria ID honekin: " + bezeroId);
				}

				// Fitxategiak ixten dira
				br.close();
				br2.close();
				br3.close();
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
