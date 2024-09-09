package oppgave_1;

import javax.swing.JOptionPane;

public class Henter extends Thread {
	
	private Melding melding;

	public Henter(Melding melding) {
		this.melding = melding;
	}
	
	@Override
	public void run() {
		while(true) {	
			String nyTekst = melding.getTekst();
			try {
				nyTekst = JOptionPane.showInputDialog("Skriv inn tekst:");
			} catch (Exception e) {}
			if (nyTekst == null || nyTekst.equals("quit")) {
				System.out.println("Hade :)");
				System.exit(0);
			}
			melding.setTekst(nyTekst);
		}
	}
}
