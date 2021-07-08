package Data0708;

import java.io.*;

public class DataInputTest {

    public DataInputTest(){
        try{
            File f = new File("C://fileTest","data.txt");
            FileInputStream fis = new FileInputStream(f);
            DataInputStream dis = new DataInputStream(fis);

            int intData = dis.readInt();
            double douData = dis.readDouble();
            boolean booData = dis.readBoolean();
            char charDATA = dis.readChar();
            System.out.println(intData);
            System.out.println(douData);
            System.out.println(booData);
            System.out.println(charDATA);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new DataInputTest();
    }
}
