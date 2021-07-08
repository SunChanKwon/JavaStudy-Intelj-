package Data0708;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.*;

public class TestMemo extends JFrame implements ActionListener,Serializable{
    JMenuBar mb= new JMenuBar();
    JMenu fileMenu = new JMenu("파일");
    JMenuItem newMenuItem = new JMenuItem("새글");
    JMenuItem openMenuItem = new JMenuItem("열기");
    JMenuItem saveMenuItem = new JMenuItem("저장");
    JMenuItem endMenuItem = new JMenuItem("종료");
    //------------------------------------------------------------
    JMenu editMenuItem = new JMenu("편집");
    JMenuItem cutMenuItem = new JMenuItem("오려두기");
    JMenuItem copyMenuItem = new JMenuItem("복사하기");
    JMenuItem pastMenuItem = new JMenuItem("붙여넣기");
    JMenu runMeun = new JMenu("실행");
    JMenuItem chromMenuItem = new JMenuItem("크롬");
    JMenuItem edtiplusMenuItem = new JMenuItem("에디트플러스");
    JTextArea ta =new JTextArea();
    JScrollPane sp = new JScrollPane(ta);

    public static  String buffer;//오려두기 복사할경우 보관할 데이터를 보관할 변수수
   public TestMemo() throws IOException {

       setJMenuBar(mb);
       mb.add(fileMenu);
       mb.add(editMenuItem);
       mb.add(runMeun);

       fileMenu.add(newMenuItem);
       fileMenu.add(openMenuItem);
       fileMenu.add(saveMenuItem);
       fileMenu.addSeparator();
       fileMenu.add(endMenuItem);
       //----------------------------------------------------------------------------
//----------------------------------------------------------------------------
       editMenuItem.add(cutMenuItem);
       editMenuItem.add(copyMenuItem);
       editMenuItem.add(pastMenuItem);
//----------------------------------------------------------------------------
       runMeun.add(chromMenuItem);
       runMeun.add(edtiplusMenuItem);
       fileWrite();
       setShortCut();
       File ff = new File("C://fileTest/memoObject.txt");
       if (ff.exists()) {
           try {
               FileInputStream fis = new FileInputStream(ff);
               ObjectInputStream ois = new ObjectInputStream(fis);
               sp = (JScrollPane) ois.readObject();
               add(sp);
           } catch (Exception e) {

           }
       } else {
           add(sp);
       }

       add(sp);
       setSize(700, 700);
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
            fileWrite();
            System.exit(0);
        }
        else if(event==newMenuItem)
        {
            ta.setText("");
        }

        else if(event==openMenuItem)
        {
            fileOpen();
        }
        else if(event==saveMenuItem)
        {
            fileSave();
        }
        else if(event==cutMenuItem)
        {
            stringcut();
        }
        else if(event==pastMenuItem)
        {
            stringPaste();
        }
        else if(event==copyMenuItem)
        {
            stringCopy();
        }
        else if(event==chromMenuItem)
        {
            processStart("C:/Program Files/Google/Chrome/application/chrome.exe");
        }
        else if(event==edtiplusMenuItem)
        {

        }
    }
    public void fileWrite(){

        try{
            File f = new File("C://fileTest/memoObject.txt");
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this);
            oos.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void processStart(String url){
        Runtime runtime = Runtime.getRuntime();
        try{
            runtime.exec(url);
        }catch (Exception e){}
    }
    public void stringCopy(){
        buffer = ta.getSelectedText();
    }

    public void stringPaste(){
        ta.replaceSelection(buffer);
    }
    public void stringcut()
    {
        buffer = ta.getSelectedText();
        ta.replaceSelection("");
    }
    public void fileSave(){
        JFileChooser fc = new JFileChooser(new File("C://fileTest"));
        int state = fc.showSaveDialog(this);

        if(state==0) {
            try{
                File ff= fc.getSelectedFile();
                FileWriter fw= new FileWriter(ff);
                fw.write(ta.getText());
                fw.close();
            }catch (IOException e)
            {
                System.out.println(e.getMessage());
            }
        }
    }

    public void fileOpen(){
        JFileChooser fc = new JFileChooser(new File("C://fileTest"));

        fc.setMultiSelectionEnabled(true);
        //파이ㅣㄹ을 여러개 한번선택 가능하도록 설정하기 true:다중선택, false :1개 파일만 선택

        FileFilter filter = new FileNameExtensionFilter("자바(*.java)","java","Java","JAVA","JaVa","txt");
        fc.setFileFilter(filter);

        FileFilter filter2 = new FileNameExtensionFilter("텍스트","txt");
        fc.setFileFilter(filter2);

        int choose = fc.showOpenDialog(this);
        if(choose==0) {
            //-----------------------한개만 선택
            try {
                File f = fc.getSelectedFile();
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                ta.setText("");

                while (true)
                {
                    String inData = br.readLine();
                    if(inData==null){
                        break;}
                    ta.append(inData+"\n");
                }
                //-----------------------!!!!!!!!!!!!!!!!!!!!!!!!
//----------------------------------------------다중선택
//                        File[] f = fc.getSelectedFiles();
//                        for(File ff: f)
//                        {
//                            FileReader fr= new FileReader(ff);
//                            BufferedReader br = new BufferedReader(fr);
//                            while(true){
//                                    String txt = br.readLine();
//                                    if(txt==null) {
//                                    break;
//                                    }
//                                    ta.append(txt+"\n");
//                            }
//                            ta.append("---------------\n");
//                        }
            }catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    public void setShortCut(){
        //종료: 단축키로 사용할 키를 E
        //1. 메뉴에 단축키로 사용할 키를 셋팅
        endMenuItem.setMnemonic(KeyEvent.VK_E);
        openMenuItem.setMnemonic(KeyEvent.VK_O);
        //2. mask키 설정
        endMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
        openMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
    }
    public static void main(String[] args) throws IOException {
        new TestMemo();
    }

}