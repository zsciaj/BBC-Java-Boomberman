package ch.berufsbildungscenter.bomberman.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Client implements KeyListener, Serializable {

	private static final long serialVersionUID = -7575456849669230547L;

	private Receiver receiver;
	private Player player;
	private JFrame window;
	private JPanel map;
	private int[] playerDirection;
	private JPanel infoBar;
	private Thread thread;
	private Timer timer;
	private Updater updater;

	public void reload() {

		try {

			String name = this.getPlayer().getPlayerData().getName(); 					// Alten Namen zwischen speichern

			Remote remote = Naming.lookup("rmi://192.168.3.172:1109/validator");
			Receiver receiver = (Receiver) remote;

			Client client = new Client();
			client.setReceiver(receiver);
			client.setPlayer(client.getReceiver().sendPlayer());
			client.getReceiver().setPlayername(name, client.getPlayer());
			this.getWindow().dispose();
			while (client.getReceiver().getPlayerData(client.getPlayer().getPlayerNr() * -1 + 3).getName() == null) {
				
			}
			
			client.getReceiver().start();
			client.show();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}

	}

	public static void load() {
		try {
			Remote remote = Naming.lookup("rmi://192.168.3.172:1109/validator");
			Receiver receiver = (Receiver) remote;
			Client client = new Client();
			client.setReceiver(receiver);
			InputName inputName = new InputName();

			client.setPlayer(client.getReceiver().sendPlayer());

			while (inputName.getPlayerName() == null || client.getReceiver()
					.getPlayerData(client.getPlayer().getPlayerNr() * -1 + 3).getName() == null) {
				client.getReceiver().setPlayername(inputName.getPlayerName(), client.getPlayer());
			}

			client.getReceiver().setPlayername(inputName.getPlayerName(), client.getPlayer());
			inputName.dispose();
			client.getReceiver().start();
			client.show();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		load();
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
				this.getReceiver().movePlayer(this.getPlayer(), dir[0], dir[1]);
				break;
			case 's':
				dir[1] = 1;
				this.getPlayer().setIcon("player" + this.getPlayer().getPlayerNr() + "front.png");
				this.getReceiver().movePlayer(this.getPlayer(), dir[0], dir[1]);
				break;
			case 'a':
				dir[0] = -1;
				this.getPlayer().setIcon("player" + this.getPlayer().getPlayerNr() + "left.png");
				this.getReceiver().movePlayer(this.getPlayer(), dir[0], dir[1]);
				break;
			case 'd':
				dir[0] = 1;
				this.getPlayer().setIcon("player" + this.getPlayer().getPlayerNr() + "right.png");
				this.getReceiver().movePlayer(this.getPlayer(), dir[0], dir[1]);
				break;
			case ' ':
				this.getReceiver().placeBomb(this.getPlayer(), this.getPlayerDirection()[0],
						this.getPlayerDirection()[1]);
				break;
			}
			this.setPlayerDirection(dir);

		} catch (RemoteException e) {
			// e.printStackTrace();
		}

	}

	private void showOver(String image) {
		JButton b = new JButton();

		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					b.setEnabled(false);
					getReceiver().restart();
					reload();
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}

			}
		});

		this.getMap().removeAll();
		this.getMap().setLayout(new GridLayout(1, 1));
		b.setIcon(Block.loadIcon(image));
		this.getMap().add(b);
		this.getMap().revalidate();
	}

	private void chekLessLives() {

		if (this.getPlayerLives(1) == this.getPlayerLives(2)) {
			this.showOver("playersdraw.png");
		} else if (this.getPlayerLives(1) > this.getPlayerLives(2)) {
			this.showOver("player2over.png");
		} else {
			this.showOver("player1over.png");
		}
	}

	void ckeckGameOver() {

		if (this.getTimer().getText().equals("0:00")) {
			this.getUpdater().setStop(true);
			this.chekLessLives();
		} else if (this.getPlayerLives(1) <= 0) {
			this.getUpdater().setStop(true);
			this.showOver("player1over.png");
		} else if (this.getPlayerLives(2) <= 0) {
			this.getUpdater().setStop(true);
			this.showOver("player2over.png");
		}
	}

	void update() {
		Field s;
		try {
			this.setPlayer(this.getReceiver().resendPlayer(this.getPlayer()));
			this.getInfoBar().removeAll();
			this.getInfoBar().add(this.getReceiver().getPlayerData(1));
			this.setTimer(this.getReceiver().sendTimer());
			this.getInfoBar().add(this.getTimer());
			this.getInfoBar().add(this.getReceiver().getPlayerData(2));

			s = this.getReceiver().sendField();
			for (ArrayList<Block> ab : s) {
				for (Block b : ab) {
					this.getMap().remove(0);
					this.getMap().add(b);
				}
			}
			this.getMap().revalidate();
		} catch (RemoteException e) {
			// e.printStackTrace();
		}
	}

	public void show() {
		JFrame window = new JFrame();
		JPanel map = new JPanel();
		JPanel infoBar = new JPanel();
		map.setLayout(new GridLayout(11, 15));
		map.setBackground(Color.decode("#F0BB47"));
		infoBar.setLayout(new GridLayout(1, 3));
		infoBar.setBackground(Color.decode("#F0BB47"));

		Field s;
		try {
			s = this.getReceiver().sendField();
			infoBar.add(this.getReceiver().getPlayerData(this.getPlayer().getPlayerNr()));
			this.setTimer(this.getReceiver().sendTimer());
			infoBar.add(this.getTimer());
			infoBar.add(this.getReceiver().getPlayerData(this.getPlayer().getPlayerNr() * -1 + 3));

			for (ArrayList<Block> i : s) {
				for (Block j : i) {
					map.add(j);
				}
			}

			window.add(map, BorderLayout.SOUTH);
			window.setVisible(true);
			window.setSize(920, 806);
			window.setResizable(false);
			window.addKeyListener(this);

			window.add(infoBar, BorderLayout.CENTER);

			this.setInfoBar(infoBar);
			this.setWindow(window);
			this.setMap(map);

			Updater u = new Updater(this);
			u.start();
			this.setUpdater(u);
		} catch (RemoteException e1) {
			// e.printStackTrace();
		}

	}

	@Override
	public void keyPressed(KeyEvent arg0) {

	}

	@Override
	public void keyTyped(KeyEvent arg0) {

	}

	public int getPlayerLives(int player) {
		try {
			return this.getReceiver().getPlayerData(player).getLives();
		} catch (RemoteException e) {
			e.printStackTrace();
			return 1;
		}

	}

	public Updater getUpdater() {
		return updater;
	}

	public void setUpdater(Updater updater) {
		this.updater = updater;
	}

	public Thread getThread() {
		return thread;
	}

	public void setThread(Thread thread) {
		this.thread = thread;
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
		return this.receiver;
	}

	public void setReceiver(Receiver r) {
		this.receiver = r;
	}

	public JPanel getInfoBar() {
		return infoBar;
	}

	public void setInfoBar(JPanel infoBar) {
		this.infoBar = infoBar;
	}

	public Timer getTimer() {
		return timer;
	}

	public void setTimer(Timer timer) {
		this.timer = timer;
	}

}
