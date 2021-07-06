package Data0706;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class SwingCalendar extends JFrame implements ActionListener {
    Calendar now =  Calendar.getInstance();
    Font fnt = new Font("굴림체",Font.BOLD, 20);
    JPanel frmNorth = new JPanel();
    JButton prevMonth = new JButton("<");
    JButton nextMonth = new JButton(">");
    JLabel yearLbl = new JLabel("년");
    JLabel monthLbl = new JLabel("월");

    JComboBox<Integer> yearCombo = new JComboBox<Integer>();
    DefaultComboBoxModel<Integer> yearModel = new DefaultComboBoxModel<Integer>();

    JComboBox<Integer> monthCombo = new JComboBox<Integer>();
    DefaultComboBoxModel<Integer> monthModel = new DefaultComboBoxModel<Integer>();

    //center 달력 출려하기
    JPanel frmCenter = new JPanel(new BorderLayout());
    JPanel weekTitlePane = new JPanel(new GridLayout(1,7));
    JPanel dayPane = new JPanel(new GridLayout(0,7));
    public SwingCalendar(){
        super("계산기");

        prevMonth.setFont(fnt);frmNorth.setFont(fnt);prevMonth.setFont(fnt);nextMonth.setFont(fnt);yearLbl.setFont(fnt);monthLbl.setFont(fnt);

        frmNorth.add(prevMonth); //버튼 추가
        int nowyear = setNowYear();

        yearCombo.setModel(yearModel);
        yearCombo.setSelectedItem(nowyear);
        frmNorth.add(yearCombo);
        frmNorth.add(yearLbl);

        //월리스트
        int nowMonth=setNowMonth();
        monthCombo.setModel(monthModel);
        monthCombo.setSelectedItem(nowMonth+1);
        frmNorth.add(monthCombo);
        frmNorth.add(monthLbl);
        frmNorth.add(nextMonth);

        add(BorderLayout.NORTH,frmNorth);//추가된 사항을 맨위에 사항을 추가해줌

        frmCenter.add(BorderLayout.NORTH,weekTitlePane); //북쪽에 셋팅 먼저해주기
        frmCenter.add(dayPane);//날짜 셋팅해주기
        add(frmCenter); //그리고 센터에 추가해주기

        setWeekTitle(); //요일함수 호출

        //날짜
        //해당월의 1월에 대한 요일
        int week = getOneDayWeek(nowyear,nowMonth);
        //해달월의 마지막날
        int lastDay = now.getActualMaximum(Calendar.DAY_OF_MONTH);

        setSpaceLabel(week);
        setDayLable(nowyear,nowMonth,lastDay);
        //
        setSize(400,300);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        prevMonth.addActionListener(this);
        nextMonth.addActionListener(this);
        yearCombo.addActionListener(this);
        monthCombo.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent ae)//이벤트 관련들어오기
    {
        Object obj = ae.getSource();
        //소스를 구별해야한다.
        //객체가 어떤 클래스로 생성되었늕 비교하는 연산자
        if(obj instanceof JButton) //왼쪽에 객체 오른쪽에 클래스
        {
            if (obj == prevMonth) {
                System.out.println("버튼 눌렀어");
                setPrevMonth();
            }
            if (obj == nextMonth)
            {
              setNextMonth();
            }


        }
        else if(obj instanceof JComboBox)
        {
            setNewDate();
        }
    }
    public void setNextMonth(){
        int y = (int)yearCombo.getSelectedItem();
        int m = (int)monthCombo.getSelectedItem();

        if(m==12)
        {
            y++;
            m=1;
        }
        else
        {
            m++;
        }
        setButtonEvent(y,m);
    }
    public void setPrevMonth(){
        int y = (int)yearCombo.getSelectedItem();
        int m = (int)monthCombo.getSelectedItem();

        if(m==1)
        {
            y--;
            m=12;
        }
        else
        {
            m--;
        }
        setButtonEvent(y,m);
    }
    public void setButtonEvent(int y,int m)
    {
        yearCombo.removeActionListener(this);
        monthCombo.removeActionListener(this);
        yearCombo.setSelectedItem(y);
        monthCombo.setSelectedItem(m);
        setNewDate();
        yearCombo.addActionListener(this);
        monthCombo.addActionListener(this);
    }
    public void setNewDate(){
        int year = (Integer) yearCombo.getSelectedItem();
        int month = (int)monthCombo.getSelectedItem();
        now.set(year,month-1,1);
        //기존의 날짜 라벨을 전부 모두 지운다.

        dayPane.removeAll();
        dayPane.setVisible(false);
        setSpaceLabel(now.get(Calendar.DAY_OF_WEEK));
        setDayLable(year,month-1,now.getActualMaximum(Calendar.DAY_OF_MONTH));
        dayPane.setVisible(true);
    }
    public void setDayLable(int year,int month,int lastDay)
    {
        for(int day=1; day<lastDay; day++)
        {
            JLabel lbl= new JLabel(String.valueOf(day),JLabel.CENTER);
            lbl.setFont(fnt);
            now.set(year,month,day);
            int week = now.get(Calendar.DAY_OF_WEEK);
            if(week==0) {
                lbl.setForeground(Color.RED);
            }
            else if (week == 6){
            lbl.setForeground(Color.BLUE);
        }
            else
            {
                lbl.setForeground(Color.BLACK);
            }
            dayPane.add(lbl);
        }
    }
    public void setSpaceLabel(int w)
    {
        for(int i=1; i<w; i++)
        {
            JLabel lbl = new JLabel(" ");
            dayPane.add(lbl);
        }
    }
    public int getOneDayWeek(int y,int m)
    {
        return now.get(Calendar.DAY_OF_WEEK);
    }
    public void setWeekTitle(){
        String weekName = "일월화수목금토";
        for(int i=0; i <weekName.length(); i++)
        {
            JLabel lbl = new JLabel(weekName.substring(i,i+1));
            lbl.setFont(fnt);
            if(i==0)
            {
                lbl.setForeground(Color.red);
            }
            else if(i==6)
            {
                lbl.setForeground(Color.BLUE);
            }
            else
            {
                lbl.setForeground(Color.black);
            }
            weekTitlePane.add(lbl);
        }
    }
    public int setNowYear(){
        Calendar now =  Calendar.getInstance();
        int year=now.get(Calendar.YEAR);
        for(int y= year-100; y<year+20; y++)
        {
            yearModel.addElement(y);
        }
        return year;
    }
    public int setNowMonth(){
        for(int m =1; m<=12; m++) {

            monthModel.addElement(m);
        }
        return now.get(Calendar.MONTH);
    }



    public static void main(String[] args) {
        new SwingCalendar();
    }
}
