package Data_Net.Data0721.ChatClient;
import java.awt.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer extends Thread{
    ServerSocket ss;
    List<ChatService> connList = new ArrayList<ChatService>();
    public ChatServer() {
        this.start();
    }
    //접속을 대기하는 스레드
    @Override
    public void run() {

        try {
            ss = new ServerSocket(13000);
            while(true) {
                System.out.println("접속대기중");
                Socket s =ss.accept();

                //서버에 접속함....
                ChatService service = new ChatService(s);
                connList.add(service);

                service.allMessageSend("*MG$"+service.id+"님이 접속하셨습니다."); //접속알림 메세지
                service.allMessageSend("$CN#"+connList.size());//접속자수
                service.allUserListSend();//전체 접속자 리트스 보내기

                service.start();

            }

        }catch(Exception e) {
            System.out.println("ServerSocket 객체생성 에러발생....");
            e.printStackTrace();
        }
    }

    //접속자 정보를 가질 객체
    class ChatService extends Thread {
        Socket s;
        String id;
        BufferedReader br;
        PrintWriter pw;

        ChatService(){}
        ChatService(Socket s){
            this.s = s;
            id = s.getInetAddress().getHostAddress();//id

            try {
                //클라이언트가 보낸문자를 받는 객체
                br = new BufferedReader(new InputStreamReader(s.getInputStream()));
                //서버에서 클라이언트로 문자 보내는 객체
                pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
            }catch(Exception e) {
                System.out.println("ChatService 생성자 메소드 에러");
            }
        }

        //클라이언트가 서버로 보내느 문자받기
        public void run() {
            while(true) {
                try {
                    String msg = br.readLine();
                    if(msg != null && !msg.equals("")) {
                        allMessageSend("*MG$"+id+"님"+msg);
                    }
                }catch(Exception e) {

                }
            }
        }
        //모든 접속자에게 문자보내기
        public void allMessageSend(String msg) {
            System.out.println(msg);

            for(int i=0; i<connList.size(); i++) {
                ChatService cs = connList.get(i);
                try {
                    cs.pw.println(msg);
                    cs.pw.flush();
                }catch(Exception e) {
                    //클라이언트에게 Output중 예외가 발생하면 해당 클라이언트는 접속이 종료됨.
                    connList.remove(i);
                    i--;
                }
            }
        }
        //서버에서 클라이언트에게 전체 접속자 리스트 보내기
        public void allUserListSend() {
            String user = "@LI*";
            for(int i=0; i<connList.size(); i++) {
                user += connList.get(i).id+"/";
            }
            allMessageSend(user);
        }
    }

    public static void main(String[] args) {

        new ChatServer();
    }

}