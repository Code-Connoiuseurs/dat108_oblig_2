package oppgave_2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

public class HamburgerBrett {
	private Queue<Hamburger> brett = new LinkedList<>();
	private int kapasitet;
	private AtomicInteger atomicHamburgerNr = new AtomicInteger(1);

	public HamburgerBrett(int kapasitet) {
		this.kapasitet = kapasitet;
	}

	public boolean erTom() {
		return brett.isEmpty();
	}

	// leggTil
	public boolean leggTil(Hamburger hamburger) {
		if (erFull()) {
			return false;
		}
		hamburger.setHamburgerNr(atomicHamburgerNr.getAndIncrement());
		return brett.add(hamburger);
	}

	// fjern
	public Hamburger fjern() {
		return brett.poll();
	}

	// antall
	public int antall() {
		return brett.size();
	}

	public boolean erFull() {
		return antall() >= kapasitet;
	}

	@Override
	public String toString() {
		return "Brett: " + brett;
	}

}
