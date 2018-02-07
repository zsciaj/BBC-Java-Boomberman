package ch.berufsbildungscenter.project_Bomberman2;



import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
	
	public static void main(String[] args) {
		try {
			Registry reg = LocateRegistry.createRegistry(1299);

			
			Field field = new Field();
			field.load("map1");
			
			
			
			Receiver aValidator = new ReceiverImpl(field);
			reg.rebind("validator", aValidator);
			
		} catch (RemoteException e) {
			System.out.println(e.getMessage());
		}  
	}
}
