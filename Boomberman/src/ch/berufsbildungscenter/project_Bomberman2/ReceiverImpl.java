package ch.berufsbildungscenter.project_Bomberman2;



import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ReceiverImpl extends UnicastRemoteObject implements Receiver {

//	private Client client1;
//	private Client client2;
	private Field field;
	private Timer timer = new Timer();

  
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
	
	public Player resendPlayer(Player p) throws RemoteException {
		if (p.getPlayerNr() == 1) {
			return this.getField().getPlayer1();
		}else {
			return this.getField().getPlayer2();
		}
	}
	
	
	public PlayerData getPlayerData(int code) throws RemoteException {
		if (code == 1) {
			return this.getField().getPlayer1().getPlayerData();
		}else {
			return this.getField().getPlayer2().getPlayerData();
		}
		
	}
	
	public void setPlayername(String name,Player p) throws RemoteException{
		if (p.getPlayerNr() == 1) {
			this.getField().getPlayer1().getPlayerData().setName(name);
		}else {
			this.getField().getPlayer2().getPlayerData().setName(name);
		}
		
	}
	

	public int getPlayerLives(Player p) throws RemoteException{
		if (p.getPlayerNr() == 1) {
			return this.getField().getPlayer1().getPlayerData().getLives();
		}else {
			return this.getField().getPlayer2().getPlayerData().getLives();
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