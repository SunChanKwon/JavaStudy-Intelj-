package com.array;

import java.util.Arrays;

public class ArrayCopytest {
    public static void main(String[] args) {

        int num[] = {0,1,2,3,4,5,6};

        int target[] = new int[10];

        //arraycopy(Object src,  int srcPos,   Object dest,    int destPos,int lenth)
                    //원본 데이터  데이터 시작지점  복사할곳의 배열명  index

        System.arraycopy(num,2,target,5,3);

        for(int i =0; i< num.length; i++)
        {
            System.out.println("target["+i+"]="+num[i]);
        }
        System.out.println("-------------------------");
        for(int a =0; a< target.length; a++)
        {
            System.out.println("target["+a+"]="+target[a]);
        }
    }
}
