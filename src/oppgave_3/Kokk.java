package oppgave_3;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public class Kokk implements Runnable {
	private HamburgerBrett brett;
	private String navn;

	public Kokk(HamburgerBrett brett, String navn) {
		this.brett = brett;
		this.navn = navn;
	}

	@Override
	public void run() {
		Random random = new Random();

		while (true) {
			int ventetid = random.nextInt(2000, 6000);
			try {
				Thread.sleep(ventetid);
				Hamburger hamburger = brett.leggTil(new Hamburger());
				System.out.println(LocalTime.now().truncatedTo(ChronoUnit.SECONDS) + " " + this.getNavn()
						+ " (kokk) legger på hamburger " + hamburger.toString() + ". " + brett.toString());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public String getNavn() {
		return navn;
	}

}
