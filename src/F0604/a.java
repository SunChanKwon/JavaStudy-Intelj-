package F0604;
public class a {
    public static void main(String[] args) {

        for(int i = 0; i < 9; i =+3) {
            for(int j = 1; j < 10; j++) {
                for(int k = i; k < i + 3; k++) {
                    System.out.printf("%3d * %3d = %3d", k, j, k * j);
                }
                System.out.printf("\n");
            }
            System.out.printf("\n");
        }

    }
}