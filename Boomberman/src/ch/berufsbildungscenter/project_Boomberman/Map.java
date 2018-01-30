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
	
	String[][] mapList;
	
	public void showMap() {
		this.setSize(mapList[0].length*64,mapList.length*64);
		this.setLayout(new GridLayout(mapList.length,mapList[0].length));
		for (String[] rows:this.getMapList()) {
			for (String item:rows) {
				ImageIcon im = new ImageIcon();
				UnBreakableBlock block = null;
				switch(item) {
				case "0":
					block = new UnBreakableBlock();
					break;
				case "1":
					block = new BreakableBlock();
					break;
				case "2":
					block = new UnBreakableBlock();
					break;						
			  }
				this.add(block);
		  }
	  }
		this.setVisible(true);
	}
	
	
	public Map(String fileName) {
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
		this.setMapList(list);
	}



	private void setMapList(String[][] mapList) {
		this.mapList = mapList;
	}


	private String[][] getMapList() {
		return mapList;
	}		  
		  
		
}
