package F0617.ProTected;

public class ProtectedTest {
    protected  int num=2134;
    String name ="세종대왕";
    protected ProtectedTest(){
        System.out.print("같은 패키지의 생성자메소드");
    }
    protected void print(){
        System.out.println("이름="+name);
    }
  
}
