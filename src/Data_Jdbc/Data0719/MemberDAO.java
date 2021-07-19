package Data_Jdbc.Data0719;

import Data_Jdbc.Data0719.DBCON;
import Data_Jdbc.Data0719.MemberVO;

import java.util.ArrayList;
import java.util.List;

public class MemberDAO extends DBCON {

	public MemberDAO() {
	
	}
	//ȸ����ü����
	public List<MemberVO> allRecord() {
		List<MemberVO> list	= new ArrayList<MemberVO>();
		try {
			//1.db����
			dbConn();
			String sql = "select mem_no, username, tel, email, addr, "
					+ "to_char(write_date,'YYYY-MM-DD')write_date from member order by username asc";
			//2. preparestatement ����
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setMem_no(rs.getInt(1));
				vo.setUsername(rs.getString(2));
				vo.setTel(rs.getString(3));
				vo.setEmail(rs.getString(4));
				vo.setAddr(rs.getString(5));
				vo.setWrite_date(rs.getString(6));
				list.add(vo);
			}
		}catch(Exception e) {
			System.out.println("��üȸ�� ���� �����߻�....");
			e.printStackTrace();
		}finally{
			dbClose();
		}
		return list;
	} 
	//ȸ���߰�
	public int insertRecord(MemberVO vo) {
		int cnt=0;
		try {
			dbConn();
			String sql="insert into member(mem_no,email, addr, username, tel) "
					+ "values(mem_sq.nextval,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  vo.getEmail());
			pstmt.setString(2,  vo.getAddr());
			pstmt.setString(3,  vo.getUsername());
			pstmt.setString(4,  vo.getTel());
			
			cnt = pstmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("ȸ���߰������߻�...");
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return cnt;
	}
	//ȸ������
	public int updateRecord(MemberVO vo) {
	
		int cnt = 0;
		try {
				dbConn();
				
				String sql = "update member set tel=?, email=?, addr=? where mem_no=?";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, vo.getTel());
				pstmt.setString(2, vo.getEmail());
				pstmt.setString(3, vo.getAddr());
				pstmt.setInt(4, vo.getMem_no());
				
				cnt = pstmt.executeUpdate();
			
			}catch(Exception e) {
				System.out.println("ȸ������ ���� �߻�....");
				e.printStackTrace();
			}finally {
				dbClose();
			}
		return cnt;
	}
	//ȸ������
	//ȸ���߰�
	//ȸ���˻�
}
