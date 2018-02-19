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
			this.explode(-1,0);
			this.explode(1,0);
			this.explode(0,1);
			this.explode(0,-1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			this.getField().delete(this);
		}
	}
	
	
	public void explode(int x, int y) {
		int addX = x;
		int addY = y;
		for (int j = 0;j<3;j++) {
			int[] pos = this.getField().findIndex(this);
			Block actual = this.getField().get(x + pos[0],y + pos[1]);
			if (actual.isBreakable()) {
				this.getField().placeExplosion(x + pos[0],y + pos[1]);
			}else {
				if (actual.getId().equals(this.getField().getPlayer1().getId())){
					
				}else if (actual.getId().equals(this.getField().getPlayer2().getId())){
					
				}
				return;
			}
			x += addX;
			y += addY;
		}
	
	}
		


	public Field getField() {
		return field;
	}


	public void setField(Field field) {
		this.field = field;
	}

}
