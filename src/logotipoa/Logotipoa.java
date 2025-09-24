package logotipoa;

public class Logotipoa {

	public Logotipoa() {
	}

	public void logo() {

		// Funtzioekin egiten da, kodean irudi batzuk errepikatzen baitira;
		// orduan, kode bera ez errepikatzeagatik eta optimizatuago egiteagatik,
		// funtzioekin egin dugu.

		triangeluBuruzBehera(); // Funtzioari deitzen zaio, triangelua ahoz behera egin dezan, betelanarekin.

		triangeluAhozGora(); // Funtzioari deitzen zaio, triangelua ahoz gora egin dezan, betelanarekin.

		piramideBetegabea(); // Funtzioari deitzen zaio, triangelua ahoz gora egin dezan, ez beteta.

		lerroHorizontala(); // Funtzioari deitzen zaio, lerro horizontala egiteko.

		System.out.println();

		lerroBertikala(); // Funtzioari deitzen zaio, lerro bertikala egiteko.

		lerroHorizontala(); // Funtzioari deitzen zaio, lerro horizontala egiteko.

		System.out.println();

		piramideBetegabea(); // Funtzioari deitzen zaio, triangelua ahoz gora egin dezan, ez beteta.

	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/// ///
	/// FUNTZIOAK ///
	/// ///
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private void triangeluBuruzBehera() {

		// Lehenengo "for" (b...) hasierako tarteak inprimatzen ditu.
		// Bigarren "for" (j...) inprimatzen "i" izartxoak jarraian.

		for (int i = 7; i >= 2; i -= 2) { // "i" lerro bakoitzeko "*" zenbakia kontrolatzen du. Hartu 7, 5, 3 balioak (7
											// hasten delako eta 2 kentzen duelako i > = 2 izan arte).
			for (int b = 0; b < (7 - i) / 2; b++) { // (7 - i)/2 kalkulatu zenbat espazio dauden errenkada zentratzeko.
													// Zatiketa osoa erabiltzen du; i bakoitia eta guztira 7 izanik,
													// behar bezala zentratuta geratzen da.
				System.out.print(" ");
			}
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	private void triangeluAhozGora() {
		for (int i = 1; i <= 7; i += 2) { // "i" hartzen du 1, 3, 5, 7 (hazi 2tik 2ra), beraz, oinarria 7 "*" ditu.
			for (int b = 0; b < (7 - i) / 2; b++) { // (7 - i)/2 kalkulatu zentratzeko ezkerreko espazioak.
				System.out.print(" ");
			}
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	private void lerroHorizontala() {
		// Inprimatu 7 "*" lerro berean jarraituta. Ez du println egiten amaieran, eta,
		// beraz, kurtsorea "*" horien amaieran geratzen da, lerro berean.

		for (int i = 1; i <= 7; i++) {
			System.out.print("*");
		}
	}

	private void lerroBertikala() {
		// Emaitza: 3 "*"-ko zutabe bertikal bat, eskuinean 3 espazio dituena.

		for (int i = 1; i <= 3; i++) {
			for (int b = 1; b < 4; b++) { // b = 1; b < 4 barruko begiztak 3 espazio inprimatzen ditu (b = 1,2,3).
				System.out.print(" ");
			}

			System.out.println("*"); // "*" bat inprimatu eta lerro-jauzia gehitu.

		}
	}

	private void piramideBetegabea() {
		// "i" ilara da, 1etik 4ra doa (altuera 4).

		for (int i = 1; i <= 4; i++) {
			for (int b = i; b < 4; b++) { // Piramidea zentratzeko espazioak inprimatzen ditu (4-i).

				System.out.print(" ");
			}

			System.out.print("*");

			// "i > 1" bada, barruko "2 * (i - 1) - 1" espazioa inprimatzen du, eta, gero,
			// "*" eskuinekoa (eskuineko ertza). Honek piramide hutsa sortzen du.

			if (i > 1) {

				for (int k = 1; k <= 2 * (i - 1) - 1; k++) {
					System.out.print(" ");
				}
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
