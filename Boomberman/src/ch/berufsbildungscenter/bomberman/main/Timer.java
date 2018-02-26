package ch.berufsbildungscenter.bomberman.main;

import java.awt.Color;
import java.awt.Font;
import java.io.Serializable;
import java.util.Date;

import javax.swing.JLabel;

public class Timer extends JLabel implements Runnable, Serializable {

	private static final long serialVersionUID = -329063742720724845L;
	
	Date startTime = new Date();										//Speichere die Startzeit

	public Timer() {
		this.setText("0:0");
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
			this.setFont(new Font("Arial", Font.BOLD, 30));
			this.setBackground(Color.WHITE);
			String s;

			if (this.getTime() % 60 < 10) {
				s = "0" + this.getTime() % 60;						//Berechne Sekunden
			} else {
				s = "" + this.getTime() % 60;						//Berechne Sekunden
			}
			this.setText(this.getTime() / 60 + ":" + s);			//Berechne Minuten und füge Sekunden hinzu
			this.revalidate();
		}
	}

	@SuppressWarnings("deprecation")
	public int getTime() {
		Date d = new Date();
		return ((120 + (this.getStartSek() + this.getStartMin() * 60) - (d.getSeconds() + d.getMinutes() * 60))); //Berechne Verbleibende Zeit in Sekunden
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	@SuppressWarnings("deprecation")
	public int getStartMin() {
		return startTime.getMinutes();
	}

	@SuppressWarnings("deprecation")
	public int getStartSek() {
		return startTime.getSeconds();
	}
}
