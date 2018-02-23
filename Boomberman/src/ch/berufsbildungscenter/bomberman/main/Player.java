package ch.berufsbildungscenter.bomberman.main;

import javax.swing.ImageIcon;

public class Player extends Block {

	private static final long serialVersionUID = 716109455058925087L;
	
	private boolean used;
	private int playerNr;
	private PlayerData playerData;

	public Player(String image, boolean breakable, boolean walkable, int nr) {
		super(image, breakable, walkable);
		this.setPlayerNr(nr);
		this.setPlayerData(new PlayerData((ImageIcon) loadIcon(image), nr));
	}

	public boolean isUsed() {
		return used;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}

	public int getPlayerNr() {
		return playerNr;
	}

	public void setPlayerNr(int playerNr) {
		this.playerNr = playerNr;
	}

	public PlayerData getPlayerData() {
		return playerData;
	}

	public void setPlayerData(PlayerData playerData) {
		this.playerData = playerData;
	}

}