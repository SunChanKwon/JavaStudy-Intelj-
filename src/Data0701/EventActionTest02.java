package Data0701;

import javax.swing.*;
import java.awt.*;

public class EventActionTest02 extends JFrame{
    JButton okBtn = new JButton("OK");
    JLabel lbl = new JLabel("jjj",JLabel.CENTER);
    public EventActionTest02(){
        add(BorderLayout.NORTH,okBtn);
        add(lbl);

        setSize(500,500);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        okBtn.addActionListener(new EventProcess(lbl)); //위치를 알려줘야된다.
    }

    public static void main(String[] args) {
        new EventActionTest02();
    }
}
