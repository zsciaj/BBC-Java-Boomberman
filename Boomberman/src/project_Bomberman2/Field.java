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
		int[] pos = this.findIndex(p);
		if (this.get(pos[0]+y, pos[1]+x).isWalkable()){
			this.set(pos[0], pos[1], new Block("Grass.png",false,true));	
			this.set(pos[0] + y, pos[1] + x, p);
		}
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
				
				ArrayList line = new ArrayList<Block>();
				
				String[] keyList = new String[15];
				keyList = s.split("/");
				for (String i: keyList) {
					
					System.out.print(i);
					
					switch(i) {
					case "0":
						line.add(new Block("Grass.png",false,true));
						break;
					case "1":
						line.add(new Block("unbreakableblock.png",false,false));
						break;
					case "2":
						line.add(new Block("breakableblock.png",true,false));
						break;
					case "3":
						if (player1 == null) {
							this.setPlayer1(new Player("player1front.png",false,true));
							line.add(this.getPlayer1());
						}else {
							this.setPlayer2(new Player("player2front.png",false,true));
							line.add(this.getPlayer2());
						}
						break;
					}
					
				}
				System.out.println(" ");
				
				this.add(line);
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


	
	
	
	public int[] findIndex(Block b1) {
		
		int x = 0;
		for (ArrayList<Block> list: this) {
			System.out.println("1b");
			int y = 0;
			for (Block b2 :list) {
				if (b2.getId().equals(b1.getId())) {
					System.out.println("2b");
					
					int[] pos = new int[2];
					pos[0] = x;
					pos[1] = y;
					return pos;
					
				}
				y++;
			}
			x++;
		}
		return null;
	}
	
	public void remove(int x, int y) {
		this.get(x).remove(y);
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
