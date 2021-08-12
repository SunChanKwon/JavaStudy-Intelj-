package Data_Net.Data0721.ChatClient;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UnicasteReceive {
    DatagramSocket ds;
    DatagramPacket dp;

    public UnicasteReceive(){

        try {
            ds = new DatagramSocket(15000);

            byte[] data = new byte[512];
            dp=new DatagramPacket(data,data.length);
            System.out.println("받기 대기중....");
            ds.receive(dp);

            byte[] receiveData =dp.getData();
            int byteCount = dp.getLength();
            String receiveStr = new String(receiveData);
            System.out.println(receiveStr+"----------");
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new UnicasteReceive();
    }
}
