package com.company;

import java.util.Scanner;

public class EX02 {

    public static void main(String[] args)
    {
        System.out.println("100~200 이내 값을 입력해주세요");
        Scanner scan = new Scanner((System.in));

        int num1 = scan.nextInt();

        System.out.println("입력한 값:"+num1);

        int result = (num1 > 100 && num1 <200) ? num1 : 0;

        System.out.println(+result);

    }
}
