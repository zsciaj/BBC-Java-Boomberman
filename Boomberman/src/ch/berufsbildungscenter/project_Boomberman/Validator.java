package ch.berufsbildungscenter.project_Boomberman;


import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Validator extends Remote {
	public abstract String validate(String id, String pw) throws RemoteException;

}
