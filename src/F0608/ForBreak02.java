package F0608;

public class ForBreak02 {
    public static void main(String[] args) {
        for(int i=1;i<10;i++)
        {
            for(int j=0; ; j++)
            {
                System.out.println("i="+i+", j="+j);
                if(j>5)
                {
                    System.out.println("프로그램 종료되었습니다");
                    break;
                }
            }

        }
    }
}
