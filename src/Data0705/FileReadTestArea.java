package Data0705;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FileReadTestArea extends JFrame implements ActionListener {
    JButton btn = new JButton("클릭하세요");
    JTextArea ta = new JTextArea("클릭하세요");
    JScrollPane sp;

    public FileReadTestArea(){
        add(BorderLayout.NORTH,btn);

        sp = new JScrollPane(ta);
        add(sp);

        setSize(600,600);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        btn.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae)
    {
        try {
            File f = new File("D://testFile/abcd.txt");
            FileReader fr = new FileReader(f); //예외처리 해결해줘야됨
            BufferedReader br =new BufferedReader(fr); //한줄을 읽어서 해결해주어야 한다.
            
            while (true)
            {
                String data = br.readLine();

                if(data==null)
                {
                    break;
                }
                ta.append(data+"\n");//text 필드에 넣어줌
            }

        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new FileReadTestArea();
    }
}
