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
			//DOTO exposionsradius
		}
		
	}

}
