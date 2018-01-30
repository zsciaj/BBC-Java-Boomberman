package ch.berufsbildungscenter.project_Boomberman;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JFrame{
	

	
	public static void main(String[] args) {
		Map m = new Map("map1");
		
		Window w = new Window();
		
		Player p = new Player(m,"Grass.png");
		
		
		m.showMap();
		
		
		w.addKeyListener(p);
		w.add(m,BorderLayout.SOUTH);
		w.setSize((int)m.getSize().getWidth(),(int)m.getSize().getHeight());
		w.setVisible(true);
		
	
	}
}
	