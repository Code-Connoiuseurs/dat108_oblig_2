package oppgave_1;

public class Main {

	public static void main(String[] args) {

		Melding melding = new Melding("Hallo verden!");
		PrinterThread printerThread = new PrinterThread(melding);
		InputThread inputThread = new InputThread(melding);

		printerThread.start();
		inputThread.start();
	}
}
