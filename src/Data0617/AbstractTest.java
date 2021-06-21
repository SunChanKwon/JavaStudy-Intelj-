package Data0617;

//추상 메소드를 1개이상 클래스는 추상클래스이다.
//추상 클래스는 class키워드 왼쪽에 abstract를 표기하여야 한다.
public abstract class AbstractTest {

    int num = 100;
    String name = "홍길동";
    public AbstractTest(){

    }
    public void numOutput()
    {
        System.out.println("num"+num);
    }

    public abstract void print();//실행부가 없는 메소드는 추상메소드 입니다.
    public abstract void SetData(int num,String name);
}
