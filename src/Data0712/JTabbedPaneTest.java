package Data0712;

import Data0701HomeWokr.SwingCul;

import javax.swing.*;
import java.awt.*;

public class JTabbedPaneTest extends JFrame {
JTabbedPane tp;
JLabel lbl;
ImageIcon ii = new ImageIcon("img/1.jpg");
JButton btn;

DigitalClock2 dc = new DigitalClock2(0,0); //새로운 객체 생성했다.
    SwingCul2 cal = new SwingCul2(); //시간 객체생성
   // SwingCal2 calendar = new SwingCal2();
    ImageIcon iii = new ImageIcon("img/3.jpg");
    //HomeWorkPickMan2 PM = new HomeWorkPickMan2();

    public JTabbedPaneTest(){
        super("탭메뉴");

        tp = new JTabbedPane(JTabbedPane.LEFT);
        lbl = new JLabel(ii);
        btn= new JButton(iii);
        tp.addTab("레이블",lbl);
        tp.addTab("버튼",btn);
        tp.addTab("시계",dc);
       // tp.addTab("픽맨",PM);
        tp.addTab("계산기",cal);
        //tp.addTab("달력",null,calendar,"달력");


       // add(tp);
        setSize(500,500);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        try{Thread.sleep(3000);}catch (Exception e) {}
        tp.removeTabAt(3);
    }

    public static void main(String[] args) {
        new JTabbedPaneTest();
    }
}
