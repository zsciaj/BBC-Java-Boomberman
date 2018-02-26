package ch.berufsbildungscenter.bomberman.main;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
	private static Registry reg;

	public Server() {
		try {
			reg = LocateRegistry.createRegistry(1109);
		} catch (RemoteException e) {

		}
	}

	public void load() {
		try {
			Field field = new Field();
			field.load("map1");
			Receiver aValidator = new ReceiverImpl(field);
			reg.rebind("validator", aValidator);
		} catch (RemoteException e) {

		}
	}

	public static void main(String[] args) {
		Server s = new Server();
		s.load();
	}

}
