package F0604;

import java.util.Scanner;

public class IFTEST {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int number=0;

        System.out.printf("숫자를 입력해서 짝수인지 홀수 인지 판단하세요");

        scan.nextInt();

        if(number/2==0)
        {
            System.out.printf("홀수");
        }
        else
        {
            System.out.printf("짝수");
        }
    }
}
