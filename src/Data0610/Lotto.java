package Data0610;

public class Lotto {
    public static void main(String[] args) {
        int lotto[] = new int[6];
        int lottoBouns=(int)((Math.random() * 45) + 1);

            for (int i = 0; i < 6; i++) {
                lotto[i] = (int)((Math.random() * 45) + 1);

                // 중복 번호 제거
                for (int j = 0; j < i; j++) {
                    if (lotto[i] == lotto[j]) {
                        i--;
                        break;
                    }
                }
            }
        for(int a=0; a<lotto.length-1; a++) {
            for(int j=0; j<lotto.length-1-a; j++) {
                if (lotto[j] >= lotto[j + 1]) {
                    int temp = lotto[j];
                    lotto[j] = lotto[j + 1];
                    lotto[j + 1] = temp;
                }
            }
        }
//        for(int count=0; count< lotto.length; count++)
//        {
//           if(lottoBouns== lotto[count])
//           {
//               lotto[count]=(int)((Math.random() * 45) +1);
//           }
//        }
            System.out.print("로또 번호: ");

            // 번호 출력
            for (int i = 0; i < 6; i++) {
                System.out.print(lotto[i] + " "+lottoBouns);
            }
        }
    }
