package ch.berufsbildungscenter.bomberman.main;

import java.lang.reflect.InvocationTargetException;

import javax.swing.SwingUtilities;

public class Updater extends Thread {

	private Client client;
	private volatile boolean stop = false;

	public Updater(Client c) {
		this.setClient(c);
	}

	public void run() {
		while (!stop) {
	
			try {
				
				SwingUtilities.invokeAndWait(new Runnable() {     //https://stackoverflow.com/questions/8224422/updating-gui-gives-a-flickering-effect
					@Override
					public void run() {
						getClient().update();
						getClient().ckeckGameOver();
						}
					});
				Thread.sleep(10);
			} catch (InterruptedException | InvocationTargetException e) {
				e.printStackTrace();
			}
			
		
			// try {
			// SwingUtilities.invokeAndWait(new Runnable() { //
			// https://stackoverflow.com/questions/8224422/updating-gui-gives-a-flickering-effect
			// \\
			//
			// @Override
			// public void run() {
			// getClient().update();
			//
			// }
			// });
			//
			// } catch (InvocationTargetException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// } catch (InterruptedException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }

		}

	}

	public Client getClient() {
		return client;
	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}

	public void setClient(Client client) {
		this.client = client;
	}
}
