package Data0708;

import java.io.*;

public class ObjectInputStreamTest {

    public ObjectInputStreamTest(){

        try
        {
            File f =new File("C://fileTest/object.txt");
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);

            TestMemo memo = (TestMemo)ois.readObject();
            memo.setVisible(true);

        } catch (IOException| ClassNotFoundException e) {
            System.out.println("실패한것 같은대2");
        }
    }

    public static void main(String[] args) {
        new ObjectInputStreamTest();
    }
}
