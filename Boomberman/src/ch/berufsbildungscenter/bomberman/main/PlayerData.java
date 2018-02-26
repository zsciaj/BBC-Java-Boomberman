package ch.berufsbildungscenter.bomberman.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.io.Serializable;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class PlayerData extends JPanel implements Serializable {

	private static final long serialVersionUID = 4365612043039392213L;
	
	int lives = 100;
	private String name = null;
	private JLabel nameLabel = new JLabel();
	private JLabel pictureLabel = new JLabel();
	private JProgressBar healthbar = new JProgressBar();
	private JPanel healtName = new JPanel();

	public PlayerData(ImageIcon image, int nr) {

		this.getHealthbar().setValue(this.getLives());
		this.getNameLabel().setText(this.getName());
		this.getPictureLabel().setIcon(image);
		this.setName("Player " + String.valueOf(nr));

		this.getHealthbar().setBackground(Color.decode("#F0BB47"));
		this.getNameLabel().setBackground(Color.decode("#F0BB47"));
		this.getHealthbar().setForeground(Color.GREEN);
		this.getHealtName().setBackground(Color.decode("#F0BB47"));

		this.getHealtName().setLayout(new GridLayout(2, 1));
		this.getHealtName().add(this.getHealthbar(), 0);
		this.getHealtName().add(this.getNameLabel(), 1);

		this.setBackground(Color.decode("#F0BB47"));

		add(this.getPictureLabel(), BorderLayout.WEST);
		add(this.getHealtName());

	}

	public void hit(int damage) {
		this.setLives(this.getLives() - damage);
		if (this.getLives() <= 0) {
			this.getHealthbar().setBackground(Color.RED);
		}
	}

	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		this.lives = lives;
		this.getHealthbar().setValue(lives);

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (!name.equals(null)) {
			this.name = name;
			this.getNameLabel().setText(name);
		}	

	}

	public JLabel getNameLabel() {
		return nameLabel;
	}

	public void setNameLabel(JLabel nameLabel) {
		this.nameLabel = nameLabel;
	}

	public JLabel getPictureLabel() {
		return pictureLabel;
	}

	public void setPictureLabel(JLabel pictureLabel) {
		this.pictureLabel = pictureLabel;
	}

	public JProgressBar getHealthbar() {
		return healthbar;
	}

	public JPanel getHealtName() {
		return healtName;
	}

	public void setHealtName(JPanel healtName) {
		this.healtName = healtName;
	}

}
