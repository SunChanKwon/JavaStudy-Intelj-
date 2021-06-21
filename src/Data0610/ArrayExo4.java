package Data0610;

public class ArrayExo4 {
    public static void main(String[] args) {
        int [][] arr2= new int[11][11];
        //System.out1.println(arr2.length-1);
        for(int row=1; row<arr2.length; ++row)
        {
            for(int low=1; low<arr2.length; ++low)
            {
                arr2[row][low] = row*low;
            }
        }
        for(int row =0; row<arr2.length; ++row)
        {
            for(int low=0; low<arr2.length; ++low) {
               if (arr2[row][low] != 0) {
                    System.out.print(arr2[row][low]+"\t");
                }
            }
            System.out.println();
        }

//        for(int row=1; row<arr2.length-1; row++)
//        {
//            if(row==1)
//            {
//                arr2[1][0]+=+1;
//            }
//           result=arr2[row][0]+=1;
//            arr2[row+1][0]+=result;
//        }
//        for(int row=1; row<arr2.length-1; row++)
//        {
//            result=arr2[row-1][row]*arr2[row-1][row];
//
//            System.out.println(result);
//            arr2[row][row]=result;
//        }

//        System.out.println("---------");
//        result=arr2[1][0]*arr2[0][1];
//        System.out.println(result);

//        for(int row=1; row<arr2.length-2; row++)
//        {
//            arr2[row][0]+=1;
//            result=arr2[row][0];
//            arr2[row+1][0]=result;
//        }
//        System.out.println(result);
//
//        System.out.println("---------");
//        for(int[] data :arr2)
//        {
//            for(int z:data)
//            {
//                System.out.print(z+"\t");
//
//            }
//            System.out.println();
//        }
    }
}
