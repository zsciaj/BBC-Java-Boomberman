package ch.berufsbildungscenter.project_Boomberman2;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ch.berufsbildungscenter.project_Boomberman.Grass;
import ch.berufsbildungscenter.project_Boomberman.UnBreakableBlock;




public class Map extends JPanel{
	
	
	KeyListener player1;
	KeyListener player2;
	ArrayList<UnBreakableBlock> mapList = new ArrayList<UnBreakableBlock>();
	
	protected Map() throws RemoteException {
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
		Grass g = new Grass("Grass.png");
		
		this.remove(this.getMapList().indexOf(o));
		this.add(g,this.getMapList().indexOf(o));
		
//		this.remove(o.getPosition());
//		this.add(o,o.getPosition());
		
		this.getMapList().set(this.getMapList().indexOf(o), g);
//		this.getMapList().set(o.getPosition(), o);
	}
	
	
	public void move(int[] dir,Player p){
		this.remove(p);
		this.add(new Grass("Grass.png"),this.getMapList().indexOf(p));
		
		this.remove(this.getMapList().indexOf(p)  +  dir[0]   +   (this.getWidth()/64+1) * dir[1]  );
		
	}
	
	public void placeBomb(int[] dir,Player p){
		if (this.getMapList().get(this.getMapList().indexOf(p)  +  dir[0]   +   (this.getWidth()/64+1) * dir[1]  ) instanceof Grass) {
			Bomb b = new Bomb("bomb.png");
			Thread t = new Thread(b);
			t.start();
			this.getMapList().set((this.getMapList().indexOf(p)  +  dir[0]   +   (this.getWidth()/64+1) * dir[1]  ),b);	
			
		}
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
					block = new Grass("Grass.png");
					break;
				case "1":
					block = new UnBreakableBlock("unbreakableblock.png");
					break;
				case "2":
					block = new BreakableBlock("breakableblock.png");
					break;
				case "3":
					block = new Player(this,"player1front.png",i);
					//this.getJf().addKeyListener((KeyListener) block);////////////////////////////////////
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



	public ArrayList<UnBreakableBlock> getMapList() {
		return mapList;
	}



	public void setMapList(ArrayList<UnBreakableBlock> mapList) {
		this.mapList = mapList;
	}


	public KeyListener getPlayer1() {
		return player1;
	}


	public void setPlayer1(KeyListener player1) {
		this.player1 = player1;
	}


	public KeyListener getPlayer2() {
		return player2;
	}


	public void setPlayer2(KeyListener player2) {
		this.player2 = player2;
	}


	
}
