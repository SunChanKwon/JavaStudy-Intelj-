package com.company;
import java.util.Scanner;

public class EX01 {

    public static void main(String[] args)
    {
        System.out.println("큰수 구하는 프로그램입니다");
        Scanner scan = new Scanner((System.in));

        System.out.println("첫번째 입력해주세요");

        int num1 = scan.nextInt();

        System.out.println("두번째 입력해주세요");
        int num2 = scan.nextInt();

        int result = (num1 > num2) ? num1 : num2;

        System.out.println("큰수는 : "+ result);

    }
}
