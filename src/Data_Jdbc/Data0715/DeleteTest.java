package Data_Jdbc.Data0715;

import java.sql.SQLException;
import java.util.Scanner;

public class DeleteTest extends DBConnection{


    public DeleteTest() {
        try {
            Scanner scan = new Scanner(System.in);
            System.out.print("삭제");
            String name = scan.nextLine();

            dbConn();
            sql = "delete from emp where ename=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);

            int result = pstmt.executeUpdate();
            System.out.println(result + "개의 레코드가 제거됨");
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            dbClose();
        }

    }

    public static void main(String[] args) {
        new DeleteTest();
    }
}
