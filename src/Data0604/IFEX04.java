package Data0604;

import java.util.Scanner;

public class IFEX04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.printf("국어 영어 수학 점수를 입력해주세요.:\n");


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

        if(avg>=90 && avg <=100)
        {
            System.out.printf("당신의 학점은: 'A'\n");
        }
        else if(avg>=80 && avg<=89)
        {
            System.out.printf("당신의 학점은: 'B'\n");
        }
        else if(avg>=70 && avg<=79)
        {
            System.out.printf("당신의 학점은: 'C'\n");
        }
        else if(avg>=60 && avg<=69)
        {
            System.out.printf("당신의 학점은: 'D'\n");
        }
        else{
            System.out.printf("당신의 학점은: 'F'\n");
            System.out.printf("낙제점수 재수강하세요\n");
        }

    }
}
