package F0604;

import java.util.Scanner;

public class SwtichTest {

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        
        System.out.printf("정수입력해주세요");


        System.out.printf("국어 점수 입력해주세요");
        int ScoreK=scan.nextInt();

        System.out.printf("영어 점수 입력해주세요");
        int ScoreE=scan.nextInt();;

        System.out.printf("수학 점수 입력해주세요");
        int ScoreM=scan.nextInt();

        int ScoreResult = ScoreK+ScoreE+ScoreM;//스코어 합산
        int avg = ScoreResult/3;

        System.out.printf("국어 점수 :%5d\n",ScoreK);
        System.out.printf("영어 점수 :%5d\n",ScoreE);
        System.out.printf("수학 점수 :%5d\n",ScoreM);
        System.out.printf("합산     :%5d\n",ScoreResult);
        System.out.printf("평균     :%5d\n",avg);


        System.out.printf('j'+"ava\n");

        int result = avg/10;
        System.out.printf("몫     :%5d\n",result);
        switch(result) //몫으로 인하여서 게임을 한다.
        {
            case 10: case 9:
            {
                System.out.printf("당신의 학점은: 'A'\n");
                break;
            }
            case 8:
            {
                System.out.printf("당신의 학점은: 'B'\n");
                break;
            }
            case 7:
            {
                System.out.printf("당신의 학점은: 'C'\n");
                break;
            }
            case 6:
            {
                System.out.printf("당신의 학점은: 'D'\n");
                break;
            }
            default:
                System.out.printf("당신의 학점은: 'F'\n");
                System.out.printf("낙제점수 재수강하세요\n");
        }
        
    }
}
