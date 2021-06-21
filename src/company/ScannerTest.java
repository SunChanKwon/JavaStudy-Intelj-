package com.company;

import java.util.Scanner;

public class ScannerTest {
    //1. 객체를 생성
    public static void main(String[] args)
    {
        Scanner scan = new Scanner((System.in));
        System.out.println("삼각형의 넓이 둘레 구하는 프로그램입니다.");
        System.out.println("1.넓이 구하기 2.둘레 구하기");
        int Option = scan.nextInt();


        System.out.println("가로를 입력해주세요");
        int xPos =scan.nextInt();

        System.out.println("세로를 입력해주세요");
        int yPos =scan.nextInt();
        int result = (Option == 1) ?  (xPos*yPos) : (xPos+yPos) * 2;
        String msg = (Option == 1) ?  "넓이" : "높이";
        System.out.println("구한것 값:"+msg + "가로: " +xPos + "세로 :" + yPos  +"결과 값:"+result);


    }
}
