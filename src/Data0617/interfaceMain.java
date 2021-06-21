package Data0617;
//클래스에서 interface를 상속받을 경우 implements키워드를 이용한다.
// interface는 여러개 상속받을수 있다.
// 상속받는 모든 추상 메소드는 오버라이딩을 해야한다. 필수(!!!!!!!!!!!!!!!)
public class interfaceMain implements interfaceTest2,interfaceTest1{

    public interfaceMain(){}

    public void output() {}
    public int sum() {  return 5050; }
    public void oodSum(){
        int sum=0;
        for(int i=1; i<=MAX; i+=2)
        {
            sum+=i;
        }
        System.out.println("1~MAX 까지의 합은:"+sum);
    }
    public int evenSum(){
        int sum=0;
        for(int i=0; i<MAX; i+=2)
        {
            sum=+i;
        }
        return sum;
    }
    public void resultPrint(int data){
        System.out.println("결과값:"+data);
    }

    public void start()
    {
        resultPrint(sum());
        oodSum();
        resultPrint(evenSum());
    }
    public static void main(String[] args) {
        new interfaceMain().start();
    }
}
