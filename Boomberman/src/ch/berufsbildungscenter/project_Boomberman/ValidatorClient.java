package ch.berufsbildungscenter.project_Boomberman;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public class ValidatorClient {

	public static void main(String[] args) {

		try {
			Remote remote = Naming.lookup("rmi://localhost:1234/validator");
			Validator validator = (Validator) remote;
			String id = "Nico";
			String pw = "Pa2014riS";
			String s = validator.validate(id, pw);
			System.out.println(s);
		} catch (MalformedURLException me) {
			System.err.println("rmi://localhost:1099/validator is not a valid URL");
		} catch (NotBoundException nbe) {
			System.err.println("Could not find requested object on the server");
		} catch (RemoteException re) {
			System.err.println(re.getMessage());
		}
	}
}
