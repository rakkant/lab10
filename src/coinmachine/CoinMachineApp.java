package coinmachine;

import java.awt.EventQueue;

public class CoinMachineApp {
	public static void main (String [] args){
		final int capacity = 10;  // how many coins the machine can hold
		CoinMachine machine = new CoinMachine( capacity );
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CoinMachineObserver frame = new CoinMachineObserver(machine);
					machine.addObserver(frame);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
