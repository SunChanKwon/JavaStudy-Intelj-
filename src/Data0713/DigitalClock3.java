package Data0713;

import java.awt.BorderLayout;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;


import javax.swing.JLabel;
import javax.swing.JPanel;

public class DigitalClock3 extends JPanel implements Runnable {
		Font fnt = new Font("����", Font.BOLD,100);
		Calendar now = Calendar.getInstance();
		JLabel lbl = new JLabel("00:00:00", JLabel.CENTER);
		int x, y;
	public DigitalClock3() {
		setLayout(new BorderLayout());
		add(lbl);
		lbl.setFont(fnt);
	}
	public DigitalClock3(int x, int y) {
		this();
		this.x = x;
		this.y = y;
		//setBounds(x, y, 500,200);
		//setVisible(true);
		
		Thread t = new Thread(this);
		t.start();
	}
	//�ð�����
	public void run() {
		do {
			//�ð�����
			lbl.setText(getTimer());
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				
			}
		}while(true);
	}
	//����ð��� 00:00:00
	public String getTimer() {
		now = Calendar.getInstance();
		SimpleDateFormat fmt = new SimpleDateFormat("HH:mm:ss");
		return fmt.format(now.getTime());
	}
}
