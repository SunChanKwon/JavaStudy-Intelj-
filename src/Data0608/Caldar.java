package Data0608;
import java.util.Calendar;
import java.util.Scanner;

public class Caldar{
    public static void main(String[] args) {
        Calendar now = Calendar.getInstance();// 매소드는 객체를 생성하는 메소드이다.

        int Year = now.get(Calendar.YEAR);
        //int month= now.get(Calendar.MONTH);
        int day  = now.get(Calendar.DAY_OF_MONTH);
        int week = now.get(Calendar.DAY_OF_MONTH);
        int hour = now.get(Calendar.HOUR_OF_DAY);
        int minute = now.get(Calendar.MINUTE);

        Scanner scan = new Scanner(System.in);

        System.out.println("년도 입력 : ");
        int year = scan.nextInt();
        System.out.println("월 입력 : ");
        int month = scan.nextInt();
        int START_DAY_OF_WEEK = 0;
        int END_DAY = 0;

        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();

        System.out.println(year+"년 "+month+"월 달력\n" + "일\t월\t화\t수\t목\t금\t토");

        for(int q = 1 ; q < start.get(Calendar.DAY_OF_WEEK) ; q++) {
            System.out.print("\t");
        }

        int cnt = START_DAY_OF_WEEK - 1;
        for(int q = 1 ; q <= end.get(Calendar.DATE) ; q++) {
            System.out.print(q+"\t");
            cnt ++;
            if(cnt == 7) {
                cnt = 0;
                System.out.println("\n");  //구글링...
            }
        }
    }
}