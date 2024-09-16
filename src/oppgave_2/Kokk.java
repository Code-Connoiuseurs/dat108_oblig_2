package oppgave_2;

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
			synchronized (brett) {

				try {
					Thread.sleep(ventetid);

					if (!brett.erFull()) {
						Hamburger hamburger = new Hamburger();
						brett.leggTil(hamburger);
						System.out.println(LocalTime.now().truncatedTo(ChronoUnit.SECONDS) + " " + this.getNavn()
								+ " (kokk) legger på hamburger " + hamburger.toString() + ". " + brett.toString());
						brett.notify();
					} else {
						System.out.println(LocalTime.now().truncatedTo(ChronoUnit.SECONDS) + " " + this.getNavn()
								+ " (kokk) klar med hamburger, men brett fullt. Venter!");
						brett.wait();
					}
				} catch (InterruptedException e) {
				}
			}
		}
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}
}
