package oppgave_1;

public class Melding {
	
	private String tekst = "Hallo verden!";

	public synchronized String getTekst() {
		return tekst;
	}

	public synchronized void setTekst(String tekst) {
		this.tekst = tekst;
	}
}
