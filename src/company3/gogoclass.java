package com.company3;

public class gogoclass {
    public static void main(String[] args)
    {
        int i=0;
        int j=0;
        int k=0;

        for(i =0; i<9; i=+3)
        {
            for(j=1; j<10; j++)
            {
                for(k=i;k<i+3;k++)
                {
                    System.out.printf("%3d * %3d = %3d",k,j,k*j);
                }
                System.out.printf("\n");
            }
            System.out.printf("\n");
        }
    }
}
