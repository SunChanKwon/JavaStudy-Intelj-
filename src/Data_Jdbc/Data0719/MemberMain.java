package Data_Jdbc.Data0719;

import Data0701.JcomboBoxTest;
import Data_Jdbc.Data0719.MemberVO;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Workbook;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MemberMain extends JFrame implements ActionListener{
	//JFrame - North
	JPanel formPane = new JPanel(new BorderLayout());
		JPanel formWestPane = new JPanel(new GridLayout(6,1));
			String formLbl[] = {"번호","이름","전화번호","이메일","주소","등록일"};
		JPanel formCenter = new JPanel(new GridLayout(6,1,5,5));
			JTextField[] formTf = {new JTextField(5), new JTextField(15),new JTextField(20),
					new JTextField(30),new JTextField(45),new JTextField(20)};

	//JFrame - Center
	JPanel centerPane = new JPanel(new BorderLayout());
		JPanel btnList = new JPanel(new GridLayout(1,0,3,3));
			JButton[] btn = {new JButton("전체목록"), new JButton("사원추가"),
					new JButton("사원수정"), new JButton("사원 삭제"),new JButton("폼지우기"),
					new JButton("종료"),	new JButton("엑셀쓰기"), new JButton("엑셀읽기")};
		DefaultTableModel model;
		String title = "번호/이름/연락처/이메일/주소/등록일";
		JTable memberList;
		JScrollPane sp;

		//JFrame - South
		JPanel southPane = new JPanel();

		DefaultComboBoxModel<String> searchModel =new DefaultComboBoxModel<String>();
		JComboBox<String> searchKey = new JComboBox<String>(searchModel);
		
		JLabel searchLbl = new JLabel("이름");;
			JTextField searchWord = new JTextField(15);
			JButton searchBtn = new JButton("Search");


	public MemberMain() {
		super("ȸ�������ý���");

		//Frame - North
		setForm();
		//Frame - Center
		setButtonJTable();
		//Frame - Soutn
		setSearchForm();

		setSize(800,600);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		memberAllList();

	}
	//�����ͺ��̽����� ȸ����ü ���(�̸�������) �������� - JTable�� ����� �����ش�.
	public void memberAllList() {
		//���� JTable�� ����� ����� ���� ����Ʈ�� ����Ѵ�.
		model.setRowCount(0);

		MemberDAO dao = new MemberDAO();
		List<MemberVO> list = dao.allRecord();

		//�÷��ǿ� �ִ� vo�� get�Ͽ� JTable�� ������� �߰��Ѵ�.
		for(int i=0;i<list.size();i++) {
			MemberVO vo = list.get(i);
			Object[] obj = {vo.getMem_no(),vo.getUsername(),vo.getTel(),vo.getEmail(),
					vo.getAddr(),vo.getWrite_date()};
			model.addRow(obj);
			}
		}

	//Frame-North
	public void setForm() {
		add(BorderLayout.NORTH,formPane);
			formPane.add(BorderLayout.WEST,formWestPane);
				for(int i=0; i<formLbl.length; i++) {
					JLabel lbl = new JLabel(formLbl[i]);
					formWestPane.add(lbl);
				}
				formPane.add(BorderLayout.CENTER,formCenter);
					for(int i=0; i<formTf.length;i++) {
						JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT)); // jpanel �� �ѹ��� ��ƾ� ��..
						p.add(formTf[i]);
						formCenter.add(p);
						if(i==0 || i==5) formTf[i].setEditable(false);// ù��°�� �������ϰ� ��Ȱ��ȭ
					}
	}
	//Frame-Center
	public void setButtonJTable() {
		add(centerPane);
			centerPane.add(BorderLayout.NORTH,btnList);
				for(int i=0;i<btn.length;i++) {
					btnList.add(btn[i]);
					//�̺�Ʈ���
					btn[i].addActionListener(this);
				}
	//JTable							����
			model = new DefaultTableModel(title.split("/"),0);
			memberList = new JTable(model);
			sp = new JScrollPane(memberList);
			centerPane.add(sp);

			memberList.addMouseListener(new JTableMouseEventProcess(formTf, memberList));
	}
	//Frame - South
	public void setSearchForm() {
		add(BorderLayout.SOUTH,southPane);
		
		searchModel.addElement("이름");
		searchModel.addElement("전화번호");
		searchModel.addElement("주소");
		southPane.add(searchKey);
		southPane.add(searchBtn);
		
		//southPane.add(searchLbl);
		southPane.add(searchWord);
		southPane.add(searchBtn);

		searchBtn.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae) {
		String eventBtn = ae.getActionCommand();
		if(eventBtn.equals("사원추가")) {
			memberInsert();
		}else if(eventBtn.equals("폼지우기")) {
			formDataClear();
		}else if(eventBtn.equals("종료")) {
			System.exit(0);
		}else if(eventBtn.equals("사원수정")) {
			memberUpdate();
		}else if(eventBtn.equals("사원삭제"))
		{
			memberDelete();
		}
		else if(eventBtn.equals("Serch"))
		{
			memberSearch();
		}
		else if(eventBtn.equals("전체목록"))
		{
			memberAllList();
		}
		else if(eventBtn.equals("엑셀쓰기"))
		{
			excelWrite();
		}
		else if(eventBtn.equals("엑셀읽기"))
		{
			excelRead();
		}
	}

	public void excelRead()
	{
		JFileChooser fc =new JFileChooser();//선택하게 만듬
		int state = fc.showSaveDialog(this);
		MemberDAO dao = new MemberDAO();

		if(state==0)
		{
			File f = fc.getSelectedFile();

			try {
				FileInputStream fis = new FileInputStream(f);

				POIFSFileSystem poi = new POIFSFileSystem(fis);

				HSSFWorkbook workbook = new HSSFWorkbook(poi);

				HSSFSheet sheet = workbook.getSheet("회원목록");

				//시트의 행의수

				model.setRowCount(0);
				int rows = sheet.getPhysicalNumberOfRows();
				for(int r=1; r<rows; r++)
				{
					HSSFRow row =sheet.getRow(r); //칸의수가 들어가져 있다.
					int cols = row.getPhysicalNumberOfCells();//열수
					Vector v=new Vector();
					for(int c=0; c<cols; c++){

						if(c==0){
						v.add(row.getCell(c).getNumericCellValue());
						}
						else {
							v.add(row.getCell(c).getStringCellValue());
						}
					}
					model.addRow(v);
				}
				poi.close();
				fis.close();
			} catch (Exception e) {
				System.out.println("파일 오류입니다. 확인해주세요요");
			}

		}




		dao.excelInsert();
	}

	public void excelWrite(){
		JFileChooser fc =new JFileChooser();

		int state = fc.showSaveDialog(this);
		if(state==0)
		{
			File f = fc.getSelectedFile();

			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFSheet sheet = workbook.createSheet("회원목록");

			//제목 셋팅
			HSSFRow rowTitle = sheet.createRow(0);

			String[] excellTitle = title.split("/");

			for(int i = 0; i<excellTitle.length; i++)
			{
				rowTitle.createCell(i).setCellValue(excellTitle[i]);
			}

			int rows = memberList.getRowCount(); //5
			int cols = memberList.getColumnCount();//6
			for(int i=0; i<rows; i++)
			{
				HSSFRow row = sheet.createRow(rows);
				for(int j=0; j<cols; j++)
				{
					if(j==0)
					{
						row.createCell(j).setCellValue((int) memberList.getValueAt(i,j));
					}
					else
					{
						row.createCell(j).setCellValue((String) memberList.getValueAt(i,j));
					}
				}
			}

			//엑셀로 파일로 쓰기ㅣ

				try {
					FileOutputStream fos = new FileOutputStream(f);
					workbook.write(fos);
				} catch (Exception e) {
					System.out.println("엑셀로 쓰기 에러");
				}
			}
	}

	public void memberSearch(){

		String search = searchWord.getText();
		if(search != null && !search.equals(""))
		{
			String searchField = (String)searchKey.getSelectedItem();
			String fieldName = "";
			if(searchField.equals("이름"))
			{
				fieldName = "username";
			}
			else if(searchField.equals("전화번호"))
			{
				fieldName="tel";
			}
			else if(searchField.equals("주소"))
			{
				fieldName="addr";
			}

			MemberDAO dao = new MemberDAO();
			List<MemberVO> list = dao.searchRecord(search,fieldName);

			setMemberModel(list);
		}
	}

	public void setMemberModel(List<MemberVO> list) {
		model.setRowCount(0);

		for(int i =0; i<list.size(); i++)
		{
			MemberVO vo =list.get(i);
			Object[] obj = {vo.getMem_no(),vo.getUsername(),vo.getTel(),
							vo.getEmail(),vo.getAddr(),vo.getWrite_date()};
			model.addRow(obj);
		}
	}

	public void memberDelete(){
		//삭제할 사원번호
		String delNum = formTf[0].getText();
		if(delNum==null || delNum.equals("")){
			JOptionPane.showConfirmDialog(this,"삭제할 사원을 선택후 삭제 버튼을 클릭하세요");
		}else
		{
			MemberDAO dao =new MemberDAO();
			int result = dao.deleteRecord(Integer.parseInt(delNum));
			if(result>0)
			{
				JOptionPane.showMessageDialog(this,delNum+"사원을 삭제하였습니다");
				memberAllList();
				formDataClear();
			}else
			{
				JOptionPane.showMessageDialog(this,delNum+"사원삭제를 실패하였습니다.");
			}

		}
	}
	//�������
	public void memberUpdate() {
		MemberVO vo = new MemberVO();
		vo.setMem_no(Integer.parseInt(formTf[0].getText()));
		vo.setTel(formTf[2].getText());
		vo.setEmail(formTf[3].getText());
		vo.setAddr(formTf[4].getText());

		MemberDAO dao = new MemberDAO();
		int cnt = dao.updateRecord(vo);
		if(cnt>0){//������ ����Ʈ �ٽ� �����ϱ�
			memberAllList();
		}else{	//�������н� �ȳ��޽��� ǥ��
			JOptionPane.showMessageDialog(this, "ȸ������ ���� �����Ͽ����ϴ�.");
		}
	}
	public void memberInsert() {
		//���� �̸��� �Է»������� Ȯ��
		String username=formTf[1].getText();
		if(username==null || username.equals("")) {
			JOptionPane.showMessageDialog(this, "�̸��� �Է��ϼ���.");
		}else {
			MemberVO vo = new MemberVO();
			vo.setUsername(username);
			vo.setTel(formTf[2].getText());
			vo.setEmail(formTf[3].getText());
			vo.setAddr(formTf[4].getText());

			MemberDAO dao = new MemberDAO();
			int cnt = dao.insertRecord(vo);
			if(cnt>0) {//ȸ���߰�
				formDataClear();//ȸ���� �߰��Ǹ� ���� �����͸� �����.
				memberAllList();
			}else {//ȸ���߰�����
				JOptionPane.showMessageDialog(this, "ȸ���߰� �����Ͽ����ϴ�.");
			}
		}
	}
	public void formDataClear() {
		//���� ���� �����.
		for(int i=0; i<formTf.length;i++) {
			formTf[i].setText("");
		}
	}
	public static void main(String[] args) {
		new MemberMain();
	}
}
