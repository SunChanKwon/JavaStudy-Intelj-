package Methodtest1;

public class MethodMain {

    public static void main(String[] args) {
//        MethodTest mt = new MethodTest();
//        MethodTest mt2 = new MethodTest("010-2740-7662");
//        MethodTest sumMetod = new MethodTest();
//
//        mt.name="이순신";
//        System.out.println("mt.na,e="+mt.name);
//        System.out.println("mt2.name="+mt2.name);


        //Method test;
        MethodTest mt3 = new MethodTest(100,"세종대왕");

        System.out.println("Mt3.num="+mt3.num);
        System.out.println("Mt3.name="+mt3.name);
        System.out.println("Mt3.tel="+mt3.tel);

        MethodTest mt4 = new MethodTest("장영실",200);
        System.out.println("Mt4.num="+mt4.num);
        System.out.println("Mt4.name="+mt4.name);
        System.out.println("Mt4.tel="+mt4.tel);
        }
}

