package Data_Net.Data0721.ChatClient;

import java.io.File;
import java.io.FileOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.sql.SQLSyntaxErrorException;

public class UnicasteFileRecive {

    DatagramSocket ds;
    DatagramPacket dp;

    public UnicasteFileRecive(){
        receiveStart();
    }

    public void receiveStart(){
    try{
        ds = new DatagramSocket(16000);
        byte[] data = new byte[512];
        dp = new DatagramPacket(data,data.length);
        FileOutputStream fos =null;

        while (true)
        {
            System.out.println("받기 대기중");
            ds.receive(dp);

            byte[] receiveDate = dp.getData();
            int len = dp.getLength();

            String part = new String(receiveDate,0,4);
            if(part.equals("FN##")) {
                String filename = new String(receiveDate, 4, len - 4);
                System.out.println("filename-->" + filename);
                fos = new FileOutputStream(new File("C://Users/D-Kwon/Pictures", filename));
                System.out.println("io 객체 생성됨.");
            }else if(part.equals("$%#$")){
                if(fos!=null)
                {
                    fos.write(receiveDate,4,len-4);
                }
            }else if(part.equals("^%$&")){
                fos.close();
                ds.close();
                System.out.println("파일받기 완료했습니다.");
            }

        }
            //전송할 내용이 파일명, 파일내용, 마지막 표시인지 확인!

    }catch (Exception e)
    {
     e.printStackTrace();
    }

    }

    public static void main(String[] args) {
        new UnicasteFileRecive();
    }
}
