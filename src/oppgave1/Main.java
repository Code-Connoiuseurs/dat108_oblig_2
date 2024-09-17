package oppgave1;

public class Main {

	public static void main(String[] args) {

		Melding melding = new Melding("Hallo verden!");

		Thread skrivInn = new SkrivInn(melding);
		Thread skrivUt = new SkrivUt(melding);

		skrivInn.start();
		skrivUt.start();
	}
}