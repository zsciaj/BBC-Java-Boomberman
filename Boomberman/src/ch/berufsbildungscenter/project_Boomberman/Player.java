package ch.berufsbildungscenter.project_Boomberman;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;

public class Player extends UnBreakableBlock implements KeyListener{
	
	

	

	public Player(Map map, String image, int i) {
		super(map, image, i);
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
				im = (ImageIcon) this.loadIcon("");
				break;
			case 's':
				y = 1;
				im = (ImageIcon) this.loadIcon("player1right.png");
				break;
			case 'd':
				x = 1;
				im = (ImageIcon) this.loadIcon("player1back.png");
				break;
		}
		this.setIcon(im);
		this.updateUI();
		if (this.getMap().getMapList().get(this.getPosition(x, y)) instanceof Grass) {
			this.setPosition(this.getPosition(x,y));
			this.getMap().update();
		}
		
	}

}
