package F0604;
import java.util.Scanner;

public class IFelseTest {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.printf("숫자를 입력해서 짝수인지 홀수 인지 판단하세요\n");

        int data = scan.nextInt();

        int result=0;
        if(data%2==0)
        {
            System.out.printf("%d\n",data);
            System.out.printf("짝수 입니다.");
            result = data * 100;
            System.out.printf("%d\n",result);
        }
        else
        {
            System.out.printf("%d\n",data);
            System.out.printf("홀수 입니다.");
            result = data * 500;
            System.out.printf("%d\n",result);
        }
    }
}
