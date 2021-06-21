package Data0604;

import java.util.Calendar;

public class CalendarTest {
    public static void main(String[] args) {
        Calendar now = Calendar.getInstance();// 매소드는 객체를 생성하는 메소드이다.

    int Year = now.get(Calendar.YEAR);
    int month= now.get(Calendar.MONTH);
    int day  = now.get(Calendar.DAY_OF_MONTH);
    int week = now.get(Calendar.DAY_OF_MONTH);
    int hour = now.get(Calendar.HOUR_OF_DAY);
    int minute = now.get(Calendar.MINUTE);

    String WeekStr="";
    switch(week)
    {
        case 1: WeekStr = "일";break;
        case 2: WeekStr = "월";break;
        case 3: WeekStr = "화";break;
        case 4: WeekStr = "수";break;
        case 5: WeekStr = "목";break;
        case 6: WeekStr = "금";break;
        case 7: WeekStr = "토";break;
    }
        System.out.println(now);
    }
}
