package Data0708;

import Data0706.Memo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class ObjectOutPutStreamTest {

    public ObjectOutPutStreamTest(){

        try
        {
            File f= new File("D://FileTest/object.txt");
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            Memo memo = new Memo();

            
        }catch (Exception e)
        {

        }

    }

    public static void main(String[] args) {
        new ObjectOutPutStreamTest();
    }
}
