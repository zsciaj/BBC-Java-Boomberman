package ch.berufsbildungscenter.project_Boomberman;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ch.berufsbildungscenter.lab14.view.CamperView;

public class Map extends JFrame{
	
	
	public String[][] loadMap() {
		FileReader fr = null;
		BufferedReader br = null;
		String[][] list = new String[11][];
		try {
			fr = new FileReader("resource/map1.txt");
			br = new BufferedReader(fr);
			String s;
			int i1 = 0;
			while ((s = br.readLine()) != null){
				list[i1] = s.split("/");
				i1++;
			}
		} catch (IOException e) {
			e.printStackTrace();	
		}finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
			}
		}
		return list;
	}
	
	
	public void showMap() {
		this.setSize(200,200);
		this.setVisible(true);
		this.
		String[][] mapList = this.loadMap();
		for (String[] rows:mapList) {
			for (String item:rows) {
				ImageIcon im = new ImageIcon();
				switch(item) {
				case "1":
					im = (ImageIcon) loadIcon("player1right.png");
					break;
				case "2":
					im = (ImageIcon) loadIcon("player1left.png");
					break;
						
			  }
				add(new JLabel(im));
		  }
	  }
	}
	
	
	public static void main(String[] args) {
		Map map = new Map();
		
		map.showMap();
	
	}
	
	private static Icon loadIcon(String iconName) {
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
