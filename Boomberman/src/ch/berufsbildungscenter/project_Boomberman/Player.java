package ch.berufsbildungscenter.project_Boomberman;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player extends UnBreakableBlock implements KeyListener{
	
	

	

	public Player(Map map, String image, Dimension position) {
		super(map, image, position);
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
		System.out.println(e.getKeyChar());
		char taste = e.getKeyChar();
		int x = 0;
		int j = 0;
		switch (taste){
		case 'w':
			x = 1;
			j = 0;
			break;
		case 'a':
			x = 0;
			j = -1;
			break;
		case 's':
			x = -1;
			j = 0;
			break;
		case 'd':
			x = 0;
			j = 1;
			break;
		}	
		this.setPosition(this.getPosition(x, j));
		this.getMap().update();
		this.getMap().updateUI();

	}

}
