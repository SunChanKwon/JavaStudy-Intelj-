package Data0707;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector;

public class JListTest extends JFrame implements ActionListener {

    JPanel pane = new JPanel(new GridLayout(2,1));
    JButton leftBtn = new JButton("<--");
    JButton rightBtn = new JButton("-->");

    DefaultComboBoxModel<String> leftModel = new DefaultComboBoxModel<String>();
    JList<String> leftList = new JList<String>(leftModel);
    JScrollPane sp1 = new JScrollPane(leftList);

    DefaultComboBoxModel<String> rightModel = new DefaultComboBoxModel<String>();
    JList<String> rightList = new JList<String>(rightModel);
    JScrollPane sp2 = new JScrollPane(rightList);
    //배열 선언

    String data[]={"사과","포도","망고","파인애플","바나나","체리","키위","오렌지","토마토","수박"};
    String data2="장미/백학/튤립/코스모스/맨드라미";
    public JListTest(){
        for(int i=0; i<data.length; i++)
        {
            leftModel.addElement(data[i]);
        }
        StringTokenizer st = new StringTokenizer(data2,"/");

        while(st.hasMoreTokens())
        {
            rightModel.addElement(st.nextToken());
        }
        pane.add(leftBtn); pane.add(rightBtn);
        add(pane);

        add(BorderLayout.WEST,leftList);
        add(BorderLayout.EAST,rightList);

        setSize(400,500);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        leftBtn.addActionListener(this);
        rightBtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae)
    {
        Object event = ae.getSource();
        if(event == leftBtn)
        {
            listDataChaged(rightList,leftList);// r-> l
        }
        else if(event == rightBtn)//l -> r
        {
            listDataChaged(leftList,rightList);
        }
    }
                               //원데이터   //옮길곳
    public void listDataChaged(JList orgList,JList tarList){
        DefaultListModel<String> orgModel =(DefaultListModel)orgList.getModel();
        DefaultListModel<String> tarModel = (DefaultListModel)tarList.getModel();

        List<String> list = orgList.getSelectedValuesList();

        for(int i=0; i<list.size(); i++)
        {
            tarModel.addElement(list.get(i));
            orgModel.removeElement(list.get(i));
        }
    }
    public static void main(String[] args) {
        new JListTest();
    }
}
