package ch.berufsbildungscenter.bomberman.main;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Receiver extends Remote {

	public abstract Field sendField() throws RemoteException;

	public abstract void movePlayer(Player p, int x, int y) throws RemoteException;

	public abstract Player sendPlayer() throws RemoteException;

	public abstract void placeBomb(Player p, int x, int y) throws RemoteException;

	public PlayerData getPlayerData(int code) throws RemoteException;

	public void setPlayername(String name, Player p) throws RemoteException;

	public Player resendPlayer(Player p) throws RemoteException;

	public void start() throws RemoteException;

	public Timer sendTimer() throws RemoteException;

	public void restart() throws RemoteException;

	public boolean isReadyToRestart() throws RemoteException;
}
