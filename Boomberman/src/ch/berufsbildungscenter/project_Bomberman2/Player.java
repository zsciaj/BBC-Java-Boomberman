package ch.berufsbildungscenter.project_Bomberman2;

public class Player extends Block{

	private boolean used;
	private int playerNr;
	private int lives = 100;
	
	public Player(String image, boolean breakable, boolean walkable) {
		super(image, breakable, walkable);
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

	public void hit(int damage) {
		this.setLives(this.getLives() - damage);
	}

	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}

}