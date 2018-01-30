package ch.berufsbildungscenter.project_Boomberman;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player extends UnBreakableBlock implements KeyListener{
	
	
	public Player(Map map,String image) {
		super(map,image);
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
		switch (e.getKeyChar()){
		case 'w':
			
		}

	}

}
