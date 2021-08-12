package Data_Jdbc.Data0812;

import java.sql.CallableStatement;
import java.sql.Types;

public class UpdateProcedure extends DBCON{

    public  UpdateProcedure()
    {
        try {
            dbConn();
            sql = "{call mem_update(?,?,?,?,?)}";
            
            //create or replace procedure mem_update( -- 프로시져
            //m_mem_no in member.MEM_NO%type,
            //m_tel in member.TEL%type,
            //m_email in member.email%type,
            //m_addr in member.addr%type,
            //m_result out number)
            //is
            //begin
            //    m_result :=1;
            //    update member set tel=m_tel, EMAIL=m_email, addr=m_addr where MEM_NO=m_mem_no;
            //    exception
            //     when others  then
            //        m_result :=0;
            //end;
            //
            //select * from member;
            
            CallableStatement cstmt = conn.prepareCall(sql);
            cstmt.setInt(1,4);
            cstmt.setString(2,"0102740");
            cstmt.setString(3,"2021@kr");
            cstmt.setString(4,"화곡오");
            cstmt.registerOutParameter(5, Types.INTEGER);

            cstmt.executeUpdate();
            if(cstmt.getInt(5)==1)
            {
                System.out.println("recode insert succes");
            }
            else
            {
                System.out.println("recode insert fail");
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
        new UpdateProcedure();
    }
}
