package F0610;

public class sort {
    public static void main(String[] args) {

        int data[] = new int[6];
        for(int i=0; i<data.length; i++)
        {
            data[i] = (int)(Math.random()*((45)))+1;
        }

        System.out.println();
        for(int a=0; a<data.length-1; a++) {
            for(int j=0; j<data.length-1-a; j++) {
                if (data[j] >= data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
        System.out.print("");
        for(int k=0; k<data.length; k++)
        {
            System.out.print(" "+data[k]);
        }
    }

}
