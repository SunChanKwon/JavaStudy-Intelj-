package Data0610;

public class ForExampleArr {
    public static void main(String[] args) {

        int arr[] = {85,6,92,65,12,74,35};

        for(int data: arr)
        {
            System.out.print(data+"\t");
        }
        System.out.println();

        int arr2[][] = {
                {85,80,40,60},
                {56,62,84,79},
                {36,58,78,95}
        };
        System.out.println("---------");
        for(int[] data :arr2)
        {
            for(int z:data)
            {
                System.out.print(z+"\t");

            }
            System.out.println();
        }
    }
}
