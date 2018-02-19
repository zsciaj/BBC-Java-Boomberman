package ch.berufsbildungscenter.project_Bomberman2;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Image;
import java.io.Serializable;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlayerData extends JPanel implements Serializable {
	
	int lives = 100;
	ImageIcon image;
	String name = "test";
	JLabel j1 = new JLabel();
	JLabel j2 = new JLabel();
	
	public PlayerData() {
		
		
		j1.setText(this.getLives() + "");
		j2.setText(this.getName());
		
		add(j1,BorderLayout.NORTH);
		add(j2,BorderLayout.SOUTH);
		
		
	}
	
	public void hit(int damage) {
		this.setLives(this.getLives()-damage);
	}
	
	public int getLives() {
		return lives;
	}
	public void setLives(int lives) {
		this.lives = lives;
		this.getJ1().setText(String.valueOf(lives));
	
	}
	public ImageIcon getImage() {
		return image;
	}
	public void setImage(ImageIcon image) {
		this.image = image;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
		this.getJ2().setText(name);
	}

	public JLabel getJ1() {
		return j1;
	}

	public void setJ1(JLabel j1) {
		this.j1 = j1;
	}

	public JLabel getJ2() {
		return j2;
	}

	public void setJ2(JLabel j2) {
		this.j2 = j2;
	}
	
	
	
}
