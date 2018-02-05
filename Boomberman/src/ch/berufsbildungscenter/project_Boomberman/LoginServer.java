package ch.berufsbildungscenter.project_Boomberman;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class LoginServer {
	public static void main(String[] args) {
		try {
			// start RMI registry on default port 1099
			Registry reg = LocateRegistry.createRegistry(1234);

			// register remote object in rmi registry
			Validator aValidator = new ValidatorImpl();
			reg.rebind("validator", aValidator);
		} catch (RemoteException e) {
			System.out.println(e.getMessage());
		}
	}
}
