package oppgave3;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class HamburgerBrett {

	private BlockingQueue<Hamburger> hamburgerBrett;
	private AtomicInteger hamburgerNr = new AtomicInteger(1);

	public HamburgerBrett(int KAPASITET) {
		hamburgerBrett = new LinkedBlockingQueue<>(KAPASITET);
	}

	// add
	public void leggTilHamburger(Hamburger nyBurger) throws InterruptedException {
		nyBurger.setHamburgerNr(hamburgerNr.getAndIncrement());
		hamburgerBrett.put(nyBurger);
	}

	// remove
	public Hamburger taHamburger() throws InterruptedException {
		return hamburgerBrett.take();
	}

	@Override
	public String toString() {
		return "Brett: " + hamburgerBrett;
	}

}
