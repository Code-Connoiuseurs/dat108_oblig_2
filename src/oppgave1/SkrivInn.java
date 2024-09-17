package oppgave1;

import javax.swing.JOptionPane;

public class SkrivInn extends Thread {

	private Melding melding;

	public SkrivInn(Melding melding) {
		this.melding = melding;
	}

	@Override
	public void run() {
		while (melding.getTekst() != null && !melding.getTekst().toLowerCase().equals("quit"))  {
			String input = JOptionPane.showInputDialog("Skriv inn tekst: ");
			melding.setTekst(input);
		}
		System.exit(0);
	}

}