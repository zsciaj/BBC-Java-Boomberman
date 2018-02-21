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
	private JTextField input = new JTextField();
	private JButton startButton = new JButton("Start");
	private String playerName;
	



	public InputName() {
		this.setSize(350, 120);
		this.setVisible(true);
		this.setResizable(false);
		this.setTitle("Enter Your Name");

		this.getInput().setFont(new Font("Arial",  Font.BOLD, 16));
		this.getStartButton().setFont(new Font("Arial", Font.BOLD, 20));
		
		this.getDemand().setFont(new Font("Arial", Font.TRUETYPE_FONT, 16));
		this.getDemand().setEditable(false);
		
		add(this.getDemand(), BorderLayout.NORTH);
		add(this.getStartButton(), BorderLayout.SOUTH);
		add(this.getInput(), BorderLayout.CENTER);


	
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPlayerName(input.getText());
			}
		});
		
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	
	public JTextField getDemand() {
		return demand;
	}

	public void setDemand(JTextField demand) {
		this.demand = demand;
	}

	public JTextField getInput() {
		return input;
	}

	public void setInput(JTextField input) {
		this.input = input;
	}

	public JButton getStartButton() {
		return startButton;
	}

	public void setStartButton(JButton startButton) {
		this.startButton = startButton;
	}
	

	
}
