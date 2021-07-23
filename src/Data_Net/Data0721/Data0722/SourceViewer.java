package Data_Net.Data0721.Data0722;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.Buffer;
import java.util.InputMismatchException;
import java.util.jar.JarFile;

public class SourceViewer extends JFrame implements ActionListener {

    JPanel pane = new JPanel(new BorderLayout());
    JLabel lbl = new JLabel("URL");
    JTextField tf = new JTextField();
    JButton btn = new JButton("소스보기");

    JTabbedPane tpane = new JTabbedPane();
    public SourceViewer(){
        pane.add(BorderLayout.WEST,lbl);
        pane.add(tf);
        pane.add(BorderLayout.EAST,btn);
        add(BorderLayout.NORTH,pane);

        add(tpane);

        setSize(800,800);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        tf.addActionListener(this);
        btn.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent ae) {
        Object obj = ae.getSource();
        if(obj == tf|| obj==btn){
            startSourceView();
        }
    }

    public void startSourceView() {
        String urlAddr = tf.getText();
        if(!tf.getText().equals("")){
            try {
                JTextField ta = new JTextField();
                JScrollPane sp = new JScrollPane(ta);

                tpane.addTab(urlAddr, sp);
                tpane.setSelectedComponent(sp);

                URL url = new URL(urlAddr);
                URLConnection connection = url.openConnection();
                connection.connect();
                String headerType = connection.getContentType();
                int idx = headerType.indexOf("charset");
                String encdoe = headerType.substring(idx+8);

                BufferedReader br = new BufferedReader( new InputStreamReader(url.openStream(),encdoe));

                while(true) {
                    String data = br.readLine();
                    if (data == null) {
                        break;
                    }
                   // ta.append(data+"\n");
                }
                 br.close();
                tf.setText("");
            }catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
    new SourceViewer();
    }

}
