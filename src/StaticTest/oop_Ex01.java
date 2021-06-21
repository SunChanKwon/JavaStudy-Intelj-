package StaticTest;


import javax.swing.plaf.synth.SynthTabbedPaneUI;
import java.util.Scanner;

public class oop_Ex01 {

    public oop_Ex01(){
     int dan = danInput();
     String result= gugodan(dan);
     System.out.println(result);
    }

    int danInput(){
        Scanner scan = new Scanner(System.in);
        System.out.println("단을 입력해주세요 : ");
        return scan.nextInt();
    }

    void start(){
        int dan =danInput();
        String result =gugodan(dan);
        System.out.print(result);
    }
    String gugodan(int dan)
    {
        String gugu="";
        for(int i=0; i<=9; i++)
        {
            gugu+=dan+"*"+i+"="+dan*i+"\n";
            System.out.println(gugu + "    "+"   ");
        }
        return gugu;
    }
    //단 입력받기
    // 구구단 출력하기
    public static void main(String[] args) {
        oop_Ex01 op = new oop_Ex01();

        op.start();
    }
}


