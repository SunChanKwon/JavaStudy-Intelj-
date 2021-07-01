package Data0622MapCollection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class HashMapTest {

    public HashMapTest()
    {
//        HashMap<Integer,String> hm = new HashMap<Integer,String>();
//        hm.put(1,new String("홍길동"));
//        hm.put(1,"홍길동");
//        hm.put(100,"세종대왕");
//        hm.put(50,"이순신");

//        String name = hm.get(100);
//        System.out.println("100->"+name);
//
//
//        Set<Integer> keyList = hm.keySet();
//
//        Iterator<Integer> ii = keyList.iterator();
//        while (ii.hasNext())
//        {
//            int k = ii.next();
//            System.out.print("Key="+k+", value="+hm.get(k));
//        }
        System.out.println("=============================================");

        HashMap<String,MemberVo> hm2 = new HashMap<String, MemberVo>();
        hm2.put("홍길동", new MemberVo("홍길동","제획부","2020-10-10",2000));
        //0
        hm2.put("권길동", new MemberVo("권길동","인사부","2020-10-11",3000));
        //1
        hm2.put("김길동", new MemberVo("김길동","개발부","2020-10-12",4000));
        //2
        hm2.put("조길동", new MemberVo("조길동","기획부","2020-10-13",5000));
        //3
        hm2.put("이길동", new MemberVo("이길동","총무부","2020-10-14",6000));
        //4
        //put 데이터를 삽입
        //pop데이터를 삭제
        int count=0;
        //key를 이용 정보 얻어오기
        //key 명령어 가져오기기
        Set<String> memberKey= hm2.keySet(); //collection 객체 넣어줬다.
        Iterator<String> iii = memberKey.iterator();
        //Iterator
        while (iii.hasNext())//==while(true) 1 =홍길동ㄴ 2=권길동
        { //iii.hasnext = 1 "김길동","개발부","2020-10-12",4000));
            String key = iii.next();
            System.out.print(key);
            MemberVo value =hm2.get(key); //1\
            System.out.println(value.toString());
            System.out.println(value.getName());
            System.out.println(","+value.getDepart());
            System.out.println(","+value.getHire());
            System.out.println(","+value.getSal());
           // System.out.println("몇번이냐"+count);
           // count++;
        }

        System.out.println("=====Value를 이용하여 값 받아오기");

//        Collection<MemberVo> values= hm2.values();//valuse 사용하기 키값을 이용해서 가져온다.
//        Iterator<MemberVo> memberValue = values.iterator();
//        while (memberValue.hasNext())
//        {
//            MemberVo vo = memberValue.next();
//            System.out.println(vo.toString());
//        }

    }

    public static void main(String[] args) {
        new HashMapTest();
    }
}
