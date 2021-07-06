package Data0705;

import java.io.BufferedInputStream;

public class BufferInputStreamTest {
    public BufferInputStreamTest()
    {
        try {
            BufferedInputStream bis = new BufferedInputStream(System.in);

            byte data[] = new byte[10];
            System.out.print("입력=");
        }catch (Exception e)
        {

        }
    }

    public static void main(String[] args) {
        new BufferInputStreamTest();
    }
}
