package ch.berufsbildungscenter.project_Bomberman2;

import java.awt.Color;
import java.awt.Font;
import java.io.Serializable;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class Timer extends JLabel implements Runnable,Serializable{

	Date startTime = new Date();
	
	public Timer() {
		this.setText("0:0");
	}
	
	
	
	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.setFont(new Font("Arial",Font.BOLD, 30));
			this.setBackground(Color.WHITE);
			String s;
			
			
			
			if ( this.getTime() % 60 < 10) {
				s =  "0" + this.getTime() % 60;
			}else {
				s =  "" + this.getTime() % 60;
			}
			this.setText(this.getTime() / 60 + ":" + s);
			
			this.revalidate();
		}
	}

	
	public int getTime() {
		Date d = new Date();
		return (( 60  +  (this.getStartSek() + this.getStartMin()*60) - (d.getSeconds() + d.getMinutes()*60)  ));
	}
	
	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	
	public int getStartMin() {
		return startTime.getMinutes();
	}

	public int getStartSek() {
		return startTime.getSeconds();
	}
}
