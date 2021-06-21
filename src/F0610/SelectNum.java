package F0610;

public class SelectNum {

    public static void main(String[] args) {
        int temp = 0;
        int data[] = new int[6];
        for (int i = 0; i < data.length; i++) {
            data[i] = (int) (Math.random() * ((45))) + 1;
        }
        System.out.println();
        for (int a = 0; a < data.length; a++) {
            for (int i = 0; i < data.length - 1 - a; i++) {
                int index = 0;
                for (int j = i + 1; j < data.length-1; j++) {
                    if (data[i] > data[j]) {
                        temp = data[index];
                        data[index] = data[i];
                        data[i] = temp;
                    }
                }
            }
        }
        System.out.print("-------");
        for (int k = 0; k < data.length; k++) {
            System.out.print(" " + data[k]);
        }
    }
}





