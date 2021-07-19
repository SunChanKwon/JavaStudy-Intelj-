package Data_Jdbc.Data0719;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBCON {
	//����̺�ε�
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception e) {
			System.out.println("jdbc ����̺� �ε� ����");
			e.printStackTrace();
			
		}
	}
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String name = "c##scott";
	String pwd = "tiger";
	
	public DBCON() {
		
	}
	//db����
	public void dbConn() {
		try {
			conn = DriverManager.getConnection(url,name,pwd);
		}catch(Exception e) {
			System.out.println("�����ͺ��̽� ���� ����.....");
			e.printStackTrace();
		}
	}
	//db�ݱ�
	public void dbClose() {
		try {
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}catch(Exception e) {
			System.out.println("�����ͺ��̽� �ݱ� ����....");
			e.printStackTrace();
		}
	}
	

}
