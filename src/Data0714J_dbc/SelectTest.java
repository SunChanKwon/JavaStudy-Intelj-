package Data0714J_dbc;

import java.sql.*;

public class SelectTest {
    public SelectTest(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String sql = "select empno,ename,job,to_char(hiredate,'YYYY-MM=DD') hiredate,SAL,COMM,DEPTNO from emp order by ename";
            String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
//            String id  = "scott";
//            String pw  = "tiger";
            Connection conn = DriverManager.getConnection(dbUrl,"scott","tiger");
            PreparedStatement pstmt = conn.prepareStatement(sql);


            ResultSet rs = pstmt.executeQuery();

            while (rs.next())
            {
                int empno= rs.getInt(1);
                String ename = rs.getString(2);
                String job = rs.getString("job");
                String hiredate = rs.getString(4);
                double sal = rs.getDouble(5);
                double comm = rs.getDouble(6);
                int deptno = rs.getInt(7);

                System.out.println(empno + ", "+ename+ ", "+job+ ", "+hiredate + ", "+sal+ ", "+comm+ ", "+deptno);
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
