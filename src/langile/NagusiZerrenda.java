package langile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import funtzioKomplementarioak.KontsolaGarbi;

public class NagusiZerrenda {

	KontsolaGarbi garbi = new KontsolaGarbi();
	Scanner sc = new Scanner(System.in);
	String erantzuna = "";

	public NagusiZerrenda() {

	}

	public void nagusiLangile() {

	    do {
	        garbi.garbitu();

	        System.out.println("Ipini nagusi baten ID bat kontsulta egiteko: ");
	        int id = sc.nextInt();
	        sc.nextLine(); // buffer garbitu

	        System.out.println("Bilatzen...");
	        try {
	            Thread.sleep(1000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	        System.out.println();

	        try {
	            FileReader fr = new FileReader("LANGILE.txt");
	            BufferedReader br = new BufferedReader(fr);

	            String lerroa;
	            boolean aurkitua = false;
	            boolean langileakAurkitu = false;

	            // Lehen lerroa salto egiten du (izenburuak)
	            br.readLine();

	            // Lehenengoan, aurkitu nagusiaren datuak
	            while ((lerroa = br.readLine()) != null) {
	                String[] separadore = lerroa.split("\t");
	                int fitxategiId = Integer.parseInt(separadore[0]); // ID nagusia da lehenengo zutabea

	                if (fitxategiId == id) {
	                    System.out.println("NAGUSIAREN DATUAK");
	                    System.out.println("----------------");
	                    System.out.println("Izena: " + separadore[1]);
	                    System.out.println("Abizena: " + separadore[2]);
	                    System.out.println("Emaila: " + separadore[3]);
	                    aurkitua = true;
	                    break;
	                }
	            }

	            if (!aurkitua) {
	                System.out.println("Ez da nagusi aurkitu ID honekin: " + id);
	            } else {
	                // Fitxategia berriro irakurri langileak bilatzeko
	                br.close();
	                fr = new FileReader("LANGILE.txt");
	                br = new BufferedReader(fr);
	                br.readLine(); // salto izenburua

	                System.out.println("\nLANGILEAK:");
	                System.out.println("-----------");

	                while ((lerroa = br.readLine()) != null) {
	                    String[] separadore = lerroa.split("\t");
	                    int idNagusi = Integer.parseInt(separadore[6]);

	                    if (idNagusi == id) {
	                        System.out.println("Izena: " + separadore[1] + " | Abizena: " + separadore[2]);
	                        langileakAurkitu = true;
	                    }
	                }

	                if (!langileakAurkitu) {
	                    System.out.println("Ez dago langilerik nagusi horrekin.");
	                }
	            }

	            br.close();
	        } catch (FileNotFoundException e) {
	            System.out.println("Fitxategia ez da aurkitu");
	        } catch (IOException e) {
	            System.out.println("Zerbait pasatu da fitxategian...");
	        }

	        System.out.println();
	        System.out.println("Nahi duzu beste nagusi bat informazio atera? Bai / Ez");
	        erantzuna = sc.nextLine().toUpperCase();

	        if (!erantzuna.equals("BAI")) {
	            System.out.println("Ateratzen...");
	            try {
	                Thread.sleep(1000);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }

	            garbi.garbitu();
	            Langileak langileMenu = new Langileak();
	            langileMenu.langileMenu();
	        }

	    } while (erantzuna.equals("BAI"));
	}
}
