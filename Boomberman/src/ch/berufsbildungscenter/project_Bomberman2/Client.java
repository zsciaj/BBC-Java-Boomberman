package ch.berufsbildungscenter.project_Bomberman2;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.UnmarshalException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;


public class Client implements KeyListener, Serializable{

	
	private Receiver receiver;
	private Player  player;
	private JFrame window;
	private JPanel map;
	private int[] playerDirection;
	private JPanel infoBar;
	
	
	
	public Client(Receiver r) {
		this.setReceiver(r);
	}
	
	public static void main(String[] args) {

		try {
			Remote remote = Naming.lookup("rmi://localhost:1199/validator"); //192.168.3.172     localhost
			Receiver receiver = (Receiver) remote;
			Client client = new Client(receiver);
			InputName inputName = new InputName();
			
			client.setPlayer(client.getReceiver().sendPlayer());
			
			
			while (inputName.getPlayerName() == null || client.getReceiver().getPlayerData(client.getPlayer().getPlayerNr() *-1 +3).getName() == null) {
				String s = new String();
				client.getReceiver().setPlayername(inputName.getPlayerName(), client.getPlayer());
			}
			client.getReceiver().setPlayername(inputName.getPlayerName(), client.getPlayer());
			inputName.dispose();
			
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
			int[] dir = new int[2];
			switch (key) {
				case 'w':
					dir[1] = -1;
					this.getPlayer().setIcon("player" + this.getPlayer().getPlayerNr() + "back.png");
					this.getReceiver().movePlayer(this.getPlayer(),dir[0],dir[1]);
					break;
				case 's':
					dir[1] = 1;
					this.getPlayer().setIcon("player" + this.getPlayer().getPlayerNr() + "front.png");
					this.getReceiver().movePlayer(this.getPlayer(),dir[0],dir[1]);	
					break;
				case 'a':
					dir[0] = -1;
					this.getPlayer().setIcon("player" + this.getPlayer().getPlayerNr() + "left.png");
					this.getReceiver().movePlayer(this.getPlayer(),dir[0],dir[1]);
					break;	
				case 'd':
					dir[0] = 1;	
					this.getPlayer().setIcon("player" + this.getPlayer().getPlayerNr() + "right.png");
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
	
	public void showOver(String image) {
		JLabel j = new JLabel();
		this.getWindow().removeAll();
		this.getWindow().setLayout(new GridLayout(1,1));
		j.setIcon(Block.loadIcon(image));
		this.getWindow().add(j);
		this.getWindow().revalidate();
	}
	
	public void ckeckGameOver() {
	
		try {
			if (this.getReceiver().getPlayerData(2).getLives() <= 0) {
				this.showOver("player1over.png");	
			}else if (this.getReceiver().getPlayerData(1).getLives() <= 0){
				this.showOver("player2over.png");	
			}
				
		} catch (RemoteException e) {
			System.err.println("Feheler");
		}
	}

	
	public void update() {
		Field s;
		try {
			
			
			
			this.setPlayer(this.getReceiver().resendPlayer(this.getPlayer()));
			
			
//			this.getInfoBar().remove(0);
//			this.getInfoBar().remove(1);
//			this.getInfoBar().remove(2);
			this.getInfoBar().removeAll();
			
			this.getInfoBar().add(this.getReceiver().getPlayerData(1));					//Marcooooooooooooooooooooooooooooo helprprprprpprprprprprprprprprprp!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			this.getInfoBar().add(this.getReceiver().sendTimer());
			this.getInfoBar().add(this.getReceiver().getPlayerData(2));
			
			this.ckeckGameOver();
			
			
			
			s = this.getReceiver().sendField();
			for (ArrayList<Block> ab: s) {
				for(Block b:ab) {
					
					this.getMap().remove(0);
					this.getMap().add(b);
				}
			}
			this.getMap().revalidate();
		} catch (RemoteException e) {
			System.err.println("Feheler");
		}
	}
	
	
	
	
	
	public void show() {
		JFrame window = new JFrame();
		JPanel map = new JPanel();
		JPanel infoBar = new JPanel();
		map.setLayout(new GridLayout(11,15));
		map.setBackground(Color.decode("#F0BB47"));
		infoBar.setLayout(new GridLayout(1,3));
		infoBar.setBackground(Color.decode("#F0BB47"));
		
		int c;
		Field s;
		try {
			s = this.getReceiver().sendField();
		
			infoBar.add(this.getReceiver().getPlayerData(this.getPlayer().getPlayerNr()));
			infoBar.add(this.getReceiver().sendTimer());
			infoBar.add(this.getReceiver().getPlayerData(this.getPlayer().getPlayerNr()*-1+3));
			
			for (ArrayList<Block> i: s) {
				for(Block j:i) {
					map.add(j);
				}
			}
			
			window.add(map,BorderLayout.SOUTH);
			window.setVisible(true);
			window.setSize(930, 806);
			window.setResizable(false);
			window.addKeyListener(this);
			
			window.add(infoBar,BorderLayout.CENTER);
			
			
			
			this.setInfoBar(infoBar);
			this.setWindow(window);
			this.setMap(map);
		
			
			Updater u = new Updater(this);
			Thread t2  = new Thread(u);
			t2.start();
		} catch (RemoteException e1) {
			System.err.println("Feheler");
		}
		
		

	}
	
	
	
	
	
	
	
	
	

	@Override
	public void keyPressed(KeyEvent arg0) {
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
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

	public void setPlayer(Player p) {
		this.player = p;
	}

	public Receiver getReceiver() {
		return receiver;
	}

	public void setReceiver(Receiver receiver) {
		this.receiver = receiver;
	}

	public JPanel getInfoBar() {
		return infoBar;
	}

	public void setInfoBar(JPanel infoBar) {
		this.infoBar = infoBar;
	}

	
	
	
	
}
