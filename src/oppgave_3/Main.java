package oppgave_3;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {

		final int KAPASITET = 4;
		final String[] kokker = { "Anne", "Erik", "Knut" };
		final String[] servitorer = { "Mia", "Per" };

		HamburgerBrett brett = new HamburgerBrett(KAPASITET);
		skrivUtHeader(kokker, servitorer, KAPASITET);

		for (String navn : kokker) {
			new Thread(new Kokk(brett, navn)).start();
		}

		for (String navn : servitorer) {
			new Thread(new Servitor(brett, navn)).start();
		}
	}

	private static void skrivUtHeader(String[] kokker, String[] servitorer, int KAPASITET) {
		System.out.println("I denne simuleringen har vi\n\t" + kokker.length + " kokker " + Arrays.toString(kokker)
				+ "\n\t" + servitorer.length + " servitorer " + Arrays.toString(servitorer)
				+ "\n\tKapasiteten til brettet er " + KAPASITET + " hamburgere.\nVi starter ...");
	}
}
