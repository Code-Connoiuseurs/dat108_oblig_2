package oppgave3;

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
	
	private Hamburger lagBurger() throws InterruptedException {
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
				Hamburger nyBurger = lagBurger();
				hamburgerBrett.leggTilHamburger(nyBurger);
				System.out.println(LocalTime.now().truncatedTo(ChronoUnit.SECONDS)+ " " + navn + "(kokk) legger på hamburger " + nyBurger + ". " + hamburgerBrett);		
				} catch (InterruptedException e) {
			}
		}
	}
}