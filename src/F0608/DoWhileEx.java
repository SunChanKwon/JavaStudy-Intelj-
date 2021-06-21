package F0608;

import java.util.Scanner;

public class DoWhileEx {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("돈을 입력해주세요");
        int money;
        int result1;
        int Option = 0;
        int fivethwon = 0;
        int thouwon1=0;
        int thouwon2=0;
        int hunwon=0;
        boolean state=true;
        do {
            money = scan.nextInt();//123000;

            System.out.print("입력한 금액: " + money + "\n");
            while(money / 50000 > 0){
                money = money - 50000;
                fivethwon++;
            }
            while(money / 10000 > 0){
                money = money - 10000;
                thouwon1++;
            }
            while(money / 1000 > 0){
                money = money - 1000;
                thouwon2++;
            }
            while(money / 100 > 0){
                money = money - 100;
                hunwon++;
            }
            System.out.printf("오만원 사용 횟수:%d\n",fivethwon);
            System.out.printf("  만원 사용 횟수:%d\n",thouwon1);
            System.out.printf("  천원 사용 횟수:%d\n",thouwon2);
            System.out.printf("  백원 사용 횟수:%d\n",hunwon);

            System.out.printf("남은 금액:%d\n",money);

            System.out.println("1번 계속 실행 2번 종료");
            Option = scan.nextInt();
        } while(Option==2);
      //  System.exit(1);
    }
}
