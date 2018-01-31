package ch.berufsbildungscenter.project_Boomberman;

import java.awt.Dimension;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class UnBreakableBlock extends JLabel {
	
	
	private Dimension position;
	private ImageIcon icon;
	private Map map;
	
	
	public UnBreakableBlock(Map map,String image,Dimension position){
		this.setPosition(position);
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

	

	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}

	public Map getMap() {
		return map;
	}


	public void setMap(Map map) {
		this.map = map;
	}


	public Dimension getPosition(int i1,int i2) {
		Dimension p = new Dimension((int) this.position.getHeight()+i1,(int) this.position.getWidth()+i2);
		return position;
	}


	public void setPosition(Dimension position) {
		this.position = position;
	}

}


