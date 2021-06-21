package Data0608;
import java.util.Scanner;
public class Homasdsad {

        public static void main(String[] args)
        {
            Scanner scan = new Scanner(System.in);
            System.out.print("임의의 홀수입력(1~49)=");
            int num= scan.nextInt();
            char a= 65;

            for(int i=1; i<=num; i+=2){
                for(int s=1; s<=(num-i)/2; s++){
                    System.out.print(" ");
                }
                for(int j=1; j<=i; j++){

                    if(a==89)
                    {
                        a='A';
                    }
                    else
                    {
                        a++;
                    }
                    System.out.print(a);
                }
                System.out.println();
            }


            for(int i=num-2; i>0; i-=2){
                for(int s=1; s<=(num-i)/2; s++){
                    System.out.print(" ");
                }
                for(int j=1; j<=i; j++){
                    if(a==89)
                    {
                        a='A';
                    }
                    else
                    {
                        a++;
                    }
                    System.out.print(a);
                }
                System.out.println();
            }
        }
}
