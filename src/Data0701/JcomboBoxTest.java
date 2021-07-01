package Data0701;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

public class JcomboBoxTest extends JFrame implements ItemListener {
    JPanel pane = new JPanel();
    JComboBox<String> cb1 = new JComboBox<String>();
    JComboBox<String> cb2,cb3,cb4;
    Color clr[] = {Color.red,Color.blue,Color.green,Color.white,Color.black};
    JLabel lbl = new JLabel("선택값이 표시되는 곳",JLabel.CENTER);
    public JcomboBoxTest()
    {
        add(BorderLayout.NORTH,pane);
        pane.add(cb1);

        lbl.setOpaque(true); //투명처리 해제해준다.
        add(lbl);
        cb1.addItem("자바");
        cb1.addItem("스프링");
        cb1.addItem("JSP");

        String comboList[] = {"RED","BLUE","GREEN","WHITE","BLACK"};
        //리스트에있는 컬러데이형 변수에 인덱스가 바뀜
        cb2 = new JComboBox(comboList);
        pane.add(cb2);

        Vector<String> v = new Vector<String>();
        v.add("AAAAA");
        v.add("BBBBB");
        v.add("CCCCC");
        cb3 = new JComboBox(v);
        pane.add(cb3);

        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
        model.addElement("장미");
        model.addElement("국화");
        model.addElement("튤립");
        cb4 = new JComboBox<String>(model);
        pane.add(cb4);
        
        setSize(500,500);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        cb2.addItemListener(this);
        cb4.addItemListener(this); //아이템을 등록하면 바로 오버로딩으로 만들어진 곳으러 값을 넣어줌
    }
//--
    public  void itemStateChanged(ItemEvent ie){
       JComboBox event = (JComboBox)ie.getSource(); // 형변환해서 넣어준다.
        if(event.equals(cb2))
        {
            int idx=cb2.getSelectedIndex();
            lbl.setBackground(clr[idx]);
        }
        else if(event.equals(cb3))
        {
            lbl.setText((String)cb4.getSelectedItem());
        }

    }
    public static void main(String[] args) {
        new JcomboBoxTest();
    }
}
