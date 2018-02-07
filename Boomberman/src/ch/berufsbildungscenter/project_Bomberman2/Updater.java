package ch.berufsbildungscenter.project_Bomberman2;

public class Updater implements Runnable{

	Client client;
	
	
	public Updater(Client c) {
		this.setClient(c);
	}
	
	public void run() {
		while(true) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.getClient().update();
		}
		
	}
	
	
	

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	
	
}
