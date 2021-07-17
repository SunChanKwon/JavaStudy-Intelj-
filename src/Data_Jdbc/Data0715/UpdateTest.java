package Data_Jdbc.Data0715;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class UpdateTest {
    static {
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");

        } catch (ClassNotFoundException c) {
            System.out.println("드라이버로딩 에러");
        }
    }
    Connection conn =null;
    ResultSet rs=null;
    PreparedStatement pstmt=null;
    String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
    String id  = "scott";
    String pw  = "tiger";

    public UpdateTest(){

        try{
            conn = DriverManager.getConnection(dbUrl,id,pw);
            String sql ="update emp set sal=sal*1.1 where DEPTNO=30";
            pstmt = conn.prepareStatement(sql);

            int cnt = pstmt.executeUpdate();
            if(cnt >0){
                System.out.println(cnt + "개의 레코드가 추가 되었습니다");
            }else
            {
                System.out.println("레코드가 추가 실패하였니다");
            }

        } catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                if(pstmt!=null)pstmt.close();
                if(conn!=null)conn.close();
            }catch (Exception ee)
            {
                ee.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new UpdateTest();

    }
}
