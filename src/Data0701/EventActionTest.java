package Data0701;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventActionTest extends JFrame implements ActionListener{
    JButton btn1 = new JButton("클릭하세요");
    JButton btn2 = new JButton("확인");
    public EventActionTest(){
        add(BorderLayout.NORTH,btn1);
        add(BorderLayout.SOUTH,btn2);

        setSize(500,500);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

       btn1.addActionListener(this);
       btn2.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae) {
        Object obj = ae.getSource();
        //JButton eventBtn = (JButton)ae.getSource();
        if(obj==btn1)
        {
            ggugu(7);
        }
        else if(obj==btn2)
        {
            System.exit(0);
        }
    }
//    public void actionPerformed(ActionEvent ae)
//    {
//        String event = ae.getActionCommand();
//        if(event.equals("클릭하세요"))
//        {
//            ggugu(6);
//        }
//        else if(event.equals("확인"))
//        {
//            System.exit(0);
//        }
//
//    }
public void ggugu(int dan)
{
    for(int i=2; i<10; i++)
    {
        System.out.println(dan+"*"+i+"="+(dan*i));
    }
}

    public static void main(String[] args) {
        new EventActionTest();
    }
}
