package oppgave_3;

public class Hamburger {
	private int nummer;

	public void setNummer(int nummer) {
		this.nummer = nummer;
	}

	public int getNummer() {
		return nummer;
	}

	@Override
	public String toString() {
		return "◖" + nummer + "◗";
	}
}
