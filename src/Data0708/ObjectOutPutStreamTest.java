package Data0708;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class ObjectOutPutStreamTest {

    public ObjectOutPutStreamTest(){

        try
        {
            File f= new File("c://fileTest/object.txt");
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            TestMemo memo = new TestMemo();

            oos.writeObject(memo);

            oos.close();
            fos.close();
            System.out.println("성공");
        }catch (Exception e)
        {

        }

    }

    public static void main(String[] args) {
        new ObjectOutPutStreamTest();
    }
}
