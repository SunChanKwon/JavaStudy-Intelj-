package Data0712;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DigitalClock2 extends JPanel implements Runnable{
    Calendar now;
    JLabel lbl = new JLabel("00:00:00",JLabel.CENTER);
    int x,y;
    public DigitalClock2(){
        setLayout(new BorderLayout());
        add(lbl);
    }

    public DigitalClock2(int x, int y)
    {
        this();
        this.x=x;
        this.y=y;


        Thread t =new Thread(this);
        t.start();
    }


    @Override
    public void run() {
        do {
            lbl.setText(getTimer());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }while(true);
    }
    public  String getTimer(){
        now =Calendar.getInstance();
        SimpleDateFormat fmt = new SimpleDateFormat("HH:mm:ss");
        return fmt.format(now.getTime());
    }
}



