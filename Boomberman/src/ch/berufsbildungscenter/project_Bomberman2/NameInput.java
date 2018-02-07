package ch.berufsbildungscenter.project_Bomberman2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class NameInput extends JDialog {

	private JLabel demand;
	private JTextField playerName;
	private JButton startButton;
	
	
	public NameInput() {
		setTitle(" ");
		
		demand.setHorizontalAlignment(JTextField.CENTER);
		demand.setFont(new Font("Arial", Font.TRUETYPE_FONT, 18));
		demand .setPreferredSize(new Dimension(50,50));
		playerName.setFont(new Font("Arial", Font.TRUETYPE_FONT, 18));
		playerName.setHorizontalAlignment(JTextField.CENTER);
		playerName.setPreferredSize(new Dimension(50,50));
		startButton.setFont(new Font("Arial", Font.BOLD, 18));
		startButton.setPreferredSize(new Dimension(150,50));
		
		
		
		
		add(demand, BorderLayout.NORTH);
		add(playerName, BorderLayout.CENTER);
		add(startButton, BorderLayout.SOUTH);
	}
	
	public static void main(String[] args) {
		NameInput jd = new NameInput();
		jd.setVisible(true);
		jd.setResizable(false);
		jd.setSize(400, 300);
	}
	
}	
	
