package Data0622MapCollection;

import java.util.Calendar;

public class GenericMain {

    public GenericMain()
    {
        String data="서울시 마포구 비트캠프";
        GenericTest gt =new GenericTest();
        gt.setUsername(data);

        GenericTest gt2 = new GenericTest();

        Calendar now = Calendar.getInstance();

        GenericTest<MemberVo> gt3 = new GenericTest<MemberVo>();

        gt3.setUsername(new MemberVo("권순찬","개발부","2020-10-21",5000));

        GenericTest<Calendar> gt4 =new GenericTest<Calendar>(now);

        MemberVo vo = gt3.getusername();
        System.out.println(vo.toString());

        System.out.println(gt4.getusername());
    }
    public static void main(String[] args) {
        new GenericTest();
    }
}
