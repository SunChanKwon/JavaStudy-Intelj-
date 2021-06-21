package com.array;

import com.company.Main;

public class StringArray {

    public static void main(String[] args) {
        int num[] = new int[5];

        String name[] = new String[5];

        num[0] = 0;
        num[1] = 10;
        num[2] = 100;
        name[1] = "홍길동";

        for(int i=0; i< num.length; i++)
        {
            System.out.printf("%d\n",num[i]);
        }
        System.out.println("------------");
        int [] data2 = new int[]{20,65,75,5,87,2};

        for(int i=0; i< data2.length; i++)
        {
            System.out.printf("%d\n",data2[i]);
        }
        System.out.println("------------");
        int dat3[] = {8,7,5,37,75};
        for(int i=0; i<dat3.length; i++)
        {
            System.out.println("data3["+i+"]="+dat3[i]);
        }
        System.out.println("------------");
    }

}
