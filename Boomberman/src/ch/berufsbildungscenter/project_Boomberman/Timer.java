package ch.berufsbildungscenter.project_Boomberman;

import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class Timer extends JLabel implements Runnable{

	Date startTime = new Date();
	
	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.setText(this.getTime() / 60 + ":" + this.getTime() % 60);
			
			this.updateUI();
		}
	}

	
	public int getTime() {
		Date d = new Date();
		return (( 300  +  (this.getStartSek() + this.getStartMin()*60) - (d.getSeconds() + d.getMinutes()*60)  ));
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
