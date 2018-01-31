package ch.berufsbildungscenter.project_Boomberman;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player extends UnBreakableBlock implements KeyListener{
	
	
	public Player(Map map,String image,Dimension position) {
		super(map,image,position);
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
			this.getMap().changeMapDic(this.getPosition(0, 0), new Grass(this.getMap(),"Grass.png",this.getPosition(0, 0)));
			this.getMap().changeMapDic(this.getPosition(1, 0), this);
			this.getMap().update();
			this.getMap().updateUI();
		
		}

	}

}
