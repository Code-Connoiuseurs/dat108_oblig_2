package oppgave_3;

import java.util.Random;

public class Servitor extends Thread {
	private String navn;
	private HamburgerBrett brett;
	private Random random = new Random();

	public Servitor(HamburgerBrett brett, String navn) {
		this.navn = navn;
		this.brett = brett;
	}

	public String getNavn() {
		return navn;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(random.nextInt(2000, 6000));
				Hamburger burger = brett.fjern();
				System.out.println(this.getNavn() + "(servitør) tar av hamburger " + burger.toString() + " brettet: " + brett.toString());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
