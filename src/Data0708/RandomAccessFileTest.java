package Data0708;

import java.io.File;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {

    public RandomAccessFileTest(){
        File f = new File("C://testFile/access.txt");
        try
        {
            //쓰기 전용 :w,읽기전용 :r , 읽기쓰기 :rw
            RandomAccessFile raf = new RandomAccessFile(f,"rw");
            String str = "Java input output test programing"; //쓰기를 할꺼다
            raf.writeBytes(str);
            raf.writeInt(12345);

            //쓰기할 위치 이동
            raf.seek(10);
            raf.writeBytes("hong");

            raf.seek(raf.length());
            byte[] data={65,66,67,68};
            raf.write(data);

            raf.close();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new RandomAccessFileTest();
    }
}
