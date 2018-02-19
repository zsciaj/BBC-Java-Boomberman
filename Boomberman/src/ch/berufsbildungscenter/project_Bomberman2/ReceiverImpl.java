package ch.berufsbildungscenter.project_Bomberman2;



import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ReceiverImpl extends UnicastRemoteObject implements Receiver {

//	private Client client1;
//	private Client client2;
	private Field field;

  
	public ReceiverImpl(Field field) throws RemoteException {
		this.setField(field);
	}
  
	
	public Field sendField() throws RemoteException {
		return this.getField();
	}
	
	public synchronized Player sendPlayer() throws RemoteException{
		if (this.getField().getPlayer1().isUsed()) {
			this.getField().getPlayer2().setUsed(true);
			return this.getField().getPlayer2();
		}else {
			this.getField().getPlayer1().setUsed(true);
			return this.getField().getPlayer1();
			
		}
	}
	

	public int getPlayerLives(Player p) throws RemoteException{
		if (p.getPlayerNr() == this.getField().getPlayer1().getPlayerNr()) {
			return this.getField().getPlayer1().getLives();
		}else {
			return this.getField().getPlayer1().getLives();
		}
	}

	
	
	public void movePlayer(Player p, int x, int y) throws RemoteException {
		this.getField().movePlayer(p,x,y);
	}


	
	public void placeBomb(Player p, int x, int y) throws RemoteException {
		this.getField().placeBomb(p,x,y);
	}
	

	public Field getField() {
		return field;
	}

	public void setField(Field map) {
		this.field = map;
	}


	
	
}