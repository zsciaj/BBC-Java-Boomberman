package ch.berufsbildungscenter.project_Bomberman2;

public class Bomb extends Block implements Runnable {

	private Field field;
	
	public Bomb(String image, boolean breakable, boolean walkable,Field field) {
		super(image, breakable, walkable);
		this.setField(field);
	}
	
	
	public void run() {
		try {
			Thread.sleep(3000);
			this.explode();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			this.getField().delete(this);
		}
	}
	

	public void explode() {
			this.getField().placeExplosion(this, -1, 0);
			this.getField().placeExplosion(this, 1, 0);
			this.getField().placeExplosion(this, 0, -1);
			this.getField().placeExplosion(this, 0, 1);
	}

	public Field getField() {
		return field;
	}


	public void setField(Field field) {
		this.field = field;
	}

}
