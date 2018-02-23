package ch.berufsbildungscenter.bomberman.main;

public class Explosion extends Bomb {

	private static final long serialVersionUID = -7062959797183100824L;

	public Explosion(String image, boolean breakable, boolean walkable, Field field) {
		super(image, breakable, walkable, field);
	}

	public void run() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			this.getField().delete(this);
		}

	}

}
