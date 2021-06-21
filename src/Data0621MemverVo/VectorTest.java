package Data0621MemverVo;

import java.util.Calendar;
import java.util.Vector;

public class VectorTest {
    public VectorTest(){}

    public Vector start(){
        Vector v =new Vector();

        String username = "홍길동";
        Integer num=25010;
        Calendar cal = Calendar.getInstance();
        MemverVo vo = new MemverVo("세정대왕","기획부","2021-06-10",1000); //MemverVO에 값을 불러옴

        //vector객체에 다른 객체 추가하기
        v.add(username);
        v.addElement(num);
        v.add(1,cal);
        v.addElement(vo);

        return v;
    }

//    public static void main(String[] args) {
//        new VectorTest().start();
//    }
}
