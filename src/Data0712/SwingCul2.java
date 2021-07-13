package Data0712;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingCul2 extends JPanel implements ActionListener {
    JPanel MainPanel = new JPanel();
    JButton TextButton[] = new JButton[3]; //맨위에 버튼 3개
    JButton[] Button = new JButton[16];   //나머지 숫자 버튼 3개
    JPanel TextPanel= new JPanel();     //text 판넬
    JPanel NumberPanel= new JPanel();   //숫자 판넬
    final String[] Number = { "7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "-", "0", ".", "=","/" };
    final String[] Text = { "Backspace","Clear","End" };

    public SwingCul2(){

        setLayout(new BorderLayout());
        add(NumberPanel, "Center");
        TextPanel.setLayout(new GridLayout(1, 3));   //Backspace, clear, end 입력창
        NumberPanel.setLayout(new GridLayout(4, 4)); //숫자 +,-,/,* 입력창


    JLabel output = new JLabel("0", JLabel.RIGHT); //0 으로 기본적으로 초기화 해준다.

        for (int i = 0; i < Text.length; i++) {

            TextPanel.add(TextButton[i] = new JButton(Text[i]));  //순서대로 값을 집어넣음
        }

        for (int i = 0; i < Number.length; i++) {

            NumberPanel.add(Button[i] = new JButton(Number[i]));  //순서대로 값을 집어넣음
        }

   // output.setOpaque(true); //투명처리
  //       setSize(300, 300);
    add(BorderLayout.NORTH,output);
    //setVisible(true);

    //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

    public static void main(String[] args) {
        new SwingCul2();
    }

    @Override
    public void actionPerformed(ActionEvent ae) { // 버튼 눌렀을시에 오버라이딩 해주는 곳입니다.
        Object obj = ae.getSource();

    }

    String Cul(double num1, double num2)
    {
        double result=0;

        String Sresult = String.valueOf(Double.valueOf(result));


        return Sresult;
    }
}
