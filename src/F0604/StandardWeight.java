package F0604;

import java.util.Scanner;

public class StandardWeight {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.printf("표준체중 기준 :\n");
//35세 이하
        System.out.printf("나이를 입력해주세요 ^^!!\n");
        int age = scan.nextInt();

        System.out.printf("성별을 눌러주세요 1.남자 2.여자 !!\n");
        int option = scan.nextInt();

        System.out.printf("현재 키를 입력해주세요 ^^!!\n");
        int tall = scan.nextInt();

        System.out.printf("현재 체중을 입력해주세요 ^^!!\n");
        int wegiht = scan.nextInt();
        //표준체중 기준
//남자35세 이하 여자 36세 이상
        double WManwegiht35up36UP=(double)(tall-100)*0.90;
//여성 35세이하
        double WoManwegiht35down=(double)(tall-100)*0.85;
//남성 36세 이상
        double Manwegiht36up=(double)(tall-100)*0.95;  //3가지 공식을 이용

        double resultWManwegiht35up36UP=(wegiht/WManwegiht35up36UP)*100;

        double resultWoManwegiht35down=(wegiht/WoManwegiht35down)*100;
        double resultManwegiht36up=(wegiht/Manwegiht36up)*100;

        //System.out.printf("잘들어와졌다123123\n");
        if((age <= 35 && option==1) || (age <=36 && option==2))
        {
            //System.out.printf("잘들어와졌다1번");
            if(wegiht == 85)
            {
                System.out.printf("현재 체중 : %d 표준 체중 : %d\n",wegiht,WManwegiht35up36UP);
                System.out.printf("당신의 표준체중지수는 : %f으로 마른형에 속합니다 .\n",resultWManwegiht35up36UP);
            }
            else if(wegiht==86 && wegiht<=95)
            {
                System.out.printf("현재 체중 : %d 표준 체중 : %d\n",wegiht,(int)WManwegiht35up36UP);
                System.out.printf("당신의 표준체중지수는 : %f으로 조금 마른형에 속합니다 .\n",(double)resultWManwegiht35up36UP);
            }
            else if(wegiht==96 && wegiht<=115)
            {
                System.out.printf("현재 체중 : %d 표준 체중 : %d\n",wegiht,(int)WManwegiht35up36UP);
                System.out.printf("당신의 표준체중지수는 : %f으로 표준형에 속합니다 .\n",(double)resultWManwegiht35up36UP);
            }
            else if(wegiht==116 && wegiht<=125)
            {
                System.out.printf("현재 체중 : %d 표준 체중 : %d\n",wegiht,(int)WManwegiht35up36UP);
                System.out.printf("당신의 표준체중지수는 : %f으로 조금 비만형에 속합니다 .\n",(double)resultWManwegiht35up36UP);
            }
            else
            {
                System.out.printf("현재 체중 : %d 표준 체중 : %d\n",wegiht,(int)WManwegiht35up36UP);
                System.out.printf("당신의 표준체중지수는 : %f으로 비만형에 속합니다 .\n",(double)resultWManwegiht35up36UP);
            }

        }

        if((age <= 35 && option ==2))
        {
            System.out.printf("잘들어와졌다2번");
            if(wegiht <= 85)
            {
                System.out.printf("현재 체중 : %d 표준 체중 : %d\n",wegiht,(int)WoManwegiht35down);
                System.out.printf("당신의 표준체중지수는 : %f으로 마른형에 속합니다 .\n",(double)resultWoManwegiht35down);
            }
            else if(wegiht==86 && wegiht<=95)
            {
                System.out.printf("현재 체중 : %d 표준 체중 : %d\n",wegiht,(int)WoManwegiht35down);
                System.out.printf("당신의 표준체중지수는 : %f으로 조금 마른형에 속합니다 .\n",(double)resultWoManwegiht35down);
            }
            else if(wegiht==96 && wegiht<=115)
            {
                System.out.printf("현재 체중 : %d 표준 체중 : %d\n",wegiht,(int)WoManwegiht35down);
                System.out.printf("당신의 표준체중지수는 : %f으로 표준형에 속합니다 .\n",(double)resultWoManwegiht35down);
            }
            else if(wegiht==116 && wegiht<=125)
            {
                System.out.printf("현재 체중 : %d 표준 체중 : %d\n",wegiht,(int)WoManwegiht35down);
                System.out.printf("당신의 표준체중지수는 : %f으로 조금 비만형에 속합니다 .\n",(double)resultWoManwegiht35down);
            }
            else
            {
                System.out.printf("현재 체중 : %d 표준 체중 : %d\n",wegiht,(int)WoManwegiht35down);
                System.out.printf("당신의 표준체중지수는 : %f으로 비만형에 속합니다 .\n",(double)resultWoManwegiht35down);
            }

        }

        if((age >= 36 && option ==1))
        {
            System.out.printf("잘들어와졌다\n");
            if(wegiht <= 85)
            {
                System.out.printf("현재 체중 : %d 표준 체중 : %d\n",wegiht,(int)Manwegiht36up);
                System.out.printf("당신의 표준체중지수는 : %f으로 마른형에 속합니다 .\n",(double)resultManwegiht36up);
            }
            else if(wegiht==86 && wegiht<=95)
            {
                System.out.printf("현재 체중 : %d 표준 체중 : %d\n",wegiht,(int)Manwegiht36up);
                System.out.printf("당신의 표준체중지수는 : %f으로 조금 마른형에 속합니다 .\n",(double)resultManwegiht36up);
            }
            else if(wegiht==96 && wegiht<=115)
            {
                System.out.printf("현재 체중 : %d 표준 체중 : %d\n",wegiht,(int)Manwegiht36up);
                System.out.printf("당신의 표준체중지수는 : %f으로 표준형에 속합니다 .\n",(double)resultManwegiht36up);
            }
            else if(wegiht==116 && wegiht<=125)
            {
                System.out.printf("현재 체중 : %d 표준 체중 : %d\n",wegiht,(int)Manwegiht36up);
                System.out.printf("당신의 표준체중지수는 : %f으로 조금 비만형에 속합니다 .\n",(double)resultManwegiht36up);
            }
            else
            {
                System.out.printf("현재 체중 : %d 표준 체중 : %d\n",wegiht,(int)Manwegiht36up);
                System.out.printf("당신의 표준체중지수는 : %f으로 비만형에 속합니다 .\n",(double)resultManwegiht36up);
            }

        }


        }
    }
