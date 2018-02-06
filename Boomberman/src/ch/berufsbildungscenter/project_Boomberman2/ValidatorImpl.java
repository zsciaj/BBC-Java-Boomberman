package ch.berufsbildungscenter.project_Boomberman2;

import java.awt.BorderLayout;
import java.awt.Component;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;



public class ValidatorImpl extends UnicastRemoteObject implements Validator {

	private Map map;
	
	
	
	protected ValidatorImpl(Map map) throws RemoteException {
		this.setMap(map);
	}

	@Override
	public void setPlayerImage(String url, Player p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void placeBomb(int[] dir,Player p) {
		
		
	}



	@Override
	public void movePlayer(int[] dir,Player p) {
		this.getMap().move(dir,p);
		
	}
	
	

	@Override
	public void remove(Component c) {
	this.getMap().remove(c);	
	}
	
	
	
	public Map getMap() {
		return map;
	}

	
	
	public void setMap(Map map) {
		this.map = map;
	}



	
}