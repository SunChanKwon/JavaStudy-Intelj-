package Data0617;

public class abstractMain extends AbstractTest{

    public abstractMain(){

    }

    public void print(){
        System.out.println("num"+num+", name="+name);
    }

    public void SetData(int num,String name)
    {
        this.num = num;
        this.name = name;
    }
    public void start()
    {
        numOutput();
        SetData(5000,"이순신");
        print();
    }
    public static void main(String[] args)
    {
        abstractMain am = new abstractMain();
        am.start();
    }
}
