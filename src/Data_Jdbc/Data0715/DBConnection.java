package Data_Jdbc.Data0715;

import java.sql.*;

public class DBConnection {
    static {
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    Connection conn;
    PreparedStatement pstmt;
    ResultSet rs;

    String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
    String id  = "scott";
    String pw  = "tiger";
    String sql;

    public DBConnection(){

    }
    public void dbConn(){
        try{
            conn = DriverManager.getConnection(dbUrl,id,pw);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void dbClose(){
        try{
            if(rs!=null){rs.close();}
            if(pstmt!=null){pstmt.close();}
            if(conn!=null){conn.close();}
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
