package oppgave2;

import java.util.LinkedList;
import java.util.Queue;

public class HamburgerBrett {

	private int hamburgerNr = 1;
	private int KAPASITET;
	private Queue<Hamburger> hamburgerBrett = new LinkedList<>();

	public HamburgerBrett(int KAPASITET) {
		this.KAPASITET = KAPASITET;
	}
	
	public boolean erTom() {
		return hamburgerBrett.isEmpty();
	}
	
	// add
	public boolean leggTilHamburger(Hamburger nyBurger) {
		if (hamburgerBrett.size() >= KAPASITET) {
			return false; 
		} else {
			nyBurger.setHamburgerNr(hamburgerNr);
			hamburgerBrett.add(nyBurger);
			hamburgerNr++;
			return true;
		}
	}
	
	// remove
	public synchronized Hamburger taHamburger() {
		return hamburgerBrett.poll();
	}
	
	
	public int antall() {
		return hamburgerBrett.size();
	}
	
	@Override
	public String toString() {
		return "Brett: " + hamburgerBrett;
	}

}
