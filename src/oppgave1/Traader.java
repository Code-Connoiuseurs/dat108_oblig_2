package oppgave1;

import javax.swing.JOptionPane;

public class Traader implements Runnable {
	
	private boolean forsettelse = true;
	private String melding = "Hallo verden!";
	
	@Override
	public void run() {
	
	// infinite loop
	while(forsettelse) {	
		
		System.out.println(melding);
		
	// 3 sekund repeat 
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
			}
	}
}

// tråd til JOptionPane slik at den er åpen samtidig som teksten blir skrevet ut. 
void innputtTraad() {
	
	new Thread(() -> {
		while(forsettelse) {
			String innputt = JOptionPane.showInputDialog(null, "Skriv inn melding, quit for å avslutte", "Input Dialog", JOptionPane.INFORMATION_MESSAGE);
			
	// program stopper 
	if(innputt != null && innputt.equalsIgnoreCase("quit")) {
		System.out.println("programmet har stoppet"); 
		forsettelse = false;
		} else if (innputt != null && !innputt.trim().isEmpty()) {
			melding = innputt;
			}
		}
	System.exit(0);
	}).start();
	}
}



