package Data_Net.Data0721.ChatClient;

import javax.swing.*;
import java.awt.*;

public class ChatClient extends JFrame {


    JPanel centerPane = new JPanel(new BorderLayout());
    JPanel connPane = new JPanel(new BorderLayout());
    JTextField connTF = new JTextField();
    JButton connBtn = new JButton("접속");
    JTextArea msgTa = new JTextArea();
    JScrollPane sp = new JScrollPane();

    JPanel msgPane = new JPanel(new BorderLayout());
    JTextField msgTf = new JTextField();
    JButton sendBtn = new JButton("보내기");

    JPanel eastPane = new JPanel(new BorderLayout());
    JLabel title = new JLabel("접속자 리스트");
    DefaultComboBoxModel<String> connModel = new DefaultComboBoxModel<String>();
    JList<String> connList = new JList<String>(connModel);

    JScrollPane connsp = nwe JScrollPane(con)
    JLabel count = new JLabel("현재 : 0 명");

    public ChatClient(){
    add(centerPane);

    centerPane.add(BorderLayout.NORTH,connPane);
    connPane.add(connTF);
    connPane.add("East",connBtn);

    centerPane.add(sp);
    msgTa.setBackground(new Color(255,232,232));

    centerPane.add("South",msgPane);
    msgPane.add(msgTf);
    msgPane.add("East",sendBtn);

    add("East",eastPane);
    eastPane.add("North",title);
    connModel.addElement("     ");
    eastPane.add(connSp);



    setSize(400,500);
    setVisible(true);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);;

    }

    public static void main(String[] args) {
        new ChatClient();
    }
}
