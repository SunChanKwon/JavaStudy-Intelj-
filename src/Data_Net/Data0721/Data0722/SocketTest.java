package Data_Net.Data0721.Data0722;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTest {

    public SocketTest(){

    }

    public void startClient(){
        //Socket(InetAddress, port)
        //InetAddress : 서버컴퓨터의 ip를 이용하여 생성한다.
        //port : 서버에서 open된 Port번호를 이용한다.


        try{
            InetAddress ia = InetAddress.getByName("192.168.0.36");
            Socket s = new Socket(ia,12000);

            InputStream is = s.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            String inData = br.readLine();
            System.out.println("서버에서 받은 문자");


            OutputStream os= s.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            PrintWriter pw = new PrintWriter(osw);

            pw.println("하이 난 클라이언트야");
            pw.flush();
        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new SocketTest().startClient();
    }
}
