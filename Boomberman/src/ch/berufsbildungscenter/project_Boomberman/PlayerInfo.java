package ch.berufsbildungscenter.project_Boomberman;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

public class PlayerInfo extends JFrame {
	
	
	private JTextField playerName = new JTextField("Spieler1");
	private JProgressBar healthBar = new JProgressBar();
	
	public static void main(String[] args) {
		
		PlayerInfo playerInfo = new PlayerInfo();
		playerInfo.setResizable(false);
		playerInfo.setSize(200, 100);
		playerInfo.setVisible(true);
		
		for (int i = 100; i >= 0; i--) {
			playerInfo.playerHit(i);
		}
		
	}

	public PlayerInfo() {
		
		setTitle("test");
		playerName.setFont(new Font("Arial", Font.TRUETYPE_FONT, 25));
		playerName.setEditable(false);
		healthBar.setMaximum(100);
		healthBar.setMinimum(0);
		
		add(playerName, BorderLayout.NORTH);
		add(healthBar, BorderLayout.CENTER);
	}
	
	public void playerHit(int newValue) {
		healthBar.setValue(newValue);
	}
}
