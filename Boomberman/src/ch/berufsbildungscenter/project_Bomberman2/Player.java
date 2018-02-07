package ch.berufsbildungscenter.project_Bomberman2;

public class Player extends Block{

	private boolean used;
	
	public Player(String image, boolean breakable, boolean walkable) {
		super(image, breakable, walkable);
	}

	public boolean isUsed() {
		return used;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}

}
