package ch.berufsbildungscenter.project_Boomberman2;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import ch.berufsbildungscenter.project_Boomberman2.Validator;


public class Player extends UnBreakableBlock implements KeyListener{
	
	public Player(String image) {
		super(image);
	}



	private int[] direction = {-1,0};
	private int lives = 100;
	
	
	
	public static void main(String[] args) {
		try {	
			Remote remote = Naming.lookup("rmi://192.168.3.195:1234/validator");   // 192.168.3.195
			Validator validator = (Validator) remote;
			UnBreakableBlock.setVal(validator);	
		} catch (MalformedURLException me) {
			System.err.println("rmi://192.168.3.195:1234/validator is not a valid URL");
		} catch (NotBoundException nbe) {
			System.err.println("Could not find requested object on the server");
		} catch (RemoteException re) {
			System.err.println(re.getMessage()); 
		}
	}
	

	
	

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		char taste = e.getKeyChar();
		int x = 0;
		int y = 0;
		ImageIcon im = null;
		switch (taste){
			case 'w':
				y = -1;
				this.getVal().setPlayerImage("player1back.png",this);
				break;
			case 'a':
				x = -1;
				this.getVal().setPlayerImage("player1left.png",this);
				break;
			case 's':
				y = 1;
				this.getVal().setPlayerImage("player1front.png",this);
				break;
			case 'd':
				x = 1;
				this.getVal().setPlayerImage("player1right.png",this);
				break;
			case ' ':
				this.getVal().placeBomb(this.getDirection(),this);
				
				break;
		}
		
		
		this.setDirection(new int[]{x,y});
		System.out.println(taste);
		this.getVal().movePlayer(this.getDirection(), this);

	}



	public int[] getDirection() {
		return direction;
	}



	public void setDirection(int[] direction) {
		this.direction = direction;
	}





}
