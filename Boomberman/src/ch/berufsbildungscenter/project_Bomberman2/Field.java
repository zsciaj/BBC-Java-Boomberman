package ch.berufsbildungscenter.project_Bomberman2;

import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.JPanel;



public class Field extends ArrayList<ArrayList<Block>> implements Serializable {


	private Player player1;
	private Player player2;
	
	
	public void movePlayer(Player p, int x, int y){
		
	
		int[] pos = this.findBlock(p);
		this.set(pos[0], pos[1], new Block("Grass.png",false,true));	
		this.set(pos[0] + x, pos[1] + y, p);
		
	}
	
	
	
	public void load(String fileName) {
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader("resource/"+ fileName +".txt");
			br = new BufferedReader(fr);
			String s;
			int i1 = 0;
			while ((s = br.readLine()) != null){
				
				this.add(new ArrayList<Block>());
				
				String[] al = new String[11];
				al = s.split("/");
				for (String i: al) {
					switch(i) {
					case "0":
						this.get(i1).add(new Block("Grass.png",false,true));
						break;
					case "1":
						this.get(i1).add(new Block("unbreakableblock.png",false,false));
						break;
					case "2":
						this.get(i1).add(new Block("breakableblock.png",true,false));
						break;
					case "3":
						if (player1 == null) {
							this.setPlayer1(new Player("player1front.png",false,true));
							this.get(i1).add(this.getPlayer1());
						}else {
							this.get(i1).add(new Block("breakableblock.png",true,false));
//							this.setPlayer2(new Player("player2front.png",false,true));
//							this.get(i1).add(this.getPlayer2());
						}
						break;
						

		
					}
				}
				
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
	}


	
	
	
	public int[] findBlock(Block b) {
		int x = 0;
		int y = 0;
		for (ArrayList<Block> i: this) {
			if (i.contains(b)) {
				y = i.indexOf(b);
				break;
			}
			x ++;
		}
		int[] list = new int[2];
		list[0] = x;
		list[1] = y;
		return list;
	}
	
	
	public Block get(int x,int y) {
		return this.get(x).get(y);
	}

	
	public void set(int x,int y,Block b) {
		this.get(x).set(y, b);
	}

	
	
	
	
	
	
	
	public Player getPlayer1() {
		return player1;
	}


	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}


	public Player getPlayer2() {
		return player2;
	}


	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}

	



}
