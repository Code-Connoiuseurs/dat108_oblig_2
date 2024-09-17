package oppgave1;

public class SkrivUt extends Thread {

	private Melding melding;
	
	public SkrivUt(Melding melding) {
		this.melding = melding;
	}
	
	public void run() {
		while (melding.getTekst() != null && !melding.getTekst().toLowerCase().equals("quit")) {
			String input = melding.getTekst();
			System.out.println(input);
			try {
				sleep(3000);
			} catch (InterruptedException e){
				
			}
		}
	}
}
