package Data_Jdbc.Data0812;

import oracle.jdbc.OracleType;
import oracle.jdbc.OracleTypes;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class SelectSerchProcedure extends DBCON{
    Scanner scan = new Scanner(System.in);
    String word;
    public SelectSerchProcedure() {
        try {
            dbConn();
            System.out.println("검색어 입력해주세요");
            word = scan.nextLine();//검색할 이름 검색
            //create or replace procedure  mem_search(p_result out sys_refcursor,
            //p_name in member.username%type)
            //is
            //begin
            //    open p_result for
            //    select mem_no,USERNAME ,tel from MEMBER where username like '%' || p_name || '%' order by USERNAME;
            //end;
            sql = "{call mem_search(?,?)}";
            CallableStatement cstmt = conn.prepareCall(sql);
            cstmt.registerOutParameter(1, OracleTypes.CURSOR);
            cstmt.setString(2, word);

            cstmt.executeLargeUpdate();
            rs = (ResultSet) cstmt.getObject(1);

            while (rs.next()) {
                System.out.printf("%d %s %s\n", rs.getInt(1), rs.getString(2), rs.getString(3));
            }
        }
         catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            dbClose();
        }
    }
    public static void main(String[] args) {
        new SelectSerchProcedure();
    }
}
