package oppgave2;

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
				synchronized (hamburgerBrett) {
					Thread.sleep(bestillingsTid);
					Hamburger tattBurger = hamburgerBrett.taHamburger();
					if (tattBurger != null) {
						System.out.println(LocalTime.now().truncatedTo(ChronoUnit.SECONDS)+ " " + navn + " (servitør) tar av hamburger " + tattBurger + ". " + hamburgerBrett);
						hamburgerBrett.notify();
					} else {
						System.out.println(LocalTime.now().truncatedTo(ChronoUnit.SECONDS)+ " " + navn + " (servitør) ønsker å ta hamburger, men brett tomt. Venter!"); 
						hamburgerBrett.wait();						
					}
				}
			} catch (InterruptedException e) {
			}
		}
	}
}