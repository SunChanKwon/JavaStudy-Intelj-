package com.company4;

import java.awt.*;
import java.util.Calendar;
import java.util.Scanner;

public class CallendarEx {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("년도=");
        int year = scan.nextInt();

        System.out.print("월=");
        int month = scan.nextInt();

        System.out.printf("\t\t%d년 %d월\n",year,month);
        System.out.println("일\t월\t화\t수\t목\t금\t토");

        Calendar data = Calendar.getInstance();
        data.set(year,month-1,1);

        int week = data.get(Calendar.DAY_OF_WEEK);

        int lastDay=31;

        switch(month)
        {
            case 4:
            case 6:
            case 9:
            case 11:
                lastDay=30; break;
            case 2:
                if(year%4==0 && year%100!=0 || year%400==0)
                {
                    lastDay=29;
                }
                else{
                    lastDay=28;
                }
        }
        for(int s=1; s<week; s++)
        {
            System.out.print(" \t");
        }
        for(int d=1; d<=lastDay; d++)
        {
            System.out.print(d+"\t");
        }
    }
}
