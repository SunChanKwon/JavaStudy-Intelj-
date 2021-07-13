package Data0713;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SwingCalendar2 extends JPanel implements ActionListener{
	Font fnt = new Font("����ü",Font.BOLD,20);
	Calendar now = Calendar.getInstance();
	//Frame-North
		JPanel frmNorth = new JPanel();
			JButton prevMonth = new JButton("��");
			JButton nextMonth = new JButton("��");
			JLabel yearLbl = new JLabel("��");
			JLabel monthLbl = new JLabel("��");
			JComboBox<Integer> yearCombo = new JComboBox<Integer>();
			DefaultComboBoxModel<Integer> yearModel = new DefaultComboBoxModel<Integer>();
			
			JComboBox<Integer> monthCombo = new JComboBox<Integer>();
			DefaultComboBoxModel<Integer> monthModel = new DefaultComboBoxModel<Integer>();
		//Frame - center
		JPanel frmCenter = new JPanel(new BorderLayout());
			JPanel weekTitlePane = new JPanel(new GridLayout(1,7));
			JPanel dayPane = new JPanel(new GridLayout(0,7));
			
	public SwingCalendar2() {
		setLayout(new BorderLayout());
		
		//Frame-North
		prevMonth.setFont(fnt);
		nextMonth.setFont(fnt); 
		yearLbl.setFont(fnt);
		monthLbl.setFont(fnt);
		yearCombo.setFont(fnt);
		monthCombo.setFont(fnt);
		
		frmNorth.add(prevMonth);
		
		//�⵵����Ʈ
		int nowYear = setNowYear();
		setNowYear();
		yearCombo.setModel(yearModel);
		yearCombo.setSelectedItem(nowYear);//����⵵ ����
		frmNorth.add(yearCombo);
		
		frmNorth.add(yearLbl);
		// ������Ʈ
		int nowMonth = setNowMonth();
		monthCombo.setModel(monthModel);
		monthCombo.setSelectedItem(nowMonth+1);
		frmNorth.add(monthCombo);
		
		frmNorth.add(monthLbl);
		frmNorth.add(nextMonth);
		
		add(BorderLayout.NORTH, frmNorth);
		
		//Frame - Center
		frmCenter.add(BorderLayout.NORTH, weekTitlePane);
		frmCenter.add(dayPane);
		add(frmCenter);
		
		setWeekTitle();//���ϸ� �����
		
		//��¥
		//�ش����1�Ͽ� ���� ���� 
		int week = getOneDayWeek(nowYear,nowMonth);
		//�ش���Ǹ������� 
		int lastDay = now.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		setSpaceLabel(week);
		setDayLabel(nowYear, nowMonth, lastDay);
		
		
		//�̺�Ʈ ���
		prevMonth.addActionListener(this);
		nextMonth.addActionListener(this);
		yearCombo.addActionListener(this);
		monthCombo.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();//JButton, JComboBox
		//��ü�� � Ŭ������ �����Ǿ����� ���ϴ� ������

		// obj �� JButton���� ������ ��ü�� �´���?
		if(obj instanceof JButton) {
			if(obj == prevMonth) {//����
				setPrevMonth();
			}else if(obj == nextMonth) {//�����ʹ�ư
				setNextMonth();
			}
		}else if(obj instanceof JComboBox) {	
				setNewDate();
		}
	}
	//���ʹ�ư
	public void setPrevMonth() {
		// ���� ���õ� �޺��ڽ��� ���� �����´�.
		int y = (int)yearCombo.getSelectedItem();
		int m = (int)monthCombo.getSelectedItem();
		
		if(m==1) {// 1���̸� �⵵�� �����ϰ� ���� 12���� ����
			y--;
			m=12;
			
		}else {
			m--;
		}
		setButtonEvent(y,m);
	}
	//�����ʹ�ư
	public void setNextMonth() {
		int y = (int)yearCombo.getSelectedItem();
		int m = (int)monthCombo.getSelectedItem();
		if(m==12) {
			y++;
			m=1;
		}else {
			m++;
		}
		setButtonEvent(y,m);
	}
	
	public void setButtonEvent(int y, int m) {
		//ComboBox�� �����̺�Ʈ ����
				yearCombo.removeActionListener(this);
				monthCombo.removeActionListener(this);// ����
				yearCombo.setSelectedItem(y);
				monthCombo.setSelectedItem(m);
				setNewDate();
				yearCombo.addActionListener(this);// �ٽ� �̺�Ʈ ��� 
				monthCombo.addActionListener(this);
		
	}
	public void setNewDate() {
		int year = (Integer)yearCombo.getSelectedItem();
		int month = (int)monthCombo.getSelectedItem();
		now.set(year, month-1,1);
		//������ �ӳ�¥ ���� ���� ��� ������ �Ѵ�. 
		dayPane.removeAll();
		//�гμ����
		dayPane.setVisible(false);
		setSpaceLabel(now.get(Calendar.DAY_OF_WEEK));
		setDayLabel(year,month-1,now.getActualMaximum(Calendar.DAY_OF_MONTH));
		dayPane.setVisible(true);
	}
	//������ �߰��ϴ� ��
	public void setSpaceLabel(int w) {
		for(int i=1; i<w; i++) {
			JLabel lbl = new JLabel(" ");
			dayPane.add(lbl);
		}
	}
	//��¥�߰��ϴ� ��
	public void setDayLabel(int year, int month, int lastDay) {
		for(int day=1; day<=lastDay;day++) {
			JLabel lbl = new JLabel(String.valueOf(day), JLabel.CENTER); // ������ ��Ʈ������ �ٲ�.
			lbl.setFont(fnt);
			now.set(year,month, day);
			int week = now.get(Calendar.DAY_OF_WEEK);//����
			if(week==1) lbl.setForeground(Color.RED);
			if(week==7) lbl.setForeground(Color.BLUE);
			dayPane.add(lbl);
			
		}
	}
	//���� ���ϱ�
	public int getOneDayWeek(int y, int m) {
		now.set(y, m,1); //��¥�� 1�Ϸ� �ٲ��
		return now.get(Calendar.DAY_OF_WEEK); //����
	}
	public void setWeekTitle() {
		String weekName = "�Ͽ�ȭ�������";
		for(int i=0; i<weekName.length(); i++) {//0,1,2,3,4,5,6
			JLabel lbl = new JLabel(weekName.substring(i, i+1), JLabel.CENTER);
			lbl.setFont(fnt);
			if(i==0) lbl.setForeground(Color.RED);
			if(i==6) lbl.setForeground(Color.BLUE);
			weekTitlePane.add(lbl);
			
		}
	}
	public int setNowYear() {
		int year = now.get(Calendar.YEAR);
		//for(int y = year-100; y<=year+20; y++) {
		for(int y = year+20; y>=year-100; y--) {
			yearModel.addElement(y);
		}
		return year;
	}
	
	public int setNowMonth() {
		for(int m=1;m<=12;m++) {
			monthModel.addElement(m);
		}
		return now.get(Calendar.MONTH);
	}
}
