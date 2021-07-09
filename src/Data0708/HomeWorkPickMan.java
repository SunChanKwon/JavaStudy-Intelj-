package Data0708;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class HomeWorkPickMan extends JFrame {
    JPanel pane = new JPanel();
    Image img;

    MyCanvas mc = new MyCanvas();
Dimension dim;
int x ,y;
int p;
    public HomeWorkPickMan() {
        add(BorderLayout.NORTH, pane);
        add(mc);

        setSize(1500, 1000);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        dim = mc.getSize();
        x = (int)(dim.getWidth()/2 - 25);
        y = (int)(dim.getHeight()/2 - 25);

        mc.addKeyListener((KeyListener) this);//키이벤트 리스너 등록
        while (true)
        {
            mc.repaint();
            if(p==0){p++; }
            else{ p--;}
            x-=5;
            if(x<=-50) x = (int)dim.getHeight();
            if(x<=0)
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public class MyCanvas extends Canvas {
        public MyCanvas() {

            img = Toolkit.getDefaultToolkit().getImage("img/Man.jpg");
        }

        public void paint(Graphics g) {
            //원본 이미지 그림을 그린다.

            int imgW = 50;
            int imgH = 50;

            int p = 0;

            g.drawImage(img, x, y, x + 50, y + 50, p * 50, 0, p * 50 + 50, 50, this);
        }
            //  g.drawImage(img, 0, 0, 50, 50, imgW, 0, imgW*2, 50, this);

//            g.drawImage(img, 0, 0, 50, 50, imgW*2, 0, imgW*3, 50, this);
//            g.drawImage(img, 0, 0, 50, 50, imgW*3, 0, imgW*4, 50, this);
//            g.drawImage(img, 0, 0, 50, 50, imgW*4, 0, imgW*5, 50, this);
//            g.drawImage(img, 0, 0, 50, 50, imgW*5, 0, imgW*6, 50, this);
//            g.drawImage(img, 0, 0, 50, 50, imgW*6, 0, imgW*7, 50, this);
//            g.drawImage(img, 0, 0, 50, 50, imgW*7, 0, imgW*8, 50, this);
//        }
        }
            public void update (Graphics g)
            {
                paint(g);
            }
        public void keyPressed(KeyEvent ke)
        {

        }
    public void keyReleased(KeyEvent ke)
    {
        int code = ke.getKeyCode();
        if(code == KeyEvent.VK_LEFT || code == KeyEvent.VK_A){
            p=0;
        }else if(code == KeyEvent.VK_RIGHT || code==KeyEvent.VK_D)
        {
            p=2;
        }
        else if(code ==KeyEvent.VK_UP || code==KeyEvent.VK_W)
        {
            p=4;
        }
        else if(code ==KeyEvent.VK_DOWN || code==KeyEvent.VK_S)
        {
            p=6;
        }
    }
    public void keyTyped(KeyEvent ke)
    {

    }

        public static void main(String[] args) {
            new HomeWorkPickMan();

        }


}
