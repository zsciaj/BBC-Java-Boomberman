package ch.berufsbildungscenter.project_Boomberman;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JPanel;

public class Map extends JPanel{
	
	
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
	
	
	public static void main(String[] args) {
	  Map map = new Map();
	  String[][] mapList = map.loadMap();
	  for (String[] rows:mapList) {
		  for (String item:rows) {
			  switch(item) {
			  
			  }
			  
		  }
		  
	  }
	  
	  
	  
	  
	}

}
