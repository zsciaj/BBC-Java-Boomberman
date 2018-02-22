package ch.berufsbildungscenter.project_Bomberman2;



import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ReceiverImpl extends UnicastRemoteObject implements Receiver {

	private boolean readyToRestart;
	private boolean player1setted;
	private Field field;
	private Timer timer;
	
	public void restart() throws RemoteException{
		if (!this.isPlayer1setted()) {
			this.setPlayer1setted(true);
		}else {
			this.setPlayer1setted(false);
			this.reload();
			this.setReadyToRestart(true);
			
			
		}
		
	}
  
	public void reload() {
		this.setPlayer1setted(false);
		this.setField(new Field());
		this.getField().load("map1");
		this.setTimer(null);
	}
	
	public ReceiverImpl(Field field) throws RemoteException {
		this.setField(field);
	}
	
	public void start() {
		this.setTimer(new Timer());
		Thread t = new Thread(this.getTimer());
		t.start();
	}
  
	
	public Field sendField() throws RemoteException {
		return this.getField();
	}
	
	public synchronized Player sendPlayer() throws RemoteException{
		this.setReadyToRestart(false);
		if (this.getField().getPlayer1().isUsed()) {									//Überprufe ob der Spieler1 schon vergeben ist
			this.getField().getPlayer2().setUsed(true);
			return this.getField().getPlayer2();					
		}else {
			this.getField().getPlayer1().setUsed(true);
			return this.getField().getPlayer1();		
	
		}
	}
	
	public Timer sendTimer()  throws RemoteException{
		return this.getTimer();
	}
	
	public Player resendPlayer(Player p) throws RemoteException {
		if (p.getPlayerNr() == 1) {											//Überprüfe ob der Spieler player 1 ist
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
		if (p.getPlayerNr() == 1) {												//Überprüfe ob der Spieler player 1 ist
			this.getField().getPlayer1().getPlayerData().setName(name);
		}else {
			this.getField().getPlayer2().getPlayerData().setName(name);
			
		}
		
	}
	
	
	public void movePlayer(Player p, int x, int y) throws RemoteException {
		this.getField().movePlayer(p,x,y);
	}


	
	public void placeBomb(Player p, int x, int y) throws RemoteException {
		this.getField().placeBomb(p,x,y);
	}
	




	public boolean isPlayer1setted() {
		return player1setted;
	}

	public void setPlayer1setted(boolean player1setted) {
		this.player1setted = player1setted;
	}

	public boolean isReadyToRestart() throws RemoteException{
		return readyToRestart;
	}

	public void setReadyToRestart(boolean readyToRestart) {
		this.readyToRestart = readyToRestart;
	}

	public Field getField() {
		return field;
	}

	public void setField(Field map) {
		this.field = map;
	}


	public Timer getTimer() {
		return timer;
	}


	public void setTimer(Timer timer) {
		this.timer = timer;
	}




	
	
}