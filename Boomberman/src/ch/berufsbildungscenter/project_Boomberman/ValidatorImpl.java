package ch.berufsbildungscenter.project_Boomberman;

import java.awt.BorderLayout;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import ch.berufsbildungscenter.project_Boomberman.*;


public class ValidatorImpl extends UnicastRemoteObject implements Validator {

  private JFrame jf;
  
  public ValidatorImpl() throws RemoteException {
  }
  
  
  
 
 
  
	public static void main(String[] args) {
		
		JFrame jf = new JFrame();
		
		Map m = new Map(jf);  
		m.show(m.load("map1"));
		
		
		Timer t = new Timer();
		Thread th = new Thread(t);
		th.start();
			
		jf.add(t,BorderLayout.NORTH);

		jf.add(m,BorderLayout.SOUTH);
		jf.setSize((int)m.getSize().getWidth(),(int)m.getSize().getHeight());
		jf.setVisible(true);
		
		ValidatorImpl val;
		
		try {
			val = new ValidatorImpl();
			val.setJf(jf);
		} catch (RemoteException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public JFrame validate() throws RemoteException {
		return this.getJf();
	}


	public JFrame getJf() {
		return jf;
	}




	public void setJf(JFrame jf) {
		this.jf = jf;
	}
	
}