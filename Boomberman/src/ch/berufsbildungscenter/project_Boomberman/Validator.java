package ch.berufsbildungscenter.project_Boomberman;


import java.rmi.Remote;
import java.rmi.RemoteException;

import javax.swing.JFrame;

public interface Validator extends Remote {
	public abstract JFrame validate() throws RemoteException;

}
