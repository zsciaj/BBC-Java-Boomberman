package ch.berufsbildungscenter.project_Boomberman2;

import java.awt.Dimension;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import ch.berufsbildungscenter.project_Boomberman2.Map;


public class UnBreakableBlock extends JLabel {
	
	private static Validator val;
	
	public UnBreakableBlock(String image) {
		this.setIcon(loadIcon(image));
	}

	public static Validator getVal() {
		return val;
	}


	public static void setVal(Validator val) {
		UnBreakableBlock.val = val;
	}

	
	
	
	
	protected static Icon loadIcon(String iconName) {
		final URL resource = Map.class.getResource("/resource/" + iconName);

		if (resource == null) {
			// TODO Replace by logger
			System.err.println(
					"Error in " + Map.class.getName() + ": Icon /resource/" + iconName + " could not be loaded.");
			return new ImageIcon();
		}
		return new ImageIcon(resource);
	}

	


	
	
}


