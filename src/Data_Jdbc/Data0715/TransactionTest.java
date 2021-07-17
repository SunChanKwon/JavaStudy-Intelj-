package Data_Jdbc.Data0715;

import java.sql.SQLException;

public class TransactionTest extends  DBConnection{

    public TransactionTest() {
        try {
            dbConn();
//commit을 하기전에 트랜잭션을 해제해야 한다.
            conn.setAutoCommit(false);

            int abank = -5000,bbank=5000;
            //출금

            sql ="insert into a_bank(num,money) values(a_number.nextval,?)";
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1, abank);
            int cnt = pstmt.executeUpdate();

            if(cnt >0){
                System.out.println(Math.abs(abank) +"원이 출금되었습니다");
            }else
            {
                System.out.println("출금을 실패하였습니다");
            }
            //if(cnt>0){ throw new Exception(); }
            //입금
            sql ="insert into a_bank(num,money) values(b_number.nextval,?)";
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1, bbank);
            int cnt2 = pstmt.executeUpdate();

            if(cnt2 >0){
                System.out.println(Math.abs(abank) +"원이 입금금되었습니다");
           }else
            {
                System.out.println("출금을 실패하였습니다");
            }
            conn.commit();
        }catch (Exception e)
        {
            try {
                conn.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            dbClose();
        }
    }

    public static void main(String[] args) {
new TransactionTest();
    }
}
