package ch.berufsbildungscenter.project_Boomberman;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;

public class Player extends UnBreakableBlock implements KeyListener{
	
	int[] direction = {-1,0};
	int lives = 100;

	public Player(Map map, String image, int pos) {
		super(map, image, pos);
		
	}

	
	

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		char taste = e.getKeyChar();
		int x = 0;
		int y = 0;
		ImageIcon im = null;
		switch (taste){
			case 'w':
				y = -1;
				im = (ImageIcon) this.loadIcon("player1front.png");
				break;
			case 'a':
				x = -1;
				im = (ImageIcon) this.loadIcon("player1front.png");
				break;
			case 's':
				y = 1;
				im = (ImageIcon) this.loadIcon("player1right.png");
				break;
			case 'd':
				x = 1;
				im = (ImageIcon) this.loadIcon("player1back.png");
				break;
			case ' ':
				Bomb b = new Bomb(this.getMap(),"bomb.png",this.getPosition(direction[0],direction[1]));
				Thread t = new Thread(b);
				t.start();
				if (this.getMap().getMapList().get(this.getPosition(direction[0],direction[1])) instanceof Grass) {
					this.getMap().getMapList().set(this.getPosition(direction[0],direction[1]),b);
					this.getMap().update();	
				}
				break;
		}
		this.setIcon(im);
		this.setDirection(new int[]{x,y});
		System.out.println(taste);
		if (this.getMap().getMapList().get(this.getPosition(x, y)) instanceof Grass) {
			this.setPosition(this.getPosition(x,y));
			this.getMap().update();
		}
		
	}




	public int[] getDirection() {
		return direction;
	}



	public void setDirection(int[] direction) {
		this.direction = direction;
	}



}
