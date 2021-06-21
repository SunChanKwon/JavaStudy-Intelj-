package Methodtest1;

public class MethodTest {
    String name="홍길동";
    int num=10;
    String tel;

//생락시 자바 가상머신이 생성된

    MethodTest(int num,String name){
        this.num=num;
        this.name=name;
        this.tel="0220657662";
    }
    MethodTest(String name,int num){
        //매개변수 달라서 가능
        //매개변수가 똑같으면 실행 불가능
        this(num,name);
        //MethodTest(num,name);사용 할수 없다
        //생성자 메소드에서 다른 생성자를 호출할떄는 메소드 명을 직접 표기할수 없다.
        //대신 this을 사용한다
        //this(num,name); 현재 클래스의 생성자
        //-제일중요-this을 이용할떄 다른 생성자 메소드를 호출할떄는 반드시 첫번째 실행문이여야 한다.
    }
}


//    void sum(int num)
//    {
//        num+=num;
//        System.out.print(num);
//    }
//    MethodTest(){}
//    MethodTest(String tel){
//        System.out.println("연락처:"+tel);
//    }


