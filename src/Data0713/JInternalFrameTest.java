package Data0713;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.io.*;

public class JInternalFrameTest extends JFrame implements ActionListener{


        JDesktopPane dp = new JDesktopPane();
        JInternalFrame if1,if2,if3;

        ImageIcon openIcon = new ImageIcon("img/1,jpg");
        ImageIcon saveIcon = new ImageIcon("img/save01.gif");
        JToolBar tb = new JToolBar();
        JButton openBtn = new JButton(openIcon);
    JButton saveBtn = new JButton(saveIcon);
    JButton foreColor = new JButton();

    //글꼴
    JToggleButton boldBtn = new JToggleButton("A"); //진하게
    JToggleButton italicBtn = new JToggleButton("A"); //기울임꼴
    JComboBox<String> fontCombo = new JComboBox<String>();
    JComboBox<Integer> sizeComg = new JComboBox<Integer>();
    DefaultComboBoxModel<String> fontMdel = new DefaultComboBoxModel<String>();
    DefaultComboBoxModel<Integer> sizeModel = new DefaultComboBoxModel<Integer>();


    public JInternalFrameTest() {
        tb.add(openBtn);
        tb.add(saveBtn);
        tb.add(foreColor);
        add(BorderLayout.NORTH,tb);

            add(dp);
            if1 = new JInternalFrame();
            if1.setSize(300,200);
            if1.setVisible(true);
            dp.add(if1);
//-------//-------//-------//-------//-------//-------//-------
            if2 = new JInternalFrame("메모장",true);
            if2.add(new JScrollPane(new JTextArea()));
            if2.setBounds(100,200,500,400);
            if2.setVisible(true);
            dp.add(if2);  //이동이 가능한 메모장
            //-------//-------//-------//-------//-------//-------//-------
            if3 = new JInternalFrame("계산기",true,true,true,true);
            if3.add(new CalculatorEx2());
            if3.setSize(400,350);
            if3.setVisible(true);
            dp.add(if3);

            setSize(1200,1000);
            setVisible(true);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            
            try {
                if3.setSelected(true);
                //계산기 프레임 활성화 시키기
            }catch (PropertyVetoException e)
            {
                System.out.println("예외처리로 드러옴 확인해보시오");
            }

            openBtn.addActionListener( this);
        saveBtn.addActionListener( this);
        foreColor.addActionListener( this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
    Object event = e.getSource();
    if(event instanceof JButton)
        if(event == openBtn)
        {
            fileOpen();
        }
        else if(event == saveBtn)
        {
            fileSave();
        }
        else if(event == foreColor)
        {
            setFontFore();
        }
    }
    public void setFontFore(){
        JColorChooser cc =new JColorChooser(Color.green);
        Color selectColor = cc.showDialog(this,"글자색",Color.BLACK);

        JInternalFrame selectIf = dp.getSelectedFrame();
        JTextArea ta = (JTextArea) selectIf.getFocusOwner();
        ta.setForeground(selectColor);
    }
    public void fileSave() {
        JFileChooser fc =new JFileChooser();
        if(fc.showSaveDialog(this)==0)
        {
            File f = fc.getSelectedFile();
            try
            {
            FileWriter fw= new FileWriter(f);
            JInternalFrame selectIf =dp.getSelectedFrame();

            JTextArea evenTa = (JTextArea) selectIf.getFocusOwner();

            fw.write(evenTa.getText());//매개변수로 넘겨준다.
            fw.close();
            }catch (Exception e)
            {

            }
        }

    }
    public void fileOpen(){
        JFileChooser fc = new JFileChooser();
        //0:열기 1:취소
        if(fc.showOpenDialog(this)==0)
        {
            JTextArea ta = new JTextArea();
            //선택한 파일 객체 얻어오기
            File f = fc.getSelectedFile();

            try{
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                while(true)
                {
                    String readData = br.readLine();
                    if(readData == null)break;
                    ta.append(readData+"\n");
                }
                JScrollPane sp2 = new JScrollPane(ta);
                JInternalFrame if5 = new JInternalFrame(f.getPath(),true,true,true,true);
                if5.add(sp2);
                if5.setSize(500,500);
                if5.setSelected(true);
                if5.setVisible(true);
                dp.add(if5);
                //
            }catch (Exception e)
            {}

        }

    }

    public static void main(String[] args) {
        new JInternalFrameTest();
    }



}
