package Data0604;

import java.util.Scanner;

public class Ifelse {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.printf("당신의 급여를 입력해주세요:\n");
        int sal = scan.nextInt();
        System.out.printf("당신의 급여은 %d입니다 \n",sal);
        int result=0;
            int bouns=0;

            if(sal>=10000 && sal<=20000)
            {
                bouns=(int)(sal * 0.2);
            }else if(sal>20000 && sal<=30000){
                bouns=(int)(sal * 0.15);
            }else if(sal>30000 && sal<=40000){
                bouns=(int)(sal * 0.1);
            } else if(sal>40000 && sal<=50000) {
                bouns = (int) (sal * 0.05);
            }
            else{
                System.out.printf("급여가 보너스에 해당사항이 없습니다");
            }
        System.out.printf("급여 %d, 보너스=%d\n",sal,bouns);

            /*
                    if(SalaryData>=10000 && SalaryData <= 20000)
        {
            System.out.printf("당신의 급여가 10000 초과 ~20000원이면 기본월급에 20%지급를 더 지급 합니다.\n");
            result=(int)(SalaryData*0.2);
        }  else if(SalaryData > 20000 &&  SalaryData <= 30000)
        {
            System.out.printf("당신의 급여가 20000 초과 ~30000원이면 기본월급에 15%지급를 더 지급 합니다.\n");
            result=(int)(SalaryData*0.15);
        }  else if(SalaryData > 30000 &&  SalaryData <= 40000)
        {
            System.out.printf("당신의 급여가 30000 초과 ~40000원이면 기본월급에 10%지급를 더 지급 합니다.\n");
            result=(int)(SalaryData*0.10);
        }  else if(SalaryData > 40000 &&  SalaryData <= 50000)
        {
            System.out.printf("당신의 급여가 40000 초300과 ~50000원이면 기본월급에 5%지급를 더 지급 합니다.\n");
            result=(int)(SalaryData*0.5);
        } else
        {
            System.out.printf("해당사항이 없습니다 .\n");
        }
        System.out.printf("당신의 보너스 급여는 : %d\n",result);*/
    }
}
