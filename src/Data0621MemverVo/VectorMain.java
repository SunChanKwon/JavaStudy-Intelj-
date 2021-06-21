package Data0621MemverVo;

import java.util.Calendar;
import java.util.Vector;

public class VectorMain {

    public VectorMain(){
        //VectorTest클래스의 start()메소드를 호출하면 Vector로 리턴된다.
        VectorTest vt = new VectorTest(); //같읕 패키지 않에 있는 것들이 호출된다.
        Vector vvv = vt.start();
        
     
       String Name = (String) vvv.elementAt(0);// 첫번쨰 선언한 객체를 가져옴
        String Name1 = (String) vvv.firstElement();// 첫번쨰 선언한 객체를 가져옴

        Calendar ccc =(Calendar) vvv.get(1);
        Integer iii = (Integer) vvv.get(2);
        MemverVo Member= (MemverVo) vvv.get(3);

        System.out.println("Name:"+Name); //받아온 값을 넘겨받는다
        System.out.println("Name1:"+Name1); //받아온 값을 넘겨받는다
        System.out.println("ccc:"+ccc); //받아온 값을 넘겨받는다
        System.out.println("iii:"+iii); //받아온 값을 넘겨받는다
        MemverVo vo = (MemverVo)vvv.elementAt(3);
        vo.MemberPrint();

    }

    public static void main(String[] args) {
        new VectorMain();
    }

}
