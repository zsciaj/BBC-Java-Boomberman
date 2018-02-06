package ch.berufsbildungscenter.project_Boomberman2;

import java.awt.Dimension;

import ch.berufsbildungscenter.project_Boomberman2.Map;

public class Bomb extends UnBreakableBlock implements Runnable {



	public Bomb(String image) {
		super(image);
	}

	@Override
	public void run() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Explode");
		
//		for(int i = -3; i!=4;i++) {
//			this.explode(i,0);
//			this.explode(0,i);
//		}
		
		this.explodeX(-1);
		this.explodeX(1);
		
		
		this.explodeY(-1);
		this.explodeY(1);
		
		this.getMap().remove(this);
	}
	
	public void explode(int x,int y) {
		if (this.getPosition(x, y) >= 0 && this.getPosition(x, y) < this.getMap().getMapList().size()) {
			
			if (this.getMap().getMapList().get(this.getPosition(x, y)) instanceof BreakableBlock) {
				
				Explosion e = new Explosion(this.getMap(),"Explosion.png",this.getPosition(x,y));
				Thread t = new Thread(e);
				t.start();
				this.getMap().getMapList().set(this.getPosition(x, y),e);
				this.getMap().update();	
				
				
//				Grass g = new Grass(this.getMap(),"Grass.png",this.getPosition(x,y));
//				this.getMap().getMapList().set(this.getPosition(x, y),g);
//				this.getMap().update();	
			}
			
		}
			
	}
	
	public void explodeX(int x) {
		for (int i = 1; i<4; i =+ x) {
			if (this.getMap().getMapList().get(this.getPosition(x, 0)) instanceof UnBreakableBlock) {
				break;
			}else {
				Explosion e = new Explosion(this.getMap(),"Explosion.png",this.getPosition(x,0));
				Thread t = new Thread(e);
				t.start();
				this.getMap().getMapList().set(this.getPosition(x, 0),e);
				this.getMap().update();	
			}
		}
	}
	
	public void explodeY(int y) {
		for (int i = 1; i<4; i =+ y) {
			if (this.getMap().getMapList().get(this.getPosition(0, y)) instanceof UnBreakableBlock) {
				break;
			}else {
				Explosion e = new Explosion(this.getMap(),"Explosion.png",this.getPosition(0,y));
				Thread t = new Thread(e);
				t.start();
				this.getMap().getMapList().set(this.getPosition(0, y),e);
				this.getMap().update();	
			}
		}
	}

}
