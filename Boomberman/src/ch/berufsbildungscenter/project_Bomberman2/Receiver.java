package ch.berufsbildungscenter.project_Bomberman2;


import java.rmi.Remote;
import java.rmi.RemoteException;


public interface Receiver extends Remote {
	
	public abstract Field sendField() throws RemoteException;
	
	public abstract void movePlayer(Player p,int x,int y)  throws RemoteException;
	
	public abstract Player sendPlayer() throws RemoteException;
	
	public abstract void placeBomb(Player p,int x,int y) throws RemoteException;

}
