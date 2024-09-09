package oppgave3;

import java.util.Random;

public class Kokk implements Runnable {
	
	private Random random = new Random();
	private Brett brett;
	private String navn;
	
	public Kokk(Brett brett, String navn) {
		this.brett = brett;
		this.navn = navn;
		
	}

	@Override
	public void run() {
		try {
			while(true) {
				brett.leggTilHamburger(navn);
				
				int forbredelseTid = 2000 + random.nextInt(4000);
				Thread.sleep(forbredelseTid);
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}
