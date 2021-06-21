package F0617;


class atest1 {
    protected int add(int a, int b) {
        return a * b;
    }
}
class aTest2 {
    class Ex extends atest1 {
        //protected int add(int a, int b) {
            int x =super.add(10, 5);
//            return x;

        }
  //  }

    public static void main(String[] args) {

        atest1 Ex = new atest1();
        System.out.println(Ex.add(10,5));
    }
}

//    public static class Ex extends aTest{
//        public static void main(String[] args) {
//            aTest t1 = new aTest();
//            Ex e1 = new Ex();
//            //Ex e2 = (EX)t1;
//            Object o1 = (Object)t1;
//            //String s1 =(String)t1;
//            aTest t2 = (aTest)e1;
//        System.out.println(t2);
//        }
//    }

