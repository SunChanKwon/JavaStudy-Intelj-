package Data0712;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ThreadClock extends JFrame implements Runnable{
   Calendar now;
   JLabel lbl = new JLabel("00:00:00",JLabel.CENTER);
   int x,y;
    public ThreadClock(){
    super("시계");
    add(lbl);
    }

    public ThreadClock(int x, int y)
    {
        this();
        this.x=x;
        this.y=y;
        setBounds(x,y,500,200);
        setSize(500,500);
        setVisible(true);
    }

    public void setTime() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);

        int month = cal.get(Calendar.MONTH);
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);
        int second = cal.get(Calendar.SECOND);
        String timeStr1 = ("한국시간:"+ year + "년" + month + "월" + hour + "시간" + minute + "분" + second + "초");
        String timeStr2 = ("미국시간:"+ year + "년" + month + "월" + hour + "시간" + minute + "분" + second + "초");

        System.out.println("한국시간:"+ year + "년" + month + "월" + hour + "시간" + minute + "분" + second + "초");
        System.out.println("미국시간:"+ year + "년" + month + "월" + hour + "시간" + minute + "분" + second + "초");

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

    public static void main(String[] args) {
//        ThreadClock dc1= new ThreadClock(0,0);
//        Thread t1 = new Thread(dc1);
//        t1.start();
//
//        ThreadClock dc2 = new ThreadClock(500,0);
//        Thread t2 = new Thread(dc2);
//        t2.start();
//
//        ThreadClock dc3 = new ThreadClock(500,0);
//        Thread t3 = new Thread(dc3);
//        t3.start();
    }
}



