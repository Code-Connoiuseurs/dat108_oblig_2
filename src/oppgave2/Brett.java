package oppgave2;

import java.util.LinkedList;
import java.util.Queue;

public class Brett {
	
	private int kapasitet;
	private Queue<Integer> hamburgere;
	private int hamburgerNr = 1;
	
	public Brett(int kapasitet) {
		this.kapasitet = kapasitet;
		this.hamburgere = new LinkedList<Integer>();
	}
	
	public synchronized void leggTilHamburger(String navn) throws InterruptedException {
		while(hamburgere.size() >= kapasitet) {
			System.out.println("Brettet er fullt. servitøren sliter");
			wait();
		}
		hamburgere.add(hamburgerNr);
		System.out.println(navn + " (Kokk) legger hamburger på brettet <" + hamburgerNr + ">" + " Brett:" + hamburgere);
		hamburgerNr++;
		notifyAll();
	}
	
	public synchronized int taHambruger(String navn) throws InterruptedException {
		while(hamburgere.isEmpty()) {
			System.out.println("Servitør ønsker å ta hamburger men, brettet er tomt. servitøren sovner. ");
			wait();
		}
		int hamburger = hamburgere.poll();
		System.out.println(navn + " (Servitør) tar hamburger fra brettet <" + hamburger + ">" + " Brett: " + hamburgere);
		notifyAll();
		return hamburger;
	}
}
