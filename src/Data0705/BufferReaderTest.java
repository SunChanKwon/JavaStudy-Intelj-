package Data0705;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BufferReaderTest {

    public BufferReaderTest(){

        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            System.out.print("입력");
            String txt = br.readLine();
            System.out.println("txt="+txt);
        } catch (Exception e) {

        }
    }

    public static void main(String[] args) {
        new BufferReaderTest();
    }
}

