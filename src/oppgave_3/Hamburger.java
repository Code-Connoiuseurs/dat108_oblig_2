package oppgave_3;

public class Hamburger {
	private int hamburgerNr;

	public int getHamburgerNr() {
		return hamburgerNr;
	}

	public void setHamburgerNr(int hamburgerNr) {
		this.hamburgerNr = hamburgerNr;
	}

	@Override
	public String toString() {
		return "◖" + this.getHamburgerNr() + "◗";
	}

}
