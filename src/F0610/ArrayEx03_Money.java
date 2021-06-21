package F0610;

import java.util.Scanner;
//-오류 찾는다
public class ArrayEx03_Money {
    public static void main(String[] args) {
        int data[] = new int[7];


        data[0] = 50000;     //오만원
        data[1] = 10000; //만원 = 50000/5
        data[2] = 5000; //오천원 = 10000/2
        data[3] = 1000; //천원 =  5000/5
        data[4] = 500; //오백원 = 1000/2
        data[5] = 100; // 백원 = 500/5
        data[6] = 10; //십원

        do {
            Scanner scan = new Scanner(System.in);
            System.out.println("돈을 입력해주세요");

            int fivethwon = 0;
            int thouwon1 = 0;
            int thouwon2 = 0;
            int fivewon = 0;
            int hunwon = 0;
            int ten = 0;
            int Option = 0;


            int money = scan.nextInt();
            System.out.printf("입력하신 돈 : %d\n", money);

            for (int i = 0; i < data.length; i++) {

                while (money / data[i] > 0) {
                    money = money - data[i];
                    fivethwon++;
                    while (money / data[i] > 0) {
                        money = money - data[i];
                        thouwon1++;
                        while (money / data[i] > 0) {
                            money = money - data[i];
                            thouwon2++;
                            while (money / data[i] > 0) {
                                money = money - data[i];
                                fivewon++;
                                while (money / data[i] > 0) {
                                    money = money - data[i];
                                    hunwon++;
                                    while (money / data[i] > 0) {
                                        money = money - data[i];
                                        ten++;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            System.out.printf("오만원 사용 횟수:%d\n", fivethwon);
            System.out.printf("  만원 사용 횟수:%d\n", thouwon1);
            System.out.printf("  천원 사용 횟수:%d\n", thouwon2);
            System.out.printf("  오백원 사용 횟수:%d\n", fivewon);
            System.out.printf("  백원 사용 횟수:%d\n", hunwon);
            System.out.printf("  십원 사용 횟수:%d\n", ten);

            System.out.println("-------");

            System.out.println("1번 계속 실행 2번 종료");
            Option = scan.nextInt();
            if (Option == 2) {
                System.exit(0);
            }
        } while (true);
    }
}
