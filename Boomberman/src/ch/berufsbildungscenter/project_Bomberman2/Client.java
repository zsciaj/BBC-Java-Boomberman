package ch.berufsbildungscenter.project_Bomberman2;



import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Client implements KeyListener, Serializable{

	private static Receiver receiver;
	private Player player;
	private JFrame window;
	private JPanel map;
	private int[] playerDirection;
	
	public static void main(String[] args) {

		try {
			Remote remote = Naming.lookup("rmi://localhost:1199/validator"); //192.168.3.195
			Receiver receiver = (Receiver) remote;
			
			Client client = new Client();
			client.setReceiver(receiver);
			client.setPlayer(receiver.sendPlayer());
			client.show();
			
			
	
		} catch (MalformedURLException me) {
			System.err.println("rmi://192.168.3.195:1499/validator is not a valid URL");
		} catch (NotBoundException nbe) {
			System.err.println("Could not find requested object on the server");
		} catch (RemoteException re) {
			System.err.println(re.getMessage());
		}
	}

	
	@Override
	public void keyReleased(KeyEvent arg0) {
		char key = arg0.getKeyChar();
		
		
		try {
			System.out.println(key);
			int[] dir = new int[2];
			switch (key) {
				case 'w':
					dir[1] = -1;
					this.getReceiver().movePlayer(this.getPlayer(),dir[0],dir[1]);
					break;
				case 's':
					dir[1] = 1;
					this.getReceiver().movePlayer(this.getPlayer(),dir[0],dir[1]);	
					break;
				case 'a':
					dir[0] = -1;
					this.getReceiver().movePlayer(this.getPlayer(),dir[0],dir[1]);
					break;	
				case 'd':
					dir[0] = 1;	
					this.getReceiver().movePlayer(this.getPlayer(),dir[0],dir[1]);
					break;
				case ' ':
					this.getReceiver().placeBomb(this.getPlayer(),this.getPlayerDirection()[0],this.getPlayerDirection()[1]);	
					break;
			}
			this.setPlayerDirection(dir);
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		
	}
	
	
	public void update() {
		Field s;
		System.out.println("Update");
		this.getMap().removeAll();
		try {
			s = this.getReceiver().sendField();
			for (ArrayList<Block> ab: s) {
				for(Block b:ab) {
					this.getMap().add(b);
				}
			}
			map.updateUI();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	public void show() {
		JFrame window = new JFrame();
		JPanel map = new JPanel();
		map.setLayout(new GridLayout(11,15));
		
		Field s;
		
		
		try {
			s = this.getReceiver().sendField();
			for (ArrayList<Block> i: s) {
				for(Block j:i) {
					map.add(j);
				}
			}
			
			this.setMap(map);
			window.add(map);
			window.setVisible(true);
			window.setSize(960, 704);
			window.setResizable(false);
			window.addKeyListener(this);
			this.setWindow(window);
			Updater u = new Updater(this);
			Thread t  = new Thread(u);
			t.start();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
	
	

	public int[] getPlayerDirection() {
		return playerDirection;
	}


	public void setPlayerDirection(int[] playerDirection) {
		this.playerDirection = playerDirection;
	}


	public JPanel getMap() {
		return map;
	}


	public void setMap(JPanel map) {
		this.map = map;
	}


	public JFrame getWindow() {
		return window;
	}


	public void setWindow(JFrame window) {
		this.window = window;
	}


	public Player getPlayer() {
		return player;
	}


	public void setPlayer(Player player) {
		this.player = player;
	}


	public static Receiver getReceiver() {
		return receiver;
	}

	public static void setReceiver(Receiver receiver) {
		Client.receiver = receiver;
	}
	
	
	
}
