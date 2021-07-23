package Data_Net.Data0721.Data0722;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSockertTest {

    public ServerSockertTest(){
        serverStart();
    }

    public void serverStart(){

        try {
            ServerSocket ss =new ServerSocket(12000);
            System.out.println("Server Start....");
            Socket s=ss.accept();
            System.out.println("클라이언트가 접속하였습니다");
            InetAddress ia = s.getInetAddress();
            System.out.println("접속자의 ip->>"+ia.getHostAddress());

            OutputStream os = s.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            PrintWriter pw = new PrintWriter(osw);

            pw.println("Welcome~`안녕");
            pw.flush();

            //클라이언트가 보낸문자 받기
            InputStream is = s.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            String data =br.readLine();
            System.out.println("서버 실행하는중~~!~!~!");

        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ServerSockertTest();
    }
}
