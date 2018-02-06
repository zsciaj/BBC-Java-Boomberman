package ch.berufsbildungscenter.project_Boomberman2;


import java.awt.Component;
import java.awt.event.KeyListener;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public interface Validator extends Remote {
	
	public abstract void setPlayerImage(String url,Player p);
	
	public abstract void placeBomb(int[] dir,Player p);
	
	public abstract int getMapWidth();
	
	public abstract int getMapHeight();
	
	public abstract void movePlayer(int[] dir, Player p);
	
	public abstract void remove(Component c);
	
	
	
	
}
