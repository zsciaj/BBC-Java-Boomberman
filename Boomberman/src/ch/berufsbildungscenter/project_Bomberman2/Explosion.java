package ch.berufsbildungscenter.project_Bomberman2;

public class Explosion extends Bomb {

	public Explosion(String image, boolean breakable, boolean walkable,Field field) {
		super(image, breakable, walkable,field);
	}


	public void run() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			this.getField().delete(this);
		}
		
		
	}

}
