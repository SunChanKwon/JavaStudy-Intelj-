package F0608;

import java.util.Scanner;

public class While{
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("그 수에 합과 짝수, 홀수합, 3의 배수 출력");

        int rSum=0;
        int rNum1=0;
        int rNum2=0;
        int rTnum=0;
        int num=0;

        int result = scan.nextInt();
//for(int a=0; a<=10; a++)
        //while(true)//==/무한루프 for(;;;)
        do
        {
            rSum+= num;

            if(num%2==0)
            {
                rNum1+=num;
            }
            else if(num%2==1)
            {
                rNum2+=num;
            }
            if(num%3==0)
            {
                rTnum+=num;
            }
            num++;

        }while(num<=result);
        System.out.printf("입력한 값: \n",result);
        System.out.printf("합의 값: %d\n 홀수의 합 : %d\n 짝수의 합 : %d\n 3의 배수의 합 : %d\n",rSum,rNum1,rNum2,rTnum);
    }
}
