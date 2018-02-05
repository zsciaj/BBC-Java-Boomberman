package ch.berufsbildungscenter.project_Boomberman;

import java.awt.Dimension;

public class Bomb extends UnBreakableBlock implements Runnable {

	public Bomb(Map map,String image,int i) {
		super(map,image,i);
	}

	@Override
	public void run() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Explode");
		for(int i = -3; i!=4;i++) {
			for(int j = -3; j!=4;j++) {
				Bomb b = new Bomb(this.getMap(),"Grass.png",this.getPosition(i,j));
				if (this.getPosition(i, j) >= 0 && this.getPosition(i, j) < this.getMap().getMapList().size()) {
					if (this.getMap().getMapList().get(this.getPosition(i, j)) instanceof BreakableBlock) {
						this.getMap().getMapList().set(this.getPosition(i, j),b);
						this.getMap().update();		
					}else if(this.getMap().getMapList().get(this.getPosition(i, j)) instanceof Player){
						
						//this.getMap().getMapList().get(this.getPosition(i, j))  +++++ :DAMAGE();
						//this.getMap().update();
					}
						
				}
						
			}
			
		}
		
	}
	
}
