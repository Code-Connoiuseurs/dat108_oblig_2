package oppgave3;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Brett {
	
	private int kapasitet;
	private BlockingQueue<Integer> hamburgere;
	private int hamburgerNr = 1;
	
	public Brett(int kapasitet) {
		this.hamburgere = new ArrayBlockingQueue<>(kapasitet);
	}
	
	public void leggTilHamburger(String navn) throws InterruptedException {
		hamburgere.put(hamburgerNr);
		System.out.println(navn + " (Kokk) legger hamburger på brettet <" + hamburgerNr + ">" + " Brett:" + hamburgere);
		hamburgerNr++;
	}
	
	public synchronized int taHambruger(String navn) throws InterruptedException {
			
		int hamburger = hamburgere.take();
		System.out.println(navn + " (Servitør) tar hamburger fra brettet <" + hamburger + ">" + " Brett: " + hamburgere);
		return hamburger;
	}
}
