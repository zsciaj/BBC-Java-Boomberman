package ch.berufsbildungscenter.project_Boomberman;

import java.awt.BorderLayout;
import java.io.Serializable;
import java.util.Map;

import javax.swing.JPanel;

import ch.berufsbildungscenter.project_Bomberman2.Timer;

public class Window extends JPanel implements Serializable{
	

	
	
	public Window() {
		
		Map m = new Map();  
		m.show(m.load("map1"));
		
		
		Timer t = new Timer();
		Thread th = new Thread(t);
		th.start();
			
		add(t,BorderLayout.NORTH);

		add(m,BorderLayout.SOUTH);
		setSize((int)m.getSize().getWidth(),(int)m.getSize().getHeight());
	}



	
}
	