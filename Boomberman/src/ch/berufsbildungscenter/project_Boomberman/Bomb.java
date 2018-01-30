package ch.berufsbildungscenter.project_Boomberman;

import java.awt.Dimension;

public class Bomb extends UnBreakableBlock implements Runnable {

	public Bomb(Map map,String image,Dimension position) {
		super(map,image,position);
	}

	@Override
	public void run() {
		try {
			this.wait(300);
			System.out.println("Explode");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
