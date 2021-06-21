package com.company3;

public class Printfor {

    public static void main(String[] args)
    {
        for(int i=0; i<6; i++) //i=0 i=1 i=2
        {
            for(int j=6-1; j>i; j--)
            {
                System.out.print(" ");
            }
            for(int j=0; j<2*i+1; j++) //j=1 /j=3 j=5
            {
                System.out.print("*");
            }
            System.out.print("\n");
        }

    }
}
