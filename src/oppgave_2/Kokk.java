package oppgave_2;

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

	public void run() {
		while (true) 
			try {
				synchronized (brett) {
					Thread.sleep(random.nextInt(2000, 6000));
					Hamburger burger = new Hamburger();
					boolean lagtTil = false;
					while (!lagtTil) {
						try {
							lagtTil = brett.leggTil(burger);
							if (lagtTil) {
								System.out.println(this.getNavn() + "(kokk) har lagt til burger ◖" + burger.getNummer() + "◗ brettet: " + brett.toString());
								brett.notify();
							} else {
								System.out.println(this.getNavn() + "(kokk) kan ikke legge på burger fordi brettet er fult");
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
