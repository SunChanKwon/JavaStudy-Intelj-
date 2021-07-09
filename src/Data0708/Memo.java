package Data0708;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Memo extends JFrame implements ActionListener{
    JMenuBar mb = new JMenuBar();
    JMenu fileMenu = new JMenu("파일");
    JMenuItem newMenuItem = new JMenuItem("새글");
    JMenuItem openMenuItem = new JMenuItem("열기");
    JMenuItem saveMenuItem = new JMenuItem("저장");
    JMenuItem endMenuItem = new JMenuItem("종료");
    JMenu editMenu = new JMenu("편집");
    JMenuItem cutMenuItem = new JMenuItem("오려두기");
    JMenuItem copyMenuItem = new JMenuItem("복사하기");
    JMenuItem pasteMenuItem = new JMenuItem("붙여넣기");
    JMenu runMenu = new JMenu("실행");
    JMenuItem chromeMenuItem = new JMenuItem("크롬");
    JMenuItem editplusMenuItem = new JMenuItem("에디트플러스");

    JTextArea ta = new JTextArea();
    JScrollPane sp = new JScrollPane(ta);

    public static String buffer;//오려두기, 복사할경우 데이터를 보관할 변수

    public Memo() {
        setJMenuBar(mb);
        mb.add(fileMenu); mb.add(editMenu); mb.add(runMenu);

        fileMenu.add(newMenuItem); fileMenu.add(openMenuItem);fileMenu.add(saveMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(endMenuItem);

        editMenu.add(cutMenuItem);editMenu.add(copyMenuItem);editMenu.add(pasteMenuItem);

        runMenu.add(chromeMenuItem);runMenu.add(editplusMenuItem);


        File ff = new File("C://fileTest/memoObject.txt");
        if(ff.exists()) {//있으면 true 없으면 false
            try {
                FileInputStream fis = new FileInputStream(ff);
                ObjectInputStream ois = new ObjectInputStream(fis);
                sp = (JScrollPane)ois.readObject();
                add(sp);
            }catch(Exception e) {

            }
        }else {
            add(sp);
        }

        //단축키 설정
        setShortCut();


        setSize(700,700);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        newMenuItem.addActionListener(this);
        openMenuItem.addActionListener(this);
        saveMenuItem.addActionListener(this);
        endMenuItem.addActionListener(this);
        cutMenuItem.addActionListener(this);
        copyMenuItem.addActionListener(this);
        pasteMenuItem.addActionListener(this);
        chromeMenuItem.addActionListener(this);
        editplusMenuItem.addActionListener(this);


    }
    public void actionPerformed(ActionEvent ae) {
        Object event = ae.getSource();
        if(event == endMenuItem) {
            fileWrite();
            System.exit(0);

        }else if(event == newMenuItem) {
            ta.setText("");
        }else if(event==openMenuItem) {
            fileOpen();
        }else if(event==saveMenuItem) {
            fileSave();
        }else if(event==cutMenuItem) {
            stringCut();
        }else if(event==pasteMenuItem) {
            stringPaste();
        }else if(event==copyMenuItem) {
            stringCopy();
        }else if(event== chromeMenuItem) {
            processStart("C://Program Files/Google/Chrome/Application/chrome.exe https://www.naver.com");
        }else if(event == editplusMenuItem) {
            processStart("C://Users/KANG/AppData/Local/Programs/Microsoft VS Code/Code.exe");
        }
    }



    public void fileWrite() {
        try {
            File f = new File("C://fileTest/memoObject.txt");
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(sp);
            oos.close();
            fos.close();
        }catch(Exception e) {
        }

    }

    //외부파일 실행하기
    public void processStart(String url) {
        Runtime runtime = Runtime.getRuntime();
        //C://Program Files/Google/Chrome/Application/chrome.exe
        try {
            runtime.exec(url);
        }catch(Exception e) {

        }
    }

    //복사하기
    public void stringCopy() {
        buffer = ta.getSelectedText();
    }

    //붙여넣기
    public void stringPaste() {
        ta.replaceSelection(buffer);
    }
    //오려두기
    public void stringCut() {
        //선택영역의 문자를 buffer변수에 보관하고
        buffer = ta.getSelectedText();

        //선택영역의 문자를 지워야한다.
        ta.replaceSelection("");

    }
    //파일저정하기
    public void fileSave() {
        JFileChooser fc = new JFileChooser(new File("C://testFile"));
        int state = fc.showSaveDialog(this);
        //0:저장, 1취소
        if(state==0) {
            try {
                File ff = fc.getSelectedFile();
                FileWriter fw = new FileWriter(ff);
                fw.write(ta.getText());
                fw.close();
            }catch(IOException e) {
                System.out.println(e.getMessage());
            }
        }

    }



    //파일열기
    public void fileOpen() {
        JFileChooser fc = new JFileChooser(new File("C://fileTest"));

        //파일을 여러개 한번선택가능하도록 설정하기
        fc.setMultiSelectionEnabled(true);

        //필터링(파일명)
        FileFilter filter = new FileNameExtensionFilter("자바(*.java)", "java","Java","JAVA","JaVa");
        fc.setFileFilter(filter);

        FileFilter filter2 = new FileNameExtensionFilter("클래스", "class");
        fc.setFileFilter(filter2);

        //열기          부모컨테이너
        // 열기:0 취소1
        int choose = fc.showOpenDialog(this);
        if(choose==0) {
            try {
                ta.setText("");//이전에 표시된 내용이 있을 경우 지운다

                //선택한 파일명과 파일경로 얻어오기
                File f = fc.getSelectedFile();
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                while(true) {
                    String inData = br.readLine();
                    if(inData == null) break;
                    ta.append(inData+"\n");
                }

            /*
            //파일이 여러개 선택했을때
            File[] f = fc.getSelectedFiles();
            for(File ff : f) {
               FileReader fr = new FileReader(ff);
               BufferedReader br = new BufferedReader(fr);
               while(true) {
                  String txt = br.readLine();
                  if(txt==null)break;
                  ta.append(txt+"\n");
               }
               ta.append("--------------------------------------------------------------------------------------\n");
            }*/
            }catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

    //단축키 설정하기
    public void setShortCut() {
        //종료 : 단축키로 사용할 키를 E
        //1.메뉴에 단축키로 사용할 키를 셋팅
        endMenuItem.setMnemonic(KeyEvent.VK_E);
        //2. mask키 설정                              단축키      , mask
        endMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK));

        //열기메뉴
        openMenuItem.setMnemonic(KeyEvent.VK_O);
        openMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,ActionEvent.CTRL_MASK));


    }



    public static void main(String[] args) {
        new Memo();
    }

}