package oppgave_1;

public class Printer extends Thread {
	
	private Melding melding;

	public Printer(Melding melding) {
		this.melding = melding;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				sleep(3_000);
			} catch (InterruptedException e) {
			}
			System.out.println(melding.getTekst());
		}
	}
}