package Data_Net.Data0721.ChatClient;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UnicasteFileSend extends JFrame implements ActionListener {
JButton btn = new JButton("파일보내기");
    public UnicasteFileSend(){
        add(btn);
        setSize(400,300);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        btn.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fc = new JFileChooser();
        int state =fc.showOpenDialog(this);
        if(state==0)
        {
            try {
                DatagramSocket ds = new DatagramSocket();
                InetAddress ia = InetAddress.getByName("192.168.0.5");

                File f = fc.getSelectedFile();//경로 + 파일명
                FileInputStream fis = new FileInputStream(f);
                String filename = "FN##"+f.getName();

                DatagramPacket dp = new DatagramPacket(filename.getBytes(),filename.getBytes().length,ia,16000);
                ds.send(dp);

                //파일내용 보내기기
                while (true) {
                    byte fileContent[] = new byte[512];
                    fileContent[0] = '$';
                    fileContent[1] = '%';
                    fileContent[2] = '#';
                    fileContent[3] = '$';

                    int cnt = fis.read(fileContent, 4, 508);
                    if (cnt <= 0) break;
                    dp = new DatagramPacket(fileContent, cnt + 4, ia, 16000);
                    ds.send(dp);
                    System.out.println("cnt===>"+cnt+"bytes");
                }
                fis.close();
            }catch (Exception ae) {
                System.out.println("잘 안됬습니다.");
            }
        }
    }

    public static void main(String[] args) {
        new UnicasteFileSend();
    }


}
