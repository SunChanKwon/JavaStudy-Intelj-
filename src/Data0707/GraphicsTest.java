package Data0707;

import javax.swing.*;
import java.awt.*;

public class GraphicsTest extends JFrame {

    MyCanvas canvas = new MyCanvas();
public GraphicsTest()
{
    System.out.println("GraphicsTest");
    add(canvas);
    setSize(700,700);
    setVisible(true);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
}

    public class MyCanvas extends Canvas
    {
        public MyCanvas(){
        System.out.println("MyCanvas");
        }
    }
    public void paint(Graphics g)
    {
        //그림을 글린다.
        g.drawLine(100,100,500,500);
        g.setColor(Color.red);
        g.drawLine(100,500,500,100);
        g.drawOval(200,200,300,300);
        g.drawRect(200,200,200,300);
        g.setColor(Color.green);
    }

    public static void main(String[] args) {
        new GraphicsTest();
    }
}
