public class test {
    public static void main(String[] args){//
        int a=0;
       // int c=0;
        int count=0;
        for(int i = 1 ; i<=50 ; i++)
         {
             if(i%3==0){
                 a++;
                 System.out.println(a+"번 : " + "(3의 배수):"+i);
             }
             if(i%5==0){
                 a++;
                 System.out.println(a+"번 : " + "(5의 배수):"+i);
             }
         }
        System.out.println("----------------------");
//       while(c<=50)
//       {
//           if(c%3==0){
//               count++;
//               System.out.println(count+"번 : " + "(3의 배수):"+c);
//           }
//           if(c%5==0){
//               count++;
//               System.out.println(count+"번 : " +  "(5의 배수):"+c);
//           }
//           c++;
//       }
   }
}
