package Data0705;

import java.io.*;

public class FileInputStreamTest {
    public FileInputStreamTest(){
        //파일의 내용을 읽어 파일로 출력하기
        File scrFile = new File("D://testFile/abcd.txt");
        File tarFile = new File("D://testFile/New.txt");

        try {
            FileReader fr= new FileReader(scrFile);  //열어서 쓰고
            BufferedReader br = new BufferedReader(fr);

            FileWriter fw = new FileWriter(tarFile);

            while(true)
            {
                String str= br.readLine();
                if(str==null)
                {
                    break;
                }
                fw.write(str);
                System.out.print(str);
            }
            fw.close();
            br.close();
            fr.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new FileInputStreamTest();
    }
}
