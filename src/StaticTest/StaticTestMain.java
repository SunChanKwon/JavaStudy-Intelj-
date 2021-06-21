package StaticTest;

public class StaticTestMain {
    public static void main(String[] args) {
        StaticTest ss = new StaticTest();
        StaticTest ss2 = new StaticTest();

        ss.setAddr("영등포구");
        //staic 오류를 해결하기?!! 뭘까요 이건?....

        String addres = ss2.getAddr();
        System.out.println("address="+ addres);

        System.out.println("name="+StaticTest.addr);

    }
}

