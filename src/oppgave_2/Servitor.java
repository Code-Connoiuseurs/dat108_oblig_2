package oppgave_2;

import java.util.Random;

public class Servitor extends Thread {
	private String navn;
	private HamburgerBrett brett;

	private Random random = new Random();

	public Servitor(HamburgerBrett brett, String navn) {
		this.brett = brett;
		this.navn = navn;
	}

	public String getNavn() {
		return navn;
	}

	@Override
	public void run() {
		while (true) {
			try {
				synchronized (brett) {
				Thread.sleep(random.nextInt(2000, 6000));
					boolean tattBurger = false;
					while (!tattBurger) {
						try {
							Hamburger burger = brett.fjern();
							if (burger != null) {
								System.out.println(this.getNavn() + "(servitør) tar av hamburger ◖" + burger.getNummer() + "◗ brettet: " + brett.toString());
								brett.notify();
							} else {
								System.out.println(this.getNavn() + "(servitør) har ingen burgere å servere og tar seg derfor en lur");
								brett.wait();
							}
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
