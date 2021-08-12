package Data_Jdbc.Data0812;

import oracle.jdbc.OracleType;
import oracle.jdbc.OracleTypes;

import java.sql.CallableStatement;
import java.sql.ResultSet;

public class SelectAllProcedure extends DBCON{

    public SelectAllProcedure(){

    }
    public void start()
    {
        try
        {
            dbConn();
            sql ="{call mem_all_select(?)}";
            CallableStatement cstmt = conn.prepareCall(sql);
            
            //sql create or replace procedure mem_all_select(p_result out sys_refcursor) --프로시저
            //    is
            //begin
            //    open p_result for
            //        select mem_no, username, tel, email, addr, write_date from member order by mem_no;
            //end;
            //
            //select MEM_NO, USERNAME, TEL, EMAIL, ADDR, WRITE_DATE from MEMBER order by MEM_NO;
            cstmt.registerOutParameter(1, OracleTypes.CURSOR);

            cstmt.executeLargeUpdate();

            rs=(ResultSet)cstmt.getObject(1); //resultset으로 함
            while (rs.next())
            {
                System.out.printf("%d %s %s %s %s %s \n",
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6));
            }

        }catch (Exception a)
        {
            a.printStackTrace();
        }
        finally {
            dbClose();
        }
    }

    public static void main(String[] args) {
        new SelectAllProcedure().start();
    }
}
