package ch.berufsbildungscenter.project_Boomberman;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;

public class InputName extends JDialog {
	
	private JTextField demand = new JTextField("Gib deinen Spielnamen ein und drücke auf 'Start'!");
	private JTextField playerName = new JTextField();
	private JButton startButton = new JButton("Start");

	public static void main(String[] args) {
		
		InputName inputName = new InputName();
		inputName.setSize(550,300);
		inputName.setVisible(true);
		inputName.setResizable(false);
		
		
		/*JTextField playerName = new JTextField();
		playerName.setFont(new Font("Arial",Font.BOLD,24));
		Object[] message = {"Spielname", playerName};
		
		JOptionPane pane = new JOptionPane(message, JOptionPane.PLAIN_MESSAGE, JOptionPane.OK_CANCEL_OPTION);
		pane.createDialog(null, " ").setVisible(true);
		System.out.println(playerName.getText());*/
	}
	
	public InputName() {
		setTitle(" ");
		
		playerName.setFont(new Font("Arial", Font.TRUETYPE_FONT, 30));
		playerName.setHorizontalAlignment(JTextField.CENTER);
		startButton.setFont(new Font("Arial", Font.BOLD, 24));
		startButton.setMaximumSize(new Dimension(100, 100));
		demand.setHorizontalAlignment(JTextField.CENTER);
		demand.setFont(new Font("Arial", Font.TRUETYPE_FONT, 24));
		demand.setEditable(false);
		
		add(demand, BorderLayout.NORTH);
		add(startButton, BorderLayout.SOUTH);
		add(playerName, BorderLayout.CENTER);
	}

}
