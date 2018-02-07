package ch.berufsbildungscenter.project_Boomberman;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ch.berufsbildungscenter.project_Bomberman2.Timer;
import ch.berufsbildungscenter.project_Boomberman2.Map;

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
	