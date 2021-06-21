package StaticTest;

import java.util.Scanner;

public class StandardWeight {
    int age=0;//전역변수 선언
    int tall=0;//전역변수 선언
    int wegiht=0;//전역변수 선언
    int option=0;//전역변수 선언
    double index=0;

    void inputdat()
    {
        Scanner scan = new Scanner(System.in);
        System.out.printf("표준체중 기준 구하기 :\n");

        System.out.printf("나이를 입력해주세요 ^^!!\n");
         age = scan.nextInt(); //전역변수 선언

        System.out.printf("성별을 눌러주세요 1.남자 2.여자 !!\n");
         option = scan.nextInt();//전역변수 선언

        System.out.printf("현재 키를 입력해주세요 ^^!!\n");
         tall = scan.nextInt();//전역변수 선언

        System.out.printf("현재 체중을 입력해주세요 ^^!!\n");
         wegiht = scan.nextInt();//전역변수 선언
    }

    double WManwegiht35up36UP=(double)(((tall-100)*0.90)*100);
    double WoManwegiht35down=(double)(((tall-100)*0.85)*100);
    double Manwegiht36up=(double)(((tall-100)*0.95)*100);

    void Cul()
    {
        if ((age <= 35 && option == 1) || (age <= 36 && option == 2)) {
            index = 0.90;
        }
        else if((age <= 35 && option ==2))
        {
            index = 0.85;
        }
        else
        {
            index = 0.95;
        }
    }
    void CulPrint() {
            if (wegiht == 85) {
                System.out.printf("들어왔어요 ㅠㅠ ^^!!\n");
                System.out.printf("현재 체중 : %d 표준 체중 : %f\n", this.wegiht, (int)(tall-100)*index);
                System.out.printf("당신의 표준체중지수는 : %f으로 마른형에 속합니다 .\n", WManwegiht35up36UP);
            } else if (wegiht == 86 && wegiht <= 95) {
                System.out.printf("현재 체중 : %d 표준 체중 : %f\n", this.wegiht,(int)(tall-100)*index);
                System.out.printf("당신의 표준체중지수는 : %f으로 조금 마른형에 속합니다 .\n", (double) WManwegiht35up36UP);
            } else if (wegiht == 96 && wegiht <= 115) {
                System.out.printf("현재 체중 : %d 표준 체중 : %f\n", this.wegiht, (int)(tall-100)*index);
                System.out.printf("당신의 표준체중지수는 : %f으로 표준형에 속합니다 .\n", (double) WManwegiht35up36UP);
            } else if (wegiht == 116 && wegiht <= 125) {
                System.out.printf("현재 체중 : %d 표준 체중 : %f\n", this.wegiht, (int)(tall-100)*index);
                System.out.printf("당신의 표준체중지수는 : %f으로 조금 비만형에 속합니다 .\n", (double) WManwegiht35up36UP);
            } else {
                System.out.printf("현재 체중 : %d 표준 체중 : %f\n", this.wegiht, (int)(tall-100)*index);
                System.out.printf("당신의 표준체중지수는 : %f으로 비만형에 속합니다 .\n", (double) WManwegiht35up36UP);
            }
    }
    public static void main(String[] args) {
        StandardWeight we = new StandardWeight();
        we.inputdat();
        we.Cul();
        we.CulPrint();
    }
}
