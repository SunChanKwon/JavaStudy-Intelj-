package Data0709Event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class MouseAdapterTest extends JFrame {

    int x, y;
    MyCanvas mc =new MyCanvas();
    public MouseAdapterTest(){
        add(mc);
        setSize(500,500);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        mc.addMouseListener(new MouseAdapter(){
            public void mouseReleased(MouseEvent me){
                //익명의 이벤트 생성 이벤트가 정보가 담긴다.//익명의 내부 클래스
                ///---
                //마우스가 클릭된 곳의 자료를 가져온다.
                if(me.getButton()==1)
                x=me.getX();
                y=me.getY();
                mc.repaint();
            }
        });
    }
    public class MyCanvas extends Canvas{
        public void paint(Graphics g)
        {
            Random ran = new Random();
            g.setColor(new Color(ran.nextInt(256),ran.nextInt(256),ran.nextInt(256)));
            g.fillOval(x-25,y-25,50,50);
        }
        public void update(Graphics g){
            paint(g);
        }
    }

    public static void main(String[] args) {
        new MouseAdapterTest();
    }
}
