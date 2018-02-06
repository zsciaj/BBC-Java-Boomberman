package ch.berufsbildungscenter.project_Boomberman2;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class LoginServer {
	
	private static Validator val;
	

	public LoginServer() {
		try {
			this.setVal(new ValidatorImpl(new Map()));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		LoginServer ls = new LoginServer();	
		try {
			Registry reg = LocateRegistry.createRegistry(1234);		
			Validator v = LoginServer.getVal();
			reg.rebind("validator", v);	
		} catch (RemoteException e) {
			System.out.println(e.getMessage());
		}
	}
	

	
	
	public static Validator getVal() {
		return val;
	}

	
	public static void setVal(Validator val) {
		LoginServer.val = val;
	}	
	
	
}
