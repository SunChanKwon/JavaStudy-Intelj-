package Data_Net.Data0721.ChatClient;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.nio.charset.StandardCharsets;

public class Multicastesend {
    //224.0.0.0~239.255.255.255

    //225.0.0.3
    MulticastSocket ms;
    DatagramPacket dp;
    InetAddress ia;
    public Multicastesend(){

        try {
          ms = new MulticastSocket();
          ia = InetAddress.getByName("225.0.0.3"); 
          String data = "멀티캐스트 소켓을 이용한 데이터 전송";
            dp = new DatagramPacket(data.getBytes(),data.length());
          ms.send(dp);
          System.out.println("as");

        }catch (Exception e)
        {}
    }

    public static void main(String[] args) {
            new Multicastesend();
    }
}
