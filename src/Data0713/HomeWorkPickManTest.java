package Data0713;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//public class HomeWorkPickManTest extends JPanel{
//    JPanel pane = new JPanel();
//    Image img;
//
//    MyCanvas mc = new MyCanvas();
//    Dimension dim;
//    int x, y;
//    int p;
//
//    public HomeWorkPickManTest() {
//        setLayout(new BorderLayout());
//        add(mc);
//        setSize(1500, 1000);
//        setVisible(true);
//
//        mc.addKeyListener((KeyListener) this);//키이벤트 리스너 등
//    }
//
//    public void setCanavsSize()
//    {
//        dim = mc.getSize();
//        x = (int) (dim.getWidth() / 2 - 25);
//        y = (int) (dim.getHeight() / 2 - 25);
//    }
//
//    public void run(){
//        while (true)
//        {
//            mc.repaint();
//            if (p == 0)
//            {
//                p++;
//            }
//            else
//            {
//                p--;
//            }
//            x -= 5;
//            if (x <= -50) x = (int) dim.getHeight();
//            if (x <= 0)
//                try {
//                    Thread.sleep(200);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            if(p%2==0){
//                p++;
//            }else {
//                p--;
//            }
//            if(p==0 || p==1)
//            {
//                x-=5;
//                if(x<=-50)
//                {
//
//                }
//            }
//        }
//    }
//
//    public class MyCanvas extends Canvas {
//        public MyCanvas() {
//
//            img = Toolkit.getDefaultToolkit().getImage("img/Man.jpg");
//        }
//
//        public void paint(Graphics g) {
//            //원본 이미지 그림을 그린다.
//
//            int imgW = 50;
//            int imgH = 50;
//
//            int p = 0;
//
//            g.drawImage(img, x, y, x + 50, y + 50, p * 50, 0, p * 50 + 50, 50, this);
//        }
//    }
//
//    public void update(Graphics g) {
//        paint(g);
//    }
//
//
//    public void keyReleased(KeyEvent ke)
//    {
//
//        int code = ke.getKeyCode();
//        if(code == KeyEvent.VK_LEFT || code == KeyEvent.VK_A){
//            p=0;
//        }else if(code == KeyEvent.VK_RIGHT || code==KeyEvent.VK_D)
//        {
//            p=2;
//        }
//        else if(code ==KeyEvent.VK_UP || code==KeyEvent.VK_W)
//        {
//            p=4;
//        }
//        else if(code ==KeyEvent.VK_DOWN || code==KeyEvent.VK_S)
//        {
//            p=6;
//        }
//    }
//
//}
