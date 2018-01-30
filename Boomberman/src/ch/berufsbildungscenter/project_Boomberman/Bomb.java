package ch.berufsbildungscenter.project_Boomberman;

public class Bomb extends UnBreakableBlock implements Runnable {

	public Bomb(Map map, String image) {
		super(map, image);
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
