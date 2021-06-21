package F0617;

public class ProtectedTest2 {
    protected String tel = "010-2740-7662";
    protected ProtectedTest2(){
        System.out.print("다른패키지의 생성메소드 입니다.");
    }
    protected void telOutput(){
        this.tel="010";
        System.out.println("전화번호="+tel);
    }
    public String getTel()
    {
        this.tel="123123";
        return tel;
    }
    public static ProtectedTest2 getInstance() {//이거 공부해야된다 순찬이 무조건 !!필수다
    return new ProtectedTest2();
    }// 자신의 클래스를 만들어서 객체를 린턴해주는 클래스를 리턴해줌 getInstanc를 이용해서
}
