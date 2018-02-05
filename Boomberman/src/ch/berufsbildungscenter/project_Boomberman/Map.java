package ch.berufsbildungscenter.project_Boomberman;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Map extends JPanel{
	
	JFrame jf;
	
	ArrayList<UnBreakableBlock> mapList = new ArrayList<UnBreakableBlock>();
	

	public Map(JFrame w){
		this.setJf(w);
	}
	
	public void update(){
		for (UnBreakableBlock block: this.getMapList()) {
			
			Grass g = new Grass(this,"Grass.png",this.getMapList().indexOf(block));
			block.updateUI();
			this.remove(this.getMapList().indexOf(block));
			this.add(g,this.getMapList().indexOf(block));
			
			this.remove(block.getPosition());
			this.add(block,block.getPosition());
			
			this.getMapList().set(this.getMapList().indexOf(block), g);
			this.getMapList().set(block.getPosition(), block);
		}
		this.remove(1);
		this.add(new UnBreakableBlock(this,"unbreakableblock.png",1),1);
		this.updateUI();
			
	}

	
	public void remove(UnBreakableBlock o) {
		Grass g = new Grass(this,"Grass.png",this.getMapList().indexOf(o));
		
		this.remove(this.getMapList().indexOf(o));
		this.add(g,this.getMapList().indexOf(o));
		
//		this.remove(o.getPosition());
//		this.add(o,o.getPosition());
		
		this.getMapList().set(this.getMapList().indexOf(o), g);
//		this.getMapList().set(o.getPosition(), o);
	}
	
	
	
	
	public void show(String[][] list) {
		this.setSize(list[0].length*64,list.length*64);
		this.setLayout(new GridLayout(list.length,list[0].length));
		
		int i = 0;
		
		for (String[] rows:list) {
			for (String item:rows) {
				UnBreakableBlock block = null;
				switch(item) {
				case "0":
					block = new Grass(this,"Grass.png",i);
					break;
				case "1":
					block = new UnBreakableBlock(this,"unbreakableblock.png",i);
					break;
				case "2":
					block = new BreakableBlock(this,"breakableblock.png",i);
					break;
				case "3":
					block = new Player(this,"player1front.png",i);
					this.getJf().addKeyListener((KeyListener) block);
					break;
			  }
				
				this.getMapList().add(block);
				this.add(block);
				i++;
		  }

	  }
		this.setVisible(true);
		System.out.println(getMapList());
	}
	
	
	
	public String[][] load(String fileName) {
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



	public JFrame getJf() {
		return jf;
	}

	public void setJf(JFrame window) {
		this.jf = window;
	}

	public ArrayList<UnBreakableBlock> getMapList() {
		return mapList;
	}



	public void setMapList(ArrayList<UnBreakableBlock> mapList) {
		this.mapList = mapList;
	}

	
}
