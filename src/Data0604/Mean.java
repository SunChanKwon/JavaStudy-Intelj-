package Data0604;

public class Mean {
    public static void main(String[] args) {
        for(int i=0; i<5; i++)
        {
            for(int j=0; j<i;j++)
            {
                System.out.print("-");
            }
            for(int k=0; k<5-i; k++) {
                if (k == 0 && i == 2) {
                    System.out.print("-");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }

}
