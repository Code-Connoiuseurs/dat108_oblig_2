package oppgave3;

public class Hamburger {

	private int hamburgerNr;
	
	public Hamburger() {
	}
	
	public int getHamburgerNr() {
		return hamburgerNr;
	}
	
	public void setHamburgerNr(int h) {
		hamburgerNr = h;
	}
	
	@Override
	public String toString() {
		return "◖" + hamburgerNr + "◗";
	}
	
}
