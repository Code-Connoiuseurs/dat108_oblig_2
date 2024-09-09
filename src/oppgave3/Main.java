package oppgave3;

public class Main {
	public static void main(String[] args) {
		
		Brett brett = new Brett(4);
		String[] kokker = {"Pål", "Per"};
		String[] servitorer = {"Nia"};
		
		for(String navn : kokker) {
			new Thread(new Kokk(brett, navn)).start();
		}
		
		for(String navn : servitorer) {
			new Thread(new Servitor(brett, navn)).start();
		}
	}
}
