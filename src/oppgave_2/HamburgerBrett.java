package oppgave_2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

public class HamburgerBrett {
	private final int KAPASITET;
	private Queue<Hamburger> brett = new LinkedList<Hamburger>();
	private AtomicInteger hamburgerNr = new AtomicInteger(1);

	public HamburgerBrett(int KAPASITET) {
		this.KAPASITET = KAPASITET;
	}

	public synchronized boolean erTomt() {
		return brett.isEmpty();
	}

	private synchronized int antall() {
		return brett.size();
	}

	public Hamburger leggTil(Hamburger burger) {
		if (erFullt()) return null;
		burger.setNummer(hamburgerNr.getAndIncrement());
		brett.add(burger);
		return burger;
	}

	public boolean erFullt() {
		return antall() >= KAPASITET;
	}

	public Hamburger fjern() {
		if (erTomt()) return null;
		return brett.poll();
	}

	@Override
	public synchronized String toString() {
		return brett.toString();
	}	

}
