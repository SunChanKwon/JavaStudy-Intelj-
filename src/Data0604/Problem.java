package Data0604;

import java.util.Scanner;

public class Problem {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.printf("숫자 2개가 양수일떄 사칙연산을 실행됩니다.\n");

        System.out.printf("첫번쨰 숫자입력해주세요.\n");
        int data1 = scan.nextInt();

        System.out.printf("두번쨰 숫자입력해주세요.\n");
        int data2 = scan.nextInt();

        if(data1 > 0 && data2 > 0)
        {
            System.out.printf("신난다 여러분 두수 모두 양수 입니다 축카포카카\n");
            System.out.printf("사칙연산을 실행합니다 하고싶은 연산를 골라주세요\n");
            System.out.printf("1. 덧셈 2. 뺼셈 3. 곱셈 4. 나눗셈 5.전부다 \n");

            int Option = scan.nextInt();
            if(Option==1)
            {
                System.out.printf("덧셈 출력   : %d + %d = %d\n",data1,data2,data1+data2);
            }
            if(Option==2)
            {
                System.out.printf("뺼셈 출력    : %d - %d = %d\n",data1,data2,data1-data2);
            }
            if(Option==3)
            {
                System.out.printf("곱셈 출력   : %d * %d = %d\n",data1,data2,data1*data2);
            }
            if(Option==4)
            {
                System.out.printf("나눗셈 출력 : %d / %d = %d\n",data1,data2,data1/data2);
            }
            if(Option==5)
            {
                System.out.printf("전부다 출력합니다\n");
                System.out.printf("덧셈 출력 : %d + %d = %d\n",data1,data2,data1+data2);
                System.out.printf("뺼셈 출력 : %d - %d = %d\n",data1,data2,data1-data2);
                System.out.printf("곱셈 출력  :%d * %d = %d\n",data1,data2,data1*data2);
                System.out.printf("나눗셈 출력 :%d / %d = %d\n",data1,data2,data1/data2);
            }
        }
        else
        {
            if(data1 <0 && data2 <0)
            {
                System.out.printf("첫번쨰,두번쨰 값 둘다 잘못 입력했어요 조심해주세요\n");
            }

            if(data1 <0)
            {
                System.out.printf("첫번쨰 값을 잘못 입력했어요 조심해주세요\n");
            }
            else
            {
                System.out.printf("두번쨰 값을 잘못 입력했어요 조심해주세요\n");
            }

        }

    }
}
