package ch.berufsbildungscenter.project_Boomberman;

import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class UnBreakableBlock extends JLabel {
	
	private ImageIcon icon;
	private Map map;
	
	
	public UnBreakableBlock(Map map,String image){
		this.setIcon(loadIcon(image));
		this.setMap(map);
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

	

	protected void setIcon(ImageIcon icon) {
		this.icon = icon;
	}

	private Map getMap() {
		return map;
	}


	protected void setMap(Map map) {
		this.map = map;
	}

}


