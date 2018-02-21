package ch.berufsbildungscenter.project_Bomberman2;

public class Updater extends Thread {

	private Client client;
	private boolean running = true;
	
	public Updater(Client c) {
		this.setClient(c);
	}

	public void update() {
		this.getClient().update();
	}
	
	public void run() {
		while (this.isRunning()) {
			try {
				if (this.isRunning()) {
					this.update();
				}
				this.sleep(10);
			} catch (InterruptedException e) {
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
	

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}


}
