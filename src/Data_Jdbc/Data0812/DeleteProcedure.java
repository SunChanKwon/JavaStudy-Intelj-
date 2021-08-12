package Data_Jdbc.Data0812;

import java.sql.CallableStatement;
import java.sql.Types;

public class DeleteProcedure extends DBCON{

    public DeleteProcedure()
    {
        try {
            dbConn();
            //create or replace procedure  mem_del(p_name in member.username%type, p_result out number)
            //       is
            //       begin
            //           p_result:=1;
            //           delete from MEMBER where USERNAME=p_name;
            //           exception
            //           when others then
            //                   p_result:=0;
            //       end;
            sql ="{call mem_del(?,?)}";

            CallableStatement cstmt = conn.prepareCall(sql);
            cstmt.setString(1,"홍길동");
            cstmt.registerOutParameter(2, Types.INTEGER);

            cstmt.executeUpdate();
            
            if(cstmt.getInt(2)==1)
            {
                System.out.println("삭제성공");
            }
            else
            {
                System.out.println("삭제 실패");
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            dbClose();
        }

    }
    public static void main(String[] args) {
       new DeleteProcedure();
    }
}
