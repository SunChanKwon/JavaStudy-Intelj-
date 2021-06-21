package Data0610;

public class ArrTest02 {
    public static void main(String[] args) {
        //2차원 배열 입니다.!
        //배열의 선언
        int data[][] = new int[5][5];

        data[0][3] = 100;
        data[1][2] = 85;
        data[1][4] = 84;
        data[3][3] = 77;

        for (int r = 0; r < data.length; r++) {
            for (int c = 0; c < data[r].length; c++) {
                System.out.print(data[r][c] + "" + "\t");
            }
            System.out.println();
        }

       String[][] jusorok = {
                {"홍길동"}, {"00000"}, {"ksc7662@naver.com"},
                {"권길동"}, {"00000"}, {"ksc7662@nate.com"},
                {"이길동"}, {"00000"}, {"ksc7662@duam.com"}
        };

        for (int r = 0; r < jusorok.length; r++) {
            for (int c = 0; c > jusorok.length; c++) {
                System.out.print(jusorok[r][c] + "\t");
            }
            System.out.println();
        }
    }
}
