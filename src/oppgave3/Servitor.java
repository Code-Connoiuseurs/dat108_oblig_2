package oppgave3;

import java.util.Random;

public class Servitor implements Runnable {
 
	private Random random = new Random();
	private Brett brett;
	private String navn;
	
	public Servitor(Brett brett, String navn) {
		this.brett = brett;
		this.navn = navn;
	}
	
	@Override
	public void run() {
		try {
			while(true) {
				brett.taHambruger(navn);
				
				int servitorTid = 2000 + random.nextInt(4000);
				Thread.sleep(servitorTid);
				}
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
		}
	}
}
