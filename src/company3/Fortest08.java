package com.company3;

import java.util.Scanner;

public class Fortest08 {
    public static void main(String[] args) {
        Scanner scan = new Scanner((System.in));
        double result=0;
        int xPos=0;
        int yPos=0;
        int radius=0;
        double PI=3.14;
        for (; ; ) {
            System.out.println("1.넓이 구하기 2.원의 넓이 구하기 3.를 입력시 프로그램이 종료 됩니다.\n");
            int Option = scan.nextInt();

            if(Option == 1)
            {
                System.out.println("삼각형의 넓이 구하기\n");
                System.out.println("가로를 입력해주세요\n");
                 xPos = scan.nextInt();

                System.out.println("세로를 입력해주세요\n");
                 yPos = scan.nextInt();
                result = (xPos * yPos);
                System.out.println("구한것 값:" + "가로: " + xPos + "세로 :" + yPos + "결과 값:" + (int)(result));
            }
            else if(Option == 2)
            {
                System.out.println("원의 넓이 구하기\n");
                System.out.println("반지름을 입력해주세요\n");
                radius =scan.nextInt();
                result =radius * radius * PI;
                System.out.println("구한것 값:" + "반지름: " + radius + "결과 값:" + result);
            }

            if(Option==3)
            {
                System.out.println("프로그램 종료 되었습니다\n");
                System.exit(0);
            }

        }
    }
}
