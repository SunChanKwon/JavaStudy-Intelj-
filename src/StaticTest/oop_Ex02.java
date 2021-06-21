package StaticTest;

import java.util.Scanner;

public class oop_Ex02 {
    int dan=0;// 단으로 전역변수 선언//dan=3
    int result=0;
    String gugu="";
    public oop_Ex02(){

    }
    void start(){
        dan =danInput();
        gugodan(dan);//gugudan(3)
        System.out.print(gugu);
    }

    int danInput(){
        Scanner scan = new Scanner(System.in);
        System.out.println("단을 입력해주세요 : ");
        return scan.nextInt();
    }

    void gugodan(int dan)
    {
        for(int i=0; i<=9; i++)
        {
            gugu= gugu + dan+"*"+i+"="+dan*i+"\n";
        }
    }
    //단 입력받기
    // 구구단 출력하기
    public static void main(String[] args) {
        //프로그램은 메인부터 시작.
        oop_Ex02 op = new oop_Ex02();
        op.start();
    }
}
