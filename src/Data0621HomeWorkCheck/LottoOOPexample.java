package Data0621HomeWorkCheck;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class LottoOOPexample {
    Random random = new Random(); //쓰기위해서 변수 선언하는것 객체형 변수이다.
    Scanner scan = new Scanner(System.in);
    public LottoOOPexample() {
        // TODO Auto-generated constructor stub
    }


    //1. 게임만들기 보너스포함,중복검사 //()매개변수값 없다는 뜻
    public int [] lottoCreate(){ //데이터가 지역변수로 존재함 //게임한개만들기
        int lotto[] = new int [7];//7개의 int 를 저장할 칸을 만들어서 배열을 만듬
        for(int i=0;i<lotto.length; i++) {//0,6
            //로또 번호생성
            lotto[i]= random.nextInt(45)+1;
            //중복검사
            //호출을 한거고
            i=doubleCheck(lotto,i);

        }
        return lotto;
    }

    //2.중복검사는 여기서 검사를 하고 저기 호출을 생성함
    public int doubleCheck(int lotto[],int i) { //i가 방금만든거고j 가 012
        for(int j=0; j<i; j++) {
            if(lotto[j] ==lotto[i]) { //방금만든번호랑 같다면 마이너스시킴
                i--;
                break;
            }
        }
        return i; //중복된게 없으면i 가 돌아감
    }

    //3.출력
    public void lottoPrint(int cnt,int lotto[]) {
        System.out.print(cnt+"게임");
        System.out.print(Arrays.toString(Arrays.copyOfRange(lotto,0,6)));//번호 //int배열을 가지고 문자화 한거다.
        System.out.println(",bonus="+lotto[6]);
    }

    //계속 여부 확인하는 메서드
    public boolean yesNo() {
        do {
            System.out.println("계속 하시겠습니까(y:예 , n아니오)?"); //대소문자 상관없이 넘어가게 된다.
            String qa = scan.nextLine();
            if(qa.equalsIgnoreCase("y")) {
                return true;
            }else if(qa.equalsIgnoreCase("n")) {
                return false;
            }
        }while(true);
        //y :계속 , n:종료 //n말고 다른 문자를 쓴다면? 계속할까요?라는 걸 계속질문해야함 계속한다는건 반복이 돌아가면되고 그만하면 중단하면됨.
        //y도 아니고 n도 아니면 다시한다 1.y 2.n 3.다시
        //Y:계속. N종료 ,그외다시 질문을 다시해야하니깐 반복이된다.
    }
    public void lottoStart() {//제발
        do {
            int game=0; //전역변수를 통해서 값을 전달될수있는 값을 추가
            System.out.print("게임수=");
            try {
                game = Integer.parseInt(scan.nextLine());
            }catch (NumberFormatException number)
            {
                System.out.println("숫자을 입력해야 됩니다.");
            }       ///배열을 통해서 숫자가 아닐시에는 숫자를 입력되도록 다시 메세지를 뛰어준다\.\
            finally {
                System.out.println("숫자로 잘 입력되었습니다.");  //마지막으로 숫자가 잘 입력되어있는지 화인시켜준다.
            }

            for(int i=1; i<=game; i++) { //한바퀴돌동안 게임한개
                int lotto[]=lottoCreate(); //여기있는ㄷ 숫자가 마지막 번호남겨놓고
                Arrays.sort(lotto,0,6); //정렬

                lottoPrint(i,lotto);//출력
            }
            //계속여부
            if (!yesNo()){
                break;
            }
        }while(true);
    }
   public static void main(String a[]) {
      //메인메서드
       LottoOOPexample oop= new LottoOOPexample();
      oop.lottoStart();

   }

}