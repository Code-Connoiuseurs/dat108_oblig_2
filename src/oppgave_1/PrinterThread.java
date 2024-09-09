package oppgave_1;

public class PrinterThread extends Thread {

	boolean fortsette = true;

	private Melding melding;

	public PrinterThread(Melding melding) {
		this.melding = melding;
	}

	public void stopp() {
		fortsette = false;
	}

	@Override
	public void run() {
		while (fortsette) {
			System.out.println(melding.getMelding());

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
			}

			if (melding.getMelding() == null || melding.getMelding().toLowerCase().equals("quit")) {
				stopp();
			}
		}
	}
}
