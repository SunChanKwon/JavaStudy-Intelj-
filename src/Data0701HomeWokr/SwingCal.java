package Data0701HomeWokr;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;


public class SwingCal extends JFrame implements ActionListener {

    Calendar now=Calendar.getInstance();
    int year=now.get(Calendar.YEAR);
    int month=now.get((Calendar.MONTH)-1);
    int date=now.get(Calendar.DATE);
    int week = now.get(Calendar.DAY_OF_WEEK);
    int lastDate = now.getActualMaximum(Calendar.DAY_OF_MONTH);

    //시간값 알아오기 먼저 셋팅하기


    JLabel JMonth = new JLabel("월"); //라벨로 설정해주기기
    JLabel JYear = new JLabel("년");

    JComboBox<Integer> Boxyear= new JComboBox<Integer>();
    DefaultComboBoxModel<Integer> yearModel = new DefaultComboBoxModel<Integer>();
    JComboBox<Integer> BoxMonth= new JComboBox<Integer>();
    DefaultComboBoxModel<Integer> monthModel = new DefaultComboBoxModel<Integer>();

    JPanel MainPane = new JPanel(); //맨위에 화면
    JPanel MPanel = new JPanel(new BorderLayout());

    JPanel SPanel = new JPanel(new GridLayout(1, 7));//달력출력

    String DayStr[] = {"일", "월", "화", "수", "목", "금", "토"};
    String MonthStr[] = {"1월", "2월", "3월", "4월", "5월", "6월", "7월","8월","9월","10월","11월","12월"};
    JPanel datePane = new JPanel(new GridLayout(0, 7));

    public SwingCal(){

        for(int i=year-100; i<=year+50; i++){
            yearModel.addElement(i);
        }
        for(int i=1; i<=12; i++){
            monthModel.addElement(i);
        }

        BoxMonth.setModel(monthModel);
        Boxyear.setModel(yearModel);
        Boxyear.setSelectedItem(year);	//현재 년도 선택
        BoxMonth.setSelectedItem(month);	//현재 월 선택

        MainPane.add(Boxyear);
        MainPane.add(JYear);
        MainPane.add(BoxMonth);
        MainPane.add(JMonth);

        add(MainPane, "North");
        MainPane.setBackground(new Color(200, 200, 200));

        //Center

        for(int i=0; i<DayStr.length; i++){

            JLabel lbl = new JLabel(DayStr[i], JLabel.CENTER);

            SPanel.add(lbl);
        }

        PrintDay(year,month);

        MPanel.add(datePane, "Center");
        add(MPanel, "Center");

        setVisible(true);
        setSize(500,500);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    public void PrintDay(int year, int month){

        now.set(year, month, 1);
        for(int i=1; i<week; i++){
            datePane.add(new JLabel(" "));
        }

        for(int i=1; i<=lastDate; i++){
            JLabel lbl = new JLabel(String.valueOf(i), JLabel.CENTER);
            now.set(year, month, i);
            int outWeek = now.get(Calendar.DAY_OF_WEEK);
            datePane.add(lbl);

        }

    }

    public void actionPerformed(ActionEvent Ac)//이벤트 관련들어오기
    {

    }
    public static void main(String[] args) {
        new SwingCal();
    }
}
