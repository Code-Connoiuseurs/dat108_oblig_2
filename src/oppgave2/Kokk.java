package oppgave2;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public class Kokk implements Runnable {

	private HamburgerBrett hamburgerBrett;
	private String navn;

	public Kokk(HamburgerBrett hamburgerBrett, String navn) {
		this.hamburgerBrett = hamburgerBrett;
		this.navn = navn;
	}
	
	private synchronized Hamburger lagBurger() throws InterruptedException {
		Random random = new Random();
		int lageTid = random.nextInt(2000, 6001);
		Thread.sleep(lageTid);
		Hamburger nyBurger = new Hamburger();
		return nyBurger;
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				synchronized(hamburgerBrett) {
					Hamburger nyBurger = lagBurger();
					if (hamburgerBrett.leggTilHamburger(nyBurger)) {
						System.out.println(LocalTime.now().truncatedTo(ChronoUnit.SECONDS)+ " " + navn + "(kokk) legger på hamburger " + nyBurger + ". " + hamburgerBrett);		
						hamburgerBrett.notify();
					} else {
						System.out.println(LocalTime.now().truncatedTo(ChronoUnit.SECONDS)+ " " + navn + "(kokk) klar med hamburger, men brett er fullt. Venter!");
						hamburgerBrett.wait();
					};					
				}
			} catch (InterruptedException e) {
			}
		}
	}
}