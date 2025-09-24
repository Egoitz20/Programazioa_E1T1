package index;

public class KargaPantaila {

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
