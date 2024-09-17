package oppgave_3;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class HamburgerBrett {
	private BlockingQueue<Hamburger> brett;
	private AtomicInteger hamburgerNr = new AtomicInteger(1);

	public HamburgerBrett(int KAPASITET) {
		this.brett = new LinkedBlockingQueue<Hamburger>(KAPASITET);
	}

	public Hamburger leggTil(Hamburger burger) throws InterruptedException {
		burger.setNummer(hamburgerNr.getAndIncrement());
		brett.put(burger);
		return burger;
	}
	
	public Hamburger fjern() throws InterruptedException {
		return brett.take();
	}

	@Override
	public String toString() {
		return brett.toString();
	}	
}
