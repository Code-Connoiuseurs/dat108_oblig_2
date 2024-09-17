package oppgave_3;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public class Servitor implements Runnable {

	private HamburgerBrett brett;
	private String navn;

	public Servitor(HamburgerBrett brett, String navn) {
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
				Hamburger hamburger = brett.fjern();
				System.out.println(LocalTime.now().truncatedTo(ChronoUnit.SECONDS) + " " + this.getNavn()
						+ " (servitor) tar av hamburger " + hamburger.toString() + ". " + brett.toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public String getNavn() {
		return navn;
	}

}
