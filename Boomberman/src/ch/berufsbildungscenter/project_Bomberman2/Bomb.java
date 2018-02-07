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
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.explode(1,0);
		this.explode(-1,0);
		this.explode(0,-1);
		this.explode(0,1);
		this.getField().delete(this);
		
	}
	
	public void explode(int x, int y) {
		for (int i = 0; i < 4; i =+ y) {
			for (int j = 0; j < 4; j =+ y) {
				int[] pos = this.getField().findIndex(this);
				if (this.getField().get(pos[0] + i, pos[1] + j).isBreakable()) {
					this.getField().placeExplosion(this,i,j);
				}else {
					return;
				}
			}
		}
	}

	public Field getField() {
		return field;
	}


	public void setField(Field field) {
		this.field = field;
	}

}
