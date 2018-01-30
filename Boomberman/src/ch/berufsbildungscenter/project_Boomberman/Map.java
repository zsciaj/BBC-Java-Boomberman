package ch.berufsbildungscenter.project_Boomberman;

import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Map extends JPanel{
	
	
	public void Map(String fileName) {
		String[][] mapList = this.loadMap(fileName);
		this.setSize(mapList[0].length*64,mapList.length*64);
		this.setLayout(new GridLayout(mapList.length,mapList[0].length));
		for (String[] rows:mapList) {
			for (String item:rows) {
				ImageIcon im = new ImageIcon();
				switch(item) {
				case "0":
					im = (ImageIcon) loadIcon("Grass.png");
					break;
				case "1":
					im = (ImageIcon) loadIcon("1.png");
					break;
				case "2":
					im = (ImageIcon) loadIcon("2.png");
					break;						
			  }
				JLabel jL = new JLabel(im);
				jL.setSize(64, 64);
				add(jL);
		  }
	  }
		this.setVisible(true);
	}
	
	
	public String[][] loadMap(String fileName) {
		FileReader fr = null;
		BufferedReader br = null;
		String[][] list = new String[11][];
		try {
			fr = new FileReader("resource/"+ fileName +".txt");
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
