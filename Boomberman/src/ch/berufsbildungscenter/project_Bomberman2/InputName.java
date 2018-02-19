package ch.berufsbildungscenter.project_Bomberman2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class InputName extends JDialog {

	private JTextField demand = new JTextField("Gib deinen Spielnamen ein und drücke auf 'Start'!");
	private JTextField playerName = new JTextField();
	private JButton startButton = new JButton("Start");
	private String player1Name;
	

	public static void main(String[] args) {

		InputName inputName = new InputName();
		inputName.setSize(550, 300);
		inputName.setVisible(true);
		inputName.setResizable(false);

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
		
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				player1Name = playerName.getText();
				System.out.println(player1Name);
			}
		});
	}

}
