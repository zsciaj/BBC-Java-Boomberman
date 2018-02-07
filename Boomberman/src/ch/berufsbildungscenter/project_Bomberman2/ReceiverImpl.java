package ch.berufsbildungscenter.project_Bomberman2;



import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ReceiverImpl extends UnicastRemoteObject implements Receiver {

	private static Field field;
  
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
	

	public void movePlayer(Player p, int x, int y)  throws RemoteException{
		this.getField().movePlayer(p,x,y);
		
	}
	
	
	
	
	
	
	

	public static Field getField() {
		return field;
	}

	public static void setField(Field map) {
		ReceiverImpl.field = map;
	}

	
	
}