package oppgave_2;

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

	private static void skrivUtHeader(String[] kokker, String[] servitorer, int kapasitet) {
		System.out.println("La kaoset begynne");
	}

}
