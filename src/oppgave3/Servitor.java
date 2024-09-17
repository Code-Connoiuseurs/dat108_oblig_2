package oppgave3;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public class Servitor implements Runnable {

	private HamburgerBrett hamburgerBrett;
	private String navn;

	public Servitor(HamburgerBrett hamburgerBrett, String navn) {
		this.hamburgerBrett = hamburgerBrett;
		this.navn = navn;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Random random = new Random();
				int bestillingsTid = random.nextInt(2000, 6001);
				Thread.sleep(bestillingsTid);
				Hamburger tattHamburger = hamburgerBrett.taHamburger();
				System.out.println(LocalTime.now().truncatedTo(ChronoUnit.SECONDS)+ " " + navn + " (servitør) tar av hamburger " + tattHamburger + ". " + hamburgerBrett);
			} catch (InterruptedException e) {
			}
		}
	}
}