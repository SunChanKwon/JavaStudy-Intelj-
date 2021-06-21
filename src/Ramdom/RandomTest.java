package com.Ramdom;

import java.util.Random;

public class RandomTest {
    public static void main(String[] args) {

        int data[] = new int[100];
        int sum=0;
        int max=0;
        int min=0;
        for(int i=0; i<data.length; i++)
        {
            data[i] = (int)(Math.random()*1000)+1;
            System.out.println(data[i]);
        }

        for(int b=0; b<data.length; b++)
        {
            sum+=data[b];
            if(max<data[b])
            {
                max=data[b];
            }
            if(min>data[b])
            {
                min=data[b];
            }

        }
        int ave = sum/data.length;
        System.out.println("합   :"+sum);
        System.out.println("제일 큰값:"+max);
        System.out.println("제일 작은값:"+min);
        System.out.println("평균은:"+ave);
    }
}
