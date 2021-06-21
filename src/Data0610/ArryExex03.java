package Data0610;
import java.util.Scanner;
public class ArryExex03 {
    public static void main(String[] args) {
        do {
        System.out.print("금액을 입력해주세요\n");

            Scanner scan = new Scanner(System.in);
            System.out.println("돈을 입력해주세요");
            int money=scan.nextInt();
            int result[][]={{50000,0},{10000,0},{5000,0},{1000,0},{500,0},{100,0},{10,0},{5,0},{1,0}};


            for(int row=0; row<result.length; row++)
            {
                result[row][1]= money/result[row][0];
                money-= result[row][0]*result[row][1];
            }
            for(int row=0; row<result.length; row++) {
                if (result[row][1] > 0) {
                    System.out.print(result[row][0] + "=" + result[row][1]);
                    if (result[row][0] >= 1000) {
                        System.out.println("장");
                    } else {
                        System.out.println("개");
                    }
                }
            }
        }while(true);

    }
}
