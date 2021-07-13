package Data0713;

import javax.swing.*;

public class JSplitPaneEx extends JFrame {
    JSplitPane spHori,spClockCalendar,spCalcu,spPack;
    DigitalClock3 dc = new DigitalClock3(0,0);        //객체로 만든다
    SwingCalendar2 swingCal = new SwingCalendar2();//객체로 만든다
    CalculatorEx2 cal = new CalculatorEx2();
    PackMan2 pm = new PackMan2();
    ImageIcon ii = new ImageIcon("img/3.jpg");
    JLabel lbl = new JLabel(ii);
    public  JSplitPaneEx(){

        spClockCalendar = new JSplitPane(JSplitPane.VERTICAL_SPLIT,dc,swingCal);
        spCalcu = new JSplitPane(JSplitPane.VERTICAL_SPLIT,spClockCalendar,spCalcu);

        spPack= new JSplitPane(JSplitPane.VERTICAL_SPLIT,lbl,pm);

        spHori = new JSplitPane(JSplitPane.VERTICAL_SPLIT,spCalcu,spPack);

        add(spHori);
        setSize(1200,1000);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);

        //팩맨 설정
        pm.packmanStart(pm);
    }

    public static void main(String[] args) {
        new JSplitPaneEx();
    }
}
