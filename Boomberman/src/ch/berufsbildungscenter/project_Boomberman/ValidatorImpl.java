package ch.berufsbildungscenter.project_Boomberman;

import java.awt.BorderLayout;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import ch.berufsbildungscenter.project_Boomberman.*;


public class ValidatorImpl extends UnicastRemoteObject implements Validator {

	Window w = new Window();
  
  public ValidatorImpl() throws RemoteException {

  }
 

	@Override
	public Window validate() throws RemoteException {
		
		
		return this.getW();
	}


	public Window getW() {
		return w;
	}


	public void setW(Window w) {
		this.w = w;
	}

	
}