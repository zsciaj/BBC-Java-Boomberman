package ch.berufsbildungscenter.project_Boomberman;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Map extends JPanel{
	HashMap<Dimension, UnBreakableBlock> mapDic = new HashMap<Dimension, UnBreakableBlock>();
	String[][] mapList;
	


	public void showMap() {
		this.setSize(mapList[0].length*64,mapList.length*64);
		this.setLayout(new GridLayout(mapList.length,mapList[0].length));
		
		int i = 0;
		int j = 0;
		for (String[] rows:this.getMapList()) {
			for (String item:rows) {
				ImageIcon im = new ImageIcon();
				UnBreakableBlock block = null;
				switch(item) {
				case "0":
					block = new Grass(this,"Grass.png",new Dimension(i,j));
					break;
				case "1":
					block = new UnBreakableBlock(this,"1.png",new Dimension(i,j));
					break;
				case "2":
					block = new BreakableBlock(this,"2.png",new Dimension(i,j));
					break;
				case "3":
					block = new Player(this,"player1front.png",new Dimension(i,j));
			  }
				this.getMapDic().put(new Dimension(i,j), block);
				this.add(block);
				j++;
		  }
	  }i++;
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

	
	public HashMap<Dimension, UnBreakableBlock> getMapDic() {
		return mapDic;
	}



	public void setMapDic(HashMap<Dimension, UnBreakableBlock> mapDic) {
		this.mapDic = mapDic;
	}


	public void setMapList(String[][] mapList) {
		this.mapList = mapList;
	}


	public String[][] getMapList() {
		return mapList;
	}		  
		  
		
}
