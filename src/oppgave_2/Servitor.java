package oppgave_2;

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

			synchronized (brett) {
				try {
					Thread.sleep(ventetid);
					Hamburger fjernet = brett.fjern();
					if (fjernet == null) {
						System.out.println(LocalTime.now().truncatedTo(ChronoUnit.SECONDS) + " " + this.getNavn()
								+ " (Servitor) ønsker å ta hamburger, men brett tomt. Venter!");
						brett.wait();

					} else {
						System.out.println(LocalTime.now().truncatedTo(ChronoUnit.SECONDS) + " " + this.getNavn()
								+ " (Servitor) tar av hamburger " + fjernet + ". " + brett);
						brett.notify();

					}
				} catch (InterruptedException e) {
					e.printStackTrace();
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
