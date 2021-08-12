package Data_Net.Data0721.ChatClient;

import java.net.*;

public class MulticastReceive {
    MulticastSocket ms;
    DatagramPacket dp;

    public MulticastReceive(){
        try{
            ms= new MulticastSocket(17000);
            InetAddress ia = InetAddress.getByName("225.0.0.3");
            InetSocketAddress isa = new InetSocketAddress(ia,17000);
            NetworkInterface ni = NetworkInterface.getByName("bitca");
            ms.joinGroup(isa,ni);

            byte[] data=new byte[512];
            dp = new DatagramPacket(data,data.length);
            ms.receive(dp);

            byte[] inData = dp.getData();
            int len =dp.getLength();

            System.out.println(new String(inData,0,len));
            
        }catch (Exception e){}
    }

    public static void main(String[] args) {
        new MulticastReceive();
    }
}
