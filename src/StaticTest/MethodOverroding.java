package StaticTest;

public class MethodOverroding {

    public MethodOverroding(){}

    int totalResult(){
        int result=0;
        for(int i=0; i<=100; i++)
        {
            result +=i;
        }
        return result;
    };

    int totoalResult(int max)
    {
        int result=0;
        for(int i=1; i<=max; i++)
        {
            result+=i;
        }
        return result;
    }
    public static void main(String[] args) {
        MethodOverroding ma = new MethodOverroding();

        int r = ma.totalResult();
        int rr= ma.totoalResult(100);

    }
}
