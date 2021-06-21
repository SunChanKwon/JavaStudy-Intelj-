package Data0608;

import java.util.Scanner;

public class Di2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("입력받아서 출력할 갯수를 입력해주세요");
        int result = scan.nextInt();

        int j = 0;
        int i = 0;
        char ab = 'A';

        for (i = 1; i <= result/2; i++) {
            for (j = 1; j <= result/2 - i; j++) {
                System.out.print(" "); //공백출력
            }
            for (j = 1; j <= i; j++) {
                System.out.printf("%c", ab);
                if(ab==90)
                {
                    ab='A';
                }
                else
                {
                    ab++;
                }
            }
            for (j = 2; j <= i; j++) {
                System.out.printf("%c", ab);
                if(ab==90)
                {
                    ab='A';
                }
                else
                {
                    ab++;
                }
            }
            System.out.println();
        }
            int step =2;
        for (i = 0; i <= result/2; i++) {
            for (j = 1; j <= i; j++) {
                System.out.print(" "); //공백출력
            }
            for (j = 1; j <= result/2 - i; j++) {
                System.out.printf("%c", ab);
                if(ab==90)
                {
                    ab='A';
                }
                else
                {
                    ab++;
                }
            }
            for (j = result/2; j >= i; j--) {
                System.out.printf("%c", ab);
                if(ab==90)
                {
                    ab='A';
                }
                else
                {
                    ab++;
                }
            }
            System.out.println();
        }

    }
}