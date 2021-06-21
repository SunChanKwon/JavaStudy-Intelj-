package ObjectMethodTest2;

public class MethodTestMain02 {

    public static void main(String[] args) {
        MethodTest02 mt = new MethodTest02();

        String gugu=mt.gugudan(8);
        System.out.println(gugu);

        mt.powerStart();
        mt.channelUp();
        mt.channelDonw();
        mt.sum(20);
        
        MethodTest02.sum(50);
        //Static이 있는 경우엔메소으듸 반환형 왼쪽에 있는 경우는 메소드를 객체생성하지 않고 호출이 가능하다.
    }
}
