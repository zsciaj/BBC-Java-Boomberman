package ch.berufsbildungscenter.bomberman.main;

public class Bomb extends Block implements Runnable {

	private Field field;
	
	public Bomb(String image, boolean breakable, boolean walkable,Field field) {
		super(image, breakable, walkable);
		this.setField(field);
	}
	
	
	public void run() {
		try {
			Thread.sleep(2000);
			this.explode(-1,0);						//Expodiere nach Oben
			this.explode(1,0);						//Expodiere nach Unten
			this.explode(0,1);						//Expodiere nach Rechts
			this.explode(0,-1);						//Expodiere nach Links
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			this.getField().delete(this);
		}
	}
	
	
	public void explode(int x, int y) {
		int addX = x;
		int addY = y;
		for (int j = 0;j<3;j++) {															//Für drei Blöcke in jeweilige Richtung
			int[] pos = this.getField().findIndex(this);
			Block actual = this.getField().get(x + pos[0],y + pos[1]);						//Hole den Aktuellen Block
			if (actual.isBreakable()) {
				this.getField().placeExplosion(x + pos[0],y + pos[1]);						//Plaziere an dieser Stelle eine Explosion
			} else {
				if (actual.getId().equals(this.getField().getPlayer1().getId())){			//Überprüfe ob der Aktuelle Block Spieler 1 ist
					this.getField().getPlayer1().getPlayerData().hit(50/(j+1));				//Füge dem jeweiligen spieler schaden zu     (schaden = 50/(entfernungInBlöcken+1))
				} else if (actual.getId().equals(this.getField().getPlayer2().getId())){		//Überprüfe ob der Aktuelle Block Spieler 1 ist
					this.getField().getPlayer2().getPlayerData().hit(50/(j+1));				//Füge dem jeweiligen spieler schaden zu     (schaden = 50/(entfernungInBlöcken+1))
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
