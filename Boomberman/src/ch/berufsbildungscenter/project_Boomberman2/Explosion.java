package ch.berufsbildungscenter.project_Boomberman2;

import ch.berufsbildungscenter.project_Boomberman2.Map;

public class Explosion extends UnBreakableBlock implements Runnable {



	public Explosion(String image) {
		super(image);
	}

	@Override
	public void run() {
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.getMap().remove(this);

	}

}
