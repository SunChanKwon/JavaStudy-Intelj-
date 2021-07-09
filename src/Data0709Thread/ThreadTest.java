package Data0709Thread;

public class ThreadTest extends Thread {
    String msg;
    public ThreadTest() {
    }
    public  ThreadTest(String msg)
    {
        this.msg=msg;
    }
    public void run() {
        for (int i = 1; ; i++) {
            System.out.println(msg+"="+ i);
        }
    }

        public static void main (String[]args){
        ThreadTest tt1 = new ThreadTest("첫번째 스레드");
        tt1.start();
        ThreadTest tt2 = new ThreadTest("두번째 쓰레드");
        tt2.start();
        }
    }

