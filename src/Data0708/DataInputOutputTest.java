package Data0708;

import java.io.*;

public class DataInputOutputTest {

    public DataInputOutputTest() throws FileNotFoundException {
       try {
           File file = new File("C://fileTest", "data.txt");
           FileOutputStream fos = new FileOutputStream(file);
           DataOutputStream dos = new DataOutputStream(fos);

           int num=1234;
           double data2 = 5628.34;
           boolean boo = true;
           char lastName='홍';

           dos.writeInt(num);
           dos.writeDouble(data2);
           dos.writeBoolean(boo);//1byte
           dos.writeChar(lastName);

       }catch (FileNotFoundException fnfe)
       {
           System.out.println("파일을 확인해주세여");
       } catch (IOException e) {
           System.out.println("파일로 쓰기 에러");
       }
    }

    public static void main(String[] args) throws FileNotFoundException  {
       new DataInputOutputTest();
    }
}
