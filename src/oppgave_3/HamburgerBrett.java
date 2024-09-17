package oppgave_3;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class HamburgerBrett {
	private BlockingQueue<Hamburger> brett;
	private AtomicInteger atomicHamburgerNr = new AtomicInteger(1);

	public HamburgerBrett(int kapasitet) {
		this.brett = new LinkedBlockingQueue<>(kapasitet);
	}

	public Hamburger leggTil(Hamburger hamburger) throws InterruptedException {
		hamburger.setHamburgerNr(atomicHamburgerNr.getAndIncrement());
		brett.put(hamburger);
		return hamburger;
	}

	public Hamburger fjern() throws InterruptedException {
		return brett.take();
	}

	@Override
	public String toString() {
		return "Brett: " + brett;
	}

}
