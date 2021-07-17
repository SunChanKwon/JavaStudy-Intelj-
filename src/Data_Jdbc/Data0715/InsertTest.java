package Data_Jdbc.Data0715;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class InsertTest {
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

    public InsertTest(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            System.out.print("사원번호=");
            int empno = Integer.parseInt(br.readLine());
            System.out.println("사원명=");
            String ename = br.readLine();
            System.out.println("급여=");
            int sal = Integer.parseInt(br.readLine());

            String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
            String id  = "scott";
            String pw  = "tiger";
            conn = DriverManager.getConnection(dbUrl,id,pw);

            String sql = "insert into emp(empno,ename,sal,hiredate) values(?,?,?,sysdate)";
            pstmt= conn.prepareStatement(sql);
            //?? 값셋팅
            pstmt.setInt(1,empno);
            pstmt.setString(2,ename);
            pstmt.setInt(3,sal);

            int cnt = pstmt.executeUpdate();

            if(cnt >0){
                System.out.println("레코드가 추가 되었습니다");
            }else
            {
                System.out.println("레코드가 추가 실패하였니다");
            }

            //
        } catch (IOException ie) {
            System.out.println("데이터 입력에러 발생" + ie.getMessage());
        }catch ( SQLException is)
        {
            System.out.println("데이터 입력에러 발생" + is.getMessage());
        }
    }

    public static void main(String[] args) {
        new InsertTest();
    }
}
