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
	String name = "";
	
	
	public PlayerData() {
		JLabel j1 = new JLabel();
		JLabel j2 = new JLabel();
		
		j1.setText(this.getLives() + "");
		j2.setText(this.getName());
		
		add(j1,BorderLayout.NORTH);
		add(j2,BorderLayout.SOUTH);
		
		
	}
	
	
	public int getLives() {
		return lives;
	}
	public void setLives(int lives) {
		this.lives = lives;
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
	}
	
	
	
}
