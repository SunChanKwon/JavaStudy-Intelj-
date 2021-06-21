package StaticTest;

import java.util.Calendar;
import java.util.Scanner;

public class CalendarTestEx {
    int year = 0;//2021
    int month = 0;//7
    int week = 0; //8
    int lastDay = 0;//10
    int result=0;
Calendar data = Calendar.getInstance();
    public CalendarTestEx(){

    }
    void inputdata() {
        Scanner scan = new Scanner(System.in);
        System.out.print("년도=");
        year = scan.nextInt();
        System.out.print("월=");
        month = scan.nextInt();
        System.out.printf("\t\t%d년 %d월\n", year, month);
        System.out.println("일\t월\t화\t수\t목\t금\t토");
    }

    void Getdata()
    {
       week = data.get(Calendar.DAY_OF_WEEK);
        lastDay = data.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    void GeSum()
    {
        int a=0;
        a++;
        result =a; //1
    }

    void CalCul()
    {
        for (int s = 1; s < week; s++) {
            System.out.print("\t");
        }
        //날짜 출력
        for (int d = 1; d <= lastDay; d++) {
            System.out.print(d + "\t");
            if ((d + week - 1) % 7 == 0) {//출력한 문자가 7의 배수개이면 줄바꾸기
                System.out.println();
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CalendarTestEx ca = new CalendarTestEx();
          ca.inputdata();
          ca.Getdata();
          ca.CalCul();
    }
}
