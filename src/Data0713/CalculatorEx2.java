package Data0713;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorEx2 extends JPanel implements ActionListener{
	Font fnt = new Font("����ü", Font.BOLD,25);
	JTextField tf = new JTextField("0.0");
	JPanel allBtnPane = new JPanel(new BorderLayout());
		JPanel northPane = new JPanel(new GridLayout(1,3));
		JPanel centerPane = new JPanel(new GridLayout(4,4));
	
	//��ư��� list
	String btnStr[] = {"BackSpace","Clear","End","7","8","9","+"
			,"4","5","6","-","1","2","3","*","0",".","=","/"};
	double result; //0.0 ��������
	String operator;//����
	
	public CalculatorEx2() {
	//	setTitle("����");
		setLayout(new BorderLayout());
		
		add(BorderLayout.NORTH, tf);
		tf.setHorizontalAlignment(JTextField.RIGHT);
		tf.setFont(fnt);
		
		add(allBtnPane);
		allBtnPane.add(BorderLayout.NORTH, northPane);
		allBtnPane.add(BorderLayout.CENTER, centerPane);
		//��ư�� JPanel�� �߰�
		for(int i=0; i<btnStr.length; i++) {
			JButton btn = new JButton(btnStr[i]);
			btn.setFont(fnt);
			btn.setBackground(Color.LIGHT_GRAY);
			if(i<=2) {
				northPane.add(btn);
			}else {
				centerPane.add(btn);
			}
			//��ư���� �̺�Ʈ ���
			btn.addActionListener(this);
		}
			
	//	setSize(500, 350);
	//	setVisible(true);
	//	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent ae) {
		JButton event = (JButton)ae.getSource();
		String btnLbl = event.getText();
		
		
		switch(btnLbl) {
		case "End" : 
			System.exit(0);
			break;
		case "0":	case "1":	case"2":	case"3":	case"4":
		case "5":	case "6":	case"7":	case"8":	case"9":
			inNumber(btnLbl);
			break;
		case "BackSpace":
			setBackSpace();
			break;
		case ".":
			setPoint();
			break;
		case "+":	case "-":	case "*":	case"/":
			setResultOperator(btnLbl);
			break;
		case "=":
			setResult();
			break;
		case "Clear":
			setClear();
		}
	}
	public void setClear() {
		result = 0.0;
		operator = null;
		tf.setText("0.0");
	}
	// = �����ڰ� ���õǸ� result, operator, tf���� ����Ѵ�.
	public void setResult() {
		double num2 = Double.parseDouble(tf.getText());
		calcu(num2);
		//����� tf�� �����ֱ� 
		tf.setText(String.valueOf(result));
		operator = null;			
	}
	//+,-,*,/�����ڸ� ���� �Ͽ�����
	public void setResultOperator(String btnLbl) {
		double second = Double.parseDouble(tf.getText());
		if(operator==null) {//ó������ ������ ����
			result=second;//tf���� ����
		}else {
			//�̹� ������ ������ �����Ȱ��� tf�� ���� ����Ͽ� result�� ����
			calcu(second);
		}
		operator = btnLbl;//������ ����
		tf.setText("");//tf �� ���� �ʱ�ȭ�Ѵ�.
	}
	public void calcu(double second) {
		switch(operator) {
		case "+": result = result + second;break;
		case "-": result = result - second;break;
		case "*": result = result * second;break;
		case "/": result = result / second;break;
		}
	}
	
	//�Ҽ��� ��ư�� ���õǾ�����
	public void setPoint() {
		String str = tf.getText();
		int idx = str.indexOf("."); //.�� ������ index��ġ�� ���ϰ� ������ -1�� �����Ѵ�.
		if(idx==-1) {
			tf.setText(str+ ".");
		}
		
	}
	//�齺���̽� ��ư ���õǾ�����
	public void setBackSpace() {
		String str = tf.getText();//4567
		int len = str.length();//4
		String cutStr = str.substring(0, len-1);//456
		tf.setText(cutStr);
	}
	//���ڹ�ư ���õǾ�����
	public void inNumber(String btnLbl) {
		String tfTxt = tf.getText();
		if(tfTxt.equals("0.0")) {//�ʱⰪ 0.0�϶��� ��� �̺�Ʈ�� �߻��� ��ư�� ���� ����
			tf.setText(btnLbl);
		}else {
			tf.setText(tfTxt+btnLbl);
		}
	}
}
