package oppgave1;

public class Main {
	public static void main(String[] args) {
		
		Traader traad = new Traader();
		
		Thread t = new Thread(traad);
		t.start();
		
		traad.innputtTraad();
		
	}
}


