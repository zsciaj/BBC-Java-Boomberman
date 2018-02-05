package ch.berufsbildungscenter.project_Boomberman;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class ValidatorImpl extends UnicastRemoteObject implements Validator {
  private Map<String, String> memberMap = null;
  
  public ValidatorImpl() throws RemoteException {
    memberMap = new HashMap<String, String>();
    memberMap.put("Marco", "Pa2014riS");
  }
  
  public String validate(String id, String pw) throws RemoteException {
    if(memberMap.containsKey(id) && memberMap.get(id).equals(pw)) {
      return "Welcome " + id;
    } else {
      return "Sorry, invalid login information!";
    }
  }
}
