package ch.berufsbildungscenter.project_Boomberman;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Window extends JFrame{
	

	
	public static void main(String[] args) {
		Window w = new Window();
		
		Map m = new Map(w);
		m.show(m.load("map1"));
		
		
		
		
		Timer t = new Timer();
		Thread th = new Thread(t);
		th.start();
		
		
		
		w.add(t,BorderLayout.NORTH);
		w.add(m,BorderLayout.SOUTH);
		w.setSize((int)m.getSize().getWidth(),(int)m.getSize().getHeight());
		w.setVisible(true);
		
	
	}
}
	