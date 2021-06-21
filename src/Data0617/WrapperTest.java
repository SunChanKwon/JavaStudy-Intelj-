package Data0617;

public class WrapperTest {

    public WrapperTest(){
        //Wraooeer //btye //short //intger, long //float, double ///boolean, //character

        int a =1234;
        Integer i = Integer.valueOf(a);
        String ba="Ad";

        System.out.println(a);
        System.out.println(i);
        System.out.println(ba);


        Object obj = a; //오토언박싱
        Object obj2 =i;
        Object obj3 =ba;
        System.out.println(obj);
        System.out.println(obj2);
        System.out.println(obj3);

        int x = i; // 오토언박싱

    }

    public static void main(String[] args) {
        new WrapperTest();
    }
}
