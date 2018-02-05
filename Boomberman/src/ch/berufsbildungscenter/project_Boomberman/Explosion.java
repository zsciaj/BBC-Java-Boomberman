package ch.berufsbildungscenter.project_Boomberman;

public class Explosion extends UnBreakableBlock implements Runnable {

	public Explosion(Map map, String image, int pos) {
		super(map, image, pos);
		
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
