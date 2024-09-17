package oppgave_1;

public class Main {

	public static void main(String[] args) {
		
		Melding melding = new Melding();
		
		Thread sender = new Printer(melding);
		Thread mottaker = new Henter(melding);
		
		sender.start();
		mottaker.start();
	}

}
