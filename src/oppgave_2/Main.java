package oppgave_2;

import java.util.Arrays;

public class Main {
	static final String[] kokker = { "Anne", "Erik", "Knut" };
	static final String[] servitorer = { "Mia", "Per" };
	static final int KAPASITET = 4;

	public static void main(String[] args) {
		skrivUtHeader(kokker, servitorer, KAPASITET);
		HamburgerBrett brett = new HamburgerBrett(KAPASITET);

		for (String navn : kokker) {
			new Thread(new Kokk(brett, navn)).start();
		}
		for (String navn : servitorer) {
			new Servitor(brett, navn).start();
		}
	}

	private static void skrivUtHeader() {
		System.out.println(
			"I denne simuleringen har vi\n"
			+ kokker.length + " kokker " + Arrays.toString(kokker) + "\n"
			+ servitorer.length + " servitører " + Arrays.toString(servitorer) + "\n"
			+ "Kapasiteten er " + KAPASITET + "\n"
			+ "La kaoset begynne!\n"
		);
	}
}
