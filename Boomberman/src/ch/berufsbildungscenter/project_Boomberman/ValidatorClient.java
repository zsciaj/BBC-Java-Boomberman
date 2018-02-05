package ch.berufsbildungscenter.project_Boomberman;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ValidatorClient {

	public static void main(String[] args) {

		try {
			
			
			
			Remote remote = Naming.lookup("rmi://192.168.3.195:1234/validator");
			Validator validator = (Validator) remote;

			JFrame jp = validator.validate();
			jp.setVisible(true);
			
			
		} catch (MalformedURLException me) {
			System.err.println("rmi://192.168.3.195:1234/validator is not a valid URL");
		} catch (NotBoundException nbe) {
			System.err.println("Could not find requested object on the server");
		} catch (RemoteException re) {
			System.err.println(re.getMessage());
		}
	}
}
