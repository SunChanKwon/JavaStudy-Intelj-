package Data_Net.Data0721.Data0722;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InterAddressTest {

    public InterAddressTest(){
        try {
            InetAddress ia1 = InetAddress.getLocalHost();

            String hostAddr1 = ia1.getHostAddress();
            String hostName1 = ia1.getHostName();

            System.out.println("hostAddr1->"+ hostAddr1);
            System.out.println("hostAddr1->"+ hostName1);

            InetAddress nate = InetAddress.getByName("www.nate.com");
            System.out.println("nate->address-->"+nate.getHostAddress());
            System.out.println("nate->Name-->"+nate.getHostName());

            InetAddress nateIp = InetAddress.getByName("120.50.131.112");
            System.out.println("nateIP->address-->"+nateIp.getHostAddress());
            System.out.println("nateIP->Name-->"+nateIp.getHostName());


            System.out.println("--------------------------------------------");
            InetAddress[] ip = InetAddress.getAllByName("www.naver.com");

            for(InetAddress ia:ip)
            {
                System.out.println("address-->"+ia.getHostAddress());
                System.out.println("Name-->"+ia.getHostName());
                System.out.println("--------------------------------------------");
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new InterAddressTest();
    }
}
