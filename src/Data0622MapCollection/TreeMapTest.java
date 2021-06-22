package Data0622MapCollection;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapTest {

   public TreeMapTest() {
       TreeMap<String, MemberVo> tm = new TreeMap<String, MemberVo>(); //트리는 자동적으로 sort를 해주는 역활을 가진다.
//tm.put("권길동", new MemberVo("권길동", "인사부", "2020-10-11", 3000));
       tm.put("ㄱ", new MemberVo("홍길동", "제획부", "2020-10-10", 2000));
       tm.put("ㄴ", new MemberVo("김길동", "개발부", "2020-10-12", 4000));
       tm.put("ㅎ", new MemberVo("조길동", "기획부", "2020-10-13", 5000));
       tm.put("ㅈ", new MemberVo("이길동", "총무부", "2020-10-14", 6000));
       tm.put("ㅁ", new MemberVo("권길동", "총무부", "2020-10-14", 6000));  //sort를 하게된다면 제각각 클래스를 따로 만들어주어야 한다.

       System.out.println("==================");
             Set<String> KeyList =tm.keySet(); //Set(String) 가져온 값을 KeyList 넣어준다. =tm.keySet(키값을 가져와서)
       Iterator<String> ii = KeyList.iterator();  //Iter로 인하여서 sort된 값들을 가져와서 객체로 생성해서 넣어준다
       while (ii.hasNext())     // has.next 널 null 값이 될떄가지 while문을 실행한다. 
       {    
           MemberVo vo = tm.get(ii.next());  //될떄마다 MemberVo 생성된 객체를 찾아서 넣어줘서 그값들을 getset해서 값을 리턴ㄷ해준다
           System.out.println(vo.toString()); //리턴된 값을 출력
       }

   }
    public static void main(String[] args) {
        new TreeMapTest();
    }
}
