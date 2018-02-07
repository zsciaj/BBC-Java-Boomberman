package ch.berufsbildungscenter.project_Bomberman2;



import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Client implements KeyListener{

	private static Receiver receiver;
	private Player player;
	private JFrame window;
	private JPanel map;
	
	
	public static void main(String[] args) {

		try {
			Remote remote = Naming.lookup("rmi://localhost:1099/validator");
			Receiver receiver = (Receiver) remote;
			
			Client client = new Client();
			client.setReceiver(receiver);
			client.setPlayer(receiver.sendPlayer());
			client.show();

			

			
		} catch (MalformedURLException me) {
			System.err.println("rmi://localhost:1099/validator is not a valid URL");
		} catch (NotBoundException nbe) {
			System.err.println("Could not find requested object on the server");
		} catch (RemoteException re) {
			System.err.println(re.getMessage());
		}
	}

	
	@Override
	public void keyPressed(KeyEvent arg0) {
		char key = arg0.getKeyChar();
		
		
		try {
			System.out.println(key);
			switch (key) {
				case 'w':
					this.getReceiver().movePlayer(this.getPlayer(),0,1);
					break;
				case 's':
					this.getReceiver().movePlayer(this.getPlayer(),0,-1);
					break;
				case 'a':
					this.getReceiver().movePlayer(this.getPlayer(),-1,0);
					break;
				case 'd':
					this.getReceiver().movePlayer(this.getPlayer(),1,0);
					break;
				
			}
			this.update();
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		
	}
	
	
	public void update() {
		Field s;
		this.getMap().removeAll();
		System.out.println("Update");
		try {
			s = this.getReceiver().sendField();
			for (ArrayList<Block> i: s) {
				for(Block j:i) {
					this.getMap().add(j);
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
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
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
