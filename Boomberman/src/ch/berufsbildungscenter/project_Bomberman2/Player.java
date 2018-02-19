package ch.berufsbildungscenter.project_Bomberman2;

import javax.swing.ImageIcon;

public class Player extends Block{

	private boolean used;
	private int playerNr;
	private PlayerData playerData = new PlayerData();
	
	public Player(String image, boolean breakable, boolean walkable) {
		super(image, breakable, walkable);
		this.getPlayerData().setImage((ImageIcon) loadIcon(image));
		
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