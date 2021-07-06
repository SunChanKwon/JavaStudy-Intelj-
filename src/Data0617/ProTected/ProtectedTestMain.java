package Data0617.ProTected;


import Data0617.ProtectedTest2;

public class ProtectedTestMain extends ProtectedTest2{
    ProtectedTestMain()
    {
        ProtectedTest pt = new ProtectedTest();
        System.out.println("pt.num="+pt.num);
        pt.print();

        //ProtectedTest2 pt2 = new ProtectedTest2();
        System.out.println("tel="+tel);
        telOutput();
    }
    public static void main(String[] args) {
        new ProtectedTestMain();
        ProtectedTest2 ppt = ProtectedTest2.getInstance();
        System.out.print(ppt.getTel());
    }

}
