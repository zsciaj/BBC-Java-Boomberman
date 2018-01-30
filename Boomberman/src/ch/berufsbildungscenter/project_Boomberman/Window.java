package ch.berufsbildungscenter.project_Boomberman;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JFrame{
	

	
	public static void main(String[] args) {
		Map m = new Map();
		Window w = new Window();
		
		w.setSize((int)m.getSize().getWidth(),(int)m.getSize().getHeight());
		w.add(m,BorderLayout.SOUTH);
		w.setVisible(true);
	}
}	