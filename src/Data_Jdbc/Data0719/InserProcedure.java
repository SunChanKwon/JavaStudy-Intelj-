package Data_Jdbc.Data0719;

import Data_Jdbc.Data0715.InsertTest;

import java.sql.CallableStatement;
import java.sql.Types;

public class InserProcedure extends DBCON{

    public InserProcedure(){
        try {
        dbConn();
        sql ="{call Member_insert(?,?,?)}";
        CallableStatement cstmt = conn.prepareCall(sql);
        cstmt.setString(1,"장영길");
        cstmt.setString(2,"010-8888-7888");
        cstmt.registerOutParameter(3, Types.INTEGER);
        cstmt.executeUpdate();

        if(cstmt.getInt(3)==1)
        {
            System.out.println("recode insert succes");
        }
        else
        {
            System.out.println("recode insert fail");
        }
        }catch (Exception e)
        {
            e.printStackTrace();
        }finally {
            dbClose();
        }

    }

    public static void main(String[] args) {
        new InserProcedure();
    }
}
