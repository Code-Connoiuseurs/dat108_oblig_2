package oppgave3;

import java.util.Arrays;

public class Main {
	
	public static void skrivUtHeader(String[] kokker, String[] servitorer, int KAPASITET) {
		System.out.println("I denne simuleringen har vi");
		System.out.println("	" + kokker.length + " kokker " + Arrays.toString(kokker));
		System.out.println("	" + servitorer.length + " servitører " + Arrays.toString(servitorer));
		System.out.println("	" + "Kapasiteten til brettet er " + KAPASITET + " hamburgere." + "\nVi starter ...");
	}
	
	public static void main(String... blablabla) {
		final String[] kokker = { "Anne", "Erik", "Knut" };
		final String[] servitorer = { "Mia", "Per" };
		final int KAPASITET = 4;

		skrivUtHeader(kokker, servitorer, KAPASITET);

		HamburgerBrett brett = new HamburgerBrett(KAPASITET);
		Hamburger h1 = new Hamburger();
		Hamburger h2 = new Hamburger();
		

		for (String navn : kokker) {
			new Thread (new Kokk(brett, navn)).start();
		}
		
		for (String navn : servitorer) {
			new Thread (new Servitor(brett, navn)).start();
		}
	}
}