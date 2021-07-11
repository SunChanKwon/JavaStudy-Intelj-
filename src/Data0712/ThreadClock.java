package Data0712;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ThreadClock extends JFrame{
    JLabel Korean = new JLabel();
    JLabel USA = new JLabel();


    public ThreadClock(){
        USA.setBounds(31,40,67,15);
        add(USA);
        Korean.setBounds(35,40,67,15);
        add(Korean);

        setSize(500,500);
        setVisible(true);
        setTime();
        while(true){
            try{
                setTime();
                Thread.sleep(1000);
            }catch(Exception e){}

        }

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
        System.out.println("미국시간:"+ year+1 + "년" + month + "월" + hour + "시간" + minute + "분" + second + "초");


        Korean.setText(timeStr1);
        USA.setText(timeStr1);
    }

    public static void main(String[] args) {
        new ThreadClock();
    }

}



