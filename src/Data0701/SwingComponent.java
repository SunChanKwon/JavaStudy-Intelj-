package Data0701;

import javax.swing.*;
import java.awt.*;

public class SwingComponent {
    JFrame frm = new JFrame("컴포넌트 연습중");
    Rectangle frmSize = new Rectangle(200,200,500,500);
    public SwingComponent()
    {
        frm.setTitle("Component");
    //JtextField 한줄의 문자열을 입력할수 있는 컴포넌트
frm.setLayout(new FlowLayout());

JTextField tf = new JTextField();
frm.add(tf);

JTextField tf2 = new JTextField("ABCDEFG",20);
        tf2.setText("123");

try{
    String str1 = tf2.getText();
    String str2 = tf2.getText(2,3);
    System.out.println("str1 -->"+str1);
    System.out.println("str1 -->"+str2);
}catch (Exception e)
{

}
frm.add(tf2);

JPasswordField pf = new JPasswordField(20);
frm.add(pf);
JTextArea ta =new JTextArea(5,30);
JScrollPane sp = new JScrollPane(ta); //스크롤기능이있는 스크롤 패널
frm.add(sp);

JCheckBox cb1 = new JCheckBox("사과");
        JCheckBox cb2 = new JCheckBox("배",true);
        frm.add(cb1);
        frm.add(cb2);

        JSlider s1 =new JSlider(JSlider.HORIZONTAL,1,10,5);
        frm.add(s1);
        frm.setBounds(frmSize);
        frm.setVisible(true);
        frm.setDefaultCloseOperation(frm.DISPOSE_ON_CLOSE);
    }
    public static void main(String[] args) {
        new SwingComponent();
    }
}
