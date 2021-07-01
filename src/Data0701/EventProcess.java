package Data0701;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventProcess implements ActionListener {
    JLabel lbl;
    public EventProcess(){

    }
    public EventProcess(JLabel lbl)
    {
        this.lbl=lbl;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
    lbl.setText("이벤트가 발생함.....");
    }
}
