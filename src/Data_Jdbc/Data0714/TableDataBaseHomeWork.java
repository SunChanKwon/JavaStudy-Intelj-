package Data_Jdbc.Data0714;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class TableDataBaseHomeWork extends JFrame {
    JTable table;
    JScrollPane sp;
    DefaultTableModel model;
    String title[]={"EMPNO","ENAME","JOB","HIREDATE","SAL","COMM","DEPTNO"};
    Object[][] data;
    int count=0;
    JLabel lbl = new JLabel(" ");

    Connection conn =null;
    ResultSet rs=null;
    PreparedStatement pstmt=null;
    public TableDataBaseHomeWork(){

        model = new DefaultTableModel(data,title);
        table = new JTable(model);
        sp = new JScrollPane(table);
        add(sp);

        DateBaseDateSet();

        add(BorderLayout.SOUTH,lbl);
        setSize(500,400);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    public void DateBaseDateSet(){
        try {



            Class.forName("oracle.jdbc.driver.OracleDriver");
            String sql = "select empno,ename,job,to_char(hiredate,'YYYY-MM=DD') hiredate,SAL,COMM,DEPTNO from emp order by ename";
            String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
            String id  = "scott";
            String pw  = "tiger";
            conn = DriverManager.getConnection(dbUrl,id,pw);
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

        }catch (Exception e) {
           System.out.println(e.getMessage());
        }finally {
            try {
                if (rs != null) {
                    rs.close();
                    System.out.println("rs 객체가 없다");
                }
                if (pstmt != null) {
                    pstmt.close();
                    System.out.println("pstmt 객체가 없다");
                }
                if (conn != null) {
                    conn.close();
                    System.out.println("conn 객체가 없다");
                }
            }catch (SQLException s) {
                System.out.println("닫기 예외 발생함");
             }
         }
        }
    public static void main(String[] args) {

        new TableDataBaseHomeWork();
    }
}

