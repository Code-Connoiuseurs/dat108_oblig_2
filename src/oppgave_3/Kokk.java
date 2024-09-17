package oppgave_3;

import java.util.Random;

public class Kokk implements Runnable {
	private String navn;
	private HamburgerBrett brett;
	private Random random = new Random();

	public Kokk(HamburgerBrett brett, String navn) {
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
				Hamburger burger = brett.leggTil(new Hamburger());
				System.out.println(this.getNavn() + "(kokk) har lagt til burger ◖" + burger.getNummer() + "◗ brettet: " + brett.toString());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
