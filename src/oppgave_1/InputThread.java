package oppgave_1;

import javax.swing.JOptionPane;

public class InputThread extends Thread {

	private boolean fortsette = true;

	private Melding melding;

	public InputThread(Melding melding) {
		this.melding = melding;
	}

	public void stopp() {
		fortsette = false;
	}

	@Override
	public void run() {
		while (fortsette) {
			melding.setMelding(JOptionPane.showInputDialog("Skriv inn din melding, quit for å slutte:"));

			if (melding.getMelding() == null || melding.getMelding().toLowerCase().equals("quit")) {
				stopp();
			}
		}
	}
}
