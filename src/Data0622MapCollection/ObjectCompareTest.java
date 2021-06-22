package Data0622MapCollection;

import java.lang.reflect.Member;
import java.util.*;
import java.lang.Comparable;


public class ObjectCompareTest {

    public ObjectCompareTest() {
      List<MemberVo> Member = new ArrayList<MemberVo>(); // 배열 리스트 생성하고 값을 멤버 리스트에 넣음
        Member.add(new MemberVo("홍길동", "제획부", "2020-10-10", 2000));
        Member.add(new MemberVo("김길동", "개발부", "2020-10-12", 5000));
        Member.add(new MemberVo("조길동", "기획부", "2020-10-13", 4000));
        Member.add(new MemberVo("이길동", "총무부", "2020-10-14", 7000));
        Member.add(new MemberVo("권길동", "총무부", "2020-10-14", 6400));

        System.out.println("정렬전에 출력=--------------");

        for(MemberVo vo : Member)
        {
            System.out.println(vo.toString());
        }
        System.out.println("==급여를 오름차순으로 정렬 =====");
        Collections.sort(Member,new CompareAscSal());//객체가 전체있는 컬렉션, 정렬할 기준이 되는 기능이 있는 Compartor 객체

        for(MemberVo vo : Member)
        {
            System.out.println(vo.toString());
        }
        System.out.println("==급여를 내림차순으로 정렬 =====");

        Collections.sort(Member,new CompareDescSal());//객체가 전체있는 컬렉션, 정렬할 기준이 되는 기능이 있는 Compartor 객체
        for(MemberVo vo : Member)
        {
            System.out.println(vo.toString());
        }
    }
    //숫자를 이용한오름차순 정렬하는 클래스
    //정렬하는 클래스는 Comparator 인터페이스를 상속받아 만든다.
    class CompareAscSal implements Comparator<MemberVo> {
        public int compare(MemberVo v1, MemberVo v2){
            //왼쪽의 값이 작으면 - , 왼쪽의 값이 크면 +
            return (v1.getSal()< v2.getSal())? -1: (v1.getSal() > v2.getSal()) ? +1 : 0; // 3항 연사자가 이해가 안됨...이해하자.
        }
    }

    //숫자를 이용한 내림차순 정렬하는 클래스
    class CompareDescSal implements Comparator<MemberVo>{
        public int compare(MemberVo v1, MemberVo v2)
        {
            return (v1.getSal() < v2.getSal())? 1 : (v1.getSal() > v2.getSal())? -1: 0;
        }
    }

    public static void main(String[] args) {
        new ObjectCompareTest();
    }
}
