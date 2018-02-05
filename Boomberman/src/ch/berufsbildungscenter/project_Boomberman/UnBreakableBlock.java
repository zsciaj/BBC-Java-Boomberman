package ch.berufsbildungscenter.project_Boomberman;

import java.awt.Dimension;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class UnBreakableBlock extends JLabel {
	
	
	private int position;
	private Map map;
	
	
	public UnBreakableBlock(Map map,String image,int pos){
		this.setPosition(pos);
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

	


	public Map getMap() {
		return map;
	}


	public void setMap(Map map) {
		this.map = map;
	}


	public int getPosition() {
		return this.position;
	}

	
	public int getPosition(int i1, int i2) {
		return this.getPosition() +i1 + ((map.getWidth()/64+1)*i2);
	}

	public void setPosition(int pos) {
		this.position = pos;
	}

}


