package ch.berufsbildungscenter.project_Boomberman;


import java.rmi.Remote;
import java.rmi.RemoteException;

import javax.swing.JFrame;
import javax.swing.JPanel;

public interface Validator extends Remote {
	public abstract Window validate() throws RemoteException;

}
