package Data0713;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
    JToggleButton boldBtn = new JToggleButton(" A "); //진하게
    JToggleButton italicBtn = new JToggleButton(" A "); //기울임꼴
    JComboBox<String> fontCombo = new JComboBox<String>();
    JComboBox<Integer> sizeCombo = new JComboBox<Integer>();
    DefaultComboBoxModel<String> fontMdel = new DefaultComboBoxModel<String>();
    DefaultComboBoxModel<Integer> sizeModel = new DefaultComboBoxModel<Integer>();

    int bold = 0; //1 -> 0
    int italic = 0; // 2 -> 0

    JButton calbtn = new JButton("달력");
    public JInternalFrameTest() {
        tb.add(openBtn);
        tb.add(saveBtn);
        tb.add(foreColor);

        tb.add(boldBtn);
        tb.add(italicBtn);

        boldBtn.setFont(new Font("Arial", Font.BOLD, 14));
        italicBtn.setFont(new Font("Arial", Font.ITALIC, 14));
        tb.add(boldBtn);
        tb.add(italicBtn);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String fontName[] = ge.getAvailableFontFamilyNames();
        fontMdel = new DefaultComboBoxModel<String>(fontName);
        fontCombo.setModel(fontMdel);
        tb.add(fontCombo);


        for (int size = 8; size < 100; size += 2) {
            sizeModel.addElement(size);
        }

        sizeCombo.setModel(sizeModel);
        sizeCombo.setSelectedItem(12);
        tb.add(sizeCombo);
        add(BorderLayout.NORTH, tb);
        tb.add(calbtn);
        add(dp);
        if1 = new JInternalFrame();
        if1.setSize(300, 200);
        if1.setVisible(true);
        dp.add(if1);
//-------//-------//-------//-------//-------//-------//-------
        if2 = new JInternalFrame("메모장", true);
        if2.add(new JScrollPane(new JTextArea()));
        if2.setBounds(100, 200, 500, 400);
        if2.setVisible(true);
        dp.add(if2);  //이동이 가능한 메모장
        //-------//-------//-------//-------//-------//-------//-------
        if3 = new JInternalFrame("계산기", true, true, true, true);
        if3.add(new CalculatorEx2());
        if3.setSize(400, 350);
        if3.setVisible(true);
        dp.add(if3);

        setSize(1200, 1000);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        try {
            if3.setSelected(true);
            //계산기 프레임 활성화 시키기
        } catch (PropertyVetoException e) {
            System.out.println("예외처리로 드러옴 확인해보시오");
        }

        openBtn.addActionListener(this);
        saveBtn.addActionListener(this);
        foreColor.addActionListener(this);
        boldBtn.addActionListener(this);
        italicBtn.addActionListener(this);
        fontCombo.addActionListener(this);
        sizeCombo.addActionListener(this);
        calbtn.addActionListener(this);

        JInternalFrameTest ift = this;//같은 내용으로 사용하였다.
        addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent we)
        {
            JOptionPane op = new JOptionPane();
            int que = op.showConfirmDialog(ift,"저장하시겠습니까?","저장확인",JOptionPane.YES_NO_CANCEL_OPTION);
            if(que== JOptionPane.YES_OPTION){ //YES==0
                fileSave();
                dispose();
                System.exit(0);
                //저장후 종료
            }
            else if(que == JOptionPane.NO_OPTION){
                //종료
            }
            else if(que == JOptionPane.CANCEL_OPTION){
                //아무일도 안함
            }
        }
        });

    }


    @Override
    public void actionPerformed(ActionEvent ae) {
    Object event = ae.getSource();
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
        else if(event ==  calbtn)
        {
            getCalendarDialog();
        }
        else if(event instanceof JToggleButton) {
            if (event == boldBtn) {
                if (boldBtn.isSelected()) {
                    bold = 1;
                } else {
                    bold = 0;
                }
                fontSetting();
            }
        }
        else if(event==italicBtn)
        {
            if(italicBtn.isSelected())
            {
                italic = 2;
            }
            else
            {
                italic=0;
            }
            fontSetting();
        }
        else if(event instanceof  JComboBox)
        {
            if(event == fontCombo || event == sizeCombo)
            {
                fontSetting();
            }

        }
    }

    public void getCalendarDialog(){
        SwingCalendar2 cal = new SwingCalendar2();
        JDialog dialog = new JDialog(this,"달력",true);
        dialog.add(cal);
        dialog.setSize(400,350);
        dialog.setVisible(true);

    }
    public void fontSetting() {
        //DeskTop에 선택된 JInternalFrame을 구한후 JTextArea얻어오기
        JInternalFrame activeIf = dp.getSelectedFrame();
        JTextArea ta = (JTextArea)activeIf.getFocusOwner();

        ta.setFont(new Font((String)fontCombo.getSelectedItem(), bold+italic, (Integer)sizeCombo.getSelectedItem()));
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
