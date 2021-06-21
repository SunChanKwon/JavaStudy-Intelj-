package Data0608;

public class Diamond {
    public static void main(String[] args) {

        System.out.println("방법 1------------");
        for (int i = 1; i <= 5; i++) {
            for(int b=5; b>i; b--)
            {
                System.out.print("*");
            }
            for(int c=0; c<i; c++)
            {
                System.out.print("-");
            }
            System.out.println();
        }
    }
}