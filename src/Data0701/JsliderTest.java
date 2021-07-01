package Data0701;

import javax.swing.*;
import java.awt.*;
import java.util.Hashtable;

public class JsliderTest extends JFrame {
    JSlider s1 = new JSlider(JSlider.HORIZONTAL,0,100,40);
    JSlider s2 = new JSlider(JSlider.VERTICAL,0,100,50);

    public JsliderTest()
    {
        s1.setMajorTickSpacing(10);//주눈금표시
        s1.setMajorTickSpacing(2);//보조눈금
        s1.setPaintTicks(true);
        s1.setPaintLabels(true);


        Hashtable<Integer,JLabel> ht = new Hashtable<Integer,JLabel>();
        ht.put(0,new JLabel("하"));
        ht.put(50,new JLabel("중"));
        ht.put(100,new JLabel("상"));
        s2.setMajorTickSpacing(10);//눈금간격
        s2.setLabelTable(ht);//사용자정의 라벨성정
        s2.setPaintTicks(true);//눈금보이기
        s2.setPaintLabels(true);//라벨보이기



        add(BorderLayout.NORTH,s1);
        add(BorderLayout.WEST,s2);

        setSize(500,500);
        setVisible(true);
    }

    public static void main(String[] args) {
        new JsliderTest();
    }
}
