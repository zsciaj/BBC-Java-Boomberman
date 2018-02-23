package ch.berufsbildungscenter.bomberman.main;

import java.net.URL;
import java.util.UUID;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Block extends JLabel {

	private boolean breakable;
	private boolean walkable;
	String id = UUID.randomUUID().toString(); 									// Zufällige Id um das Objekt zu identifizieren

	public Block(String image, boolean breakable, boolean walkable) {
		this.setBreakable(breakable);
		this.setWalkable(walkable);
		this.setIcon(loadIcon(image));

	}

	public void setIcon(String image) {
		super.setIcon(loadIcon(image));
	}

	public boolean isBreakable() {
		return breakable;
	}

	public void setBreakable(boolean breakable) {
		this.breakable = breakable;
	}

	public boolean isWalkable() {
		return walkable;
	}

	public void setWalkable(boolean walkable) {
		this.walkable = walkable;
	}

	public String getId() {
		return id;
	}

	public static Icon loadIcon(String iconName) { 								// Methode um Bilder zu laden
		final URL resource = Block.class.getResource("/resource/" + iconName);

		if (resource == null) {
			System.err.println("Error in " + Block.class.getName() + ": Icon /resource/" + iconName + " could not be loaded.");
			return new ImageIcon();
		}
		return new ImageIcon(resource);
	}
}
