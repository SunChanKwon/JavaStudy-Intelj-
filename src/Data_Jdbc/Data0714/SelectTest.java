package Data_Jdbc.Data0714;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class SelectTest extends JFrame {
        JTable table;
    JScrollPane sp;
    DefaultTableModel model;
    String title[]={"EMPNO","ENAME","JOB","HIREDATE","SAL","COMM","DEPTNO"};
    Object[][] data;
    int count=0;
    JLabel lbl = new JLabel(" ");
    public SelectTest(){

        model = new DefaultTableModel(data,title);
        table = new JTable(model);
        sp = new JScrollPane(table);
        add(sp);

        add(BorderLayout.SOUTH,lbl);
        setSize(500,400);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String sql = "select * from emp";
            String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
            String id  = "scott";
            String pw  = "tiger";
            Connection conn = DriverManager.getConnection(dbUrl,id,pw);
            PreparedStatement pstmt = conn.prepareStatement(sql);


            ResultSet rs = pstmt.executeQuery();

            while (rs.next())
            {
                int empno= rs.getInt("empno");
                String ename = rs.getString("ename");
                String job = rs.getString("job");
                String hiredate = rs.getString("hiredate");
                double sal = rs.getDouble("sal");
                double comm = rs.getDouble("comm");
                int deptno = rs.getInt("deptno");

                System.out.println(empno + ", "+ename+ ", "+job+ ", "+hiredate + ", "+sal+ ", "+comm+ ", "+deptno);
                Object [] row = {empno,ename,job,hiredate,sal,comm,deptno};
                model.insertRow(count,row);
                count++;
            }
            rs.close();
            pstmt.close();
            conn.close();
        }catch (SQLException e) {
            System.out.println("DB계정불일치");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {

        new SelectTest();
    }
}
