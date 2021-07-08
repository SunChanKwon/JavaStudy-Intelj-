package Data0706;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Memo extends JFrame implements ActionListener {
    JMenuBar mb= new JMenuBar();
    JMenu fileMenu = new JMenu("파일");
    JMenuItem newMenuItem = new JMenuItem("새글");
    JMenuItem openMenuItem = new JMenuItem("열기");
    JMenuItem saveMenuItem = new JMenuItem("저장");
    JMenuItem endMenuItem = new JMenuItem("종료");
    JMenu editMenuItem = new JMenu("편집");
    JMenuItem cutMenuItem = new JMenuItem("오려두기");
    JMenuItem copyMenuItem = new JMenuItem("복사하기");
    JMenuItem pastMenuItem = new JMenuItem("붙여넣기");
    JMenu runMeun = new JMenu("실행");
    JMenuItem chromMenuItem = new JMenuItem("크롬");
    JMenuItem edtiplusMenuItem = new JMenuItem("에디트플러스");
    JTextArea ta =new JTextArea();
    JScrollPane sp = new JScrollPane(ta);
    public Memo(){
        setJMenuBar(mb);
        mb.add(fileMenu);mb.add(newMenuItem);mb.add(runMeun);

        fileMenu.add(newMenuItem);fileMenu.add(openMenuItem);fileMenu.add(saveMenuItem); fileMenu.addSeparator(); fileMenu.add(endMenuItem);
        //----------------------------------------------------------------------------
//----------------------------------------------------------------------------
        editMenuItem.add(cutMenuItem); editMenuItem.add(copyMenuItem); editMenuItem.add(pastMenuItem);
//----------------------------------------------------------------------------
        runMeun.add(chromMenuItem);   runMeun.add(edtiplusMenuItem);
        add(sp);
        setSize(700,700);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        newMenuItem.addActionListener(this);//asdf
        openMenuItem.addActionListener(this);
        saveMenuItem.addActionListener(this);
        endMenuItem.addActionListener(this);
        cutMenuItem.addActionListener(this);
        copyMenuItem.addActionListener(this);
        pastMenuItem.addActionListener(this);
        chromMenuItem.addActionListener(this);
        edtiplusMenuItem.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object event = e.getSource();
        if(event==endMenuItem)
        {
            System.exit(0);
        }
        else if(event==newMenuItem)
        {
            ta.setText("");
        }
    }

    public static void main(String[] args) {
        new Memo();
    }

}
