package Data0709Thread;

public class RunableTest implements Runnable{
    String msg;

    public RunableTest() {
    }
    public  RunableTest(String msg)
    {
        this.msg=msg;
    }
    //쓰레드 구현영역을 run()메소드에 오버라이딩함
    public void run() {
        int i = 1;
        while (true)
        {
            System.out.println(msg+"====>"+ i++);

        }

    }
    public static void main (String[]args) {
        Runnable rt1 = new RunableTest("첫번째 쓰레드");
        Runnable rt2 = new RunableTest("두번째 쓰레드");

        Thread t1 = new Thread(rt1);
        Thread t2 = new Thread(rt2);

        t1.start();
        t2.start();
    }

}
