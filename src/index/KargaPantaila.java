package index;

public class KargaPantaila {

	//Denbora ipintzen du. Simulatzen hari da pantaila karga
	
	public KargaPantaila() {
	}

	public void kargatu() {
		
		for (int i = 1; i <= 3; i++) {
			System.out.print(i + "...");
		
			try {
				Thread.sleep(1000); // 1000 milisegundu = 1 segundu
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
		}
	}
}
