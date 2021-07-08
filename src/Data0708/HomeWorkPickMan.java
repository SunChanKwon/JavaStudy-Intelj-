package Data0708;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class HomeWorkPickMan extends JFrame{
    JPanel pane = new JPanel();
    Image img;

   MyCanvas mc = new MyCanvas();
    public HomeWorkPickMan() {
        add(BorderLayout.NORTH, pane);
        add(mc);

        setSize(1500, 1000);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public class MyCanvas extends Canvas{
        public MyCanvas() {

            img = Toolkit.getDefaultToolkit().getImage("img/Man.jpg");
        }
        public void paint(Graphics g) {
            //원본 이미지 그림을 그린다.

            int imgW = img.getWidth(this);
            int imgH = img.getHeight(this);

            int count = 0;
                count += 10;
                if (count == 0) {
                    g.drawImage(img, 0, 0, 200, 200, 0, 0, 50, 50, this);
                } if (count == 10) {
                    g.drawImage(img, 0, 0, 400, 400, 0, 0, 100, 100, this);
                } if (count == 20) {
                    g.drawImage(img, 0, 0, 600, 600, 0, 0, 150, 150, this);
                } if (count == 30) {
                    g.drawImage(img, 0, 0, 800, 800, 0, 0, 200, 200, this);
                } if (count == 40) {
                    g.drawImage(img, 0, 0, 1000, 1000, 0, 0, 250, 250, this);
                } if (count == 50) {
                    g.drawImage(img, 0, 0, 1200, 1200, 0, 0, 300, 300, this);
                } if (count == 60) {
                    g.drawImage(img, 0, 0, 1400, 1400, 0, 0, 350, 350, this);
                } if (count == 70) {
                    g.drawImage(img, 0, 0, 1600, 1600, 0, 0, 400, 400, this);
                }
        }

        public void update(Graphics g)
        {
            paint(g);
        }
    }
    public static void main(String[] args) {
        new HomeWorkPickMan();

    }

}
