package Data_Jdbc.Data0719;

import Data_Jdbc.Data0719.MemberVO;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class MemberMain extends JFrame implements ActionListener{
	//JFrame - North
	JPanel formPane = new JPanel(new BorderLayout());
		JPanel formWestPane = new JPanel(new GridLayout(6,1));
			String formLbl[] = {"��  ȣ","��  ��","����ó","�̸���","��  ��","�����"};
		JPanel formCenter = new JPanel(new GridLayout(6,1,5,5));
			JTextField[] formTf = {new JTextField(5), new JTextField(15),new JTextField(20),
					new JTextField(30),new JTextField(45),new JTextField(20)};
			
	//JFrame - Center
	JPanel centerPane = new JPanel(new BorderLayout());
		JPanel btnList = new JPanel(new GridLayout(1,0,3,3));
			JButton[] btn = {new JButton("��ü���"), new JButton("����߰�"),
					new JButton("�������"), new JButton("�������"),new JButton("�������"), 
					new JButton("����"),	new JButton("��������"), new JButton("�����б�")};
		DefaultTableModel model;
		String title = "��ȣ/�̸�/����ó/�̸���/�ּ�/�����";
		JTable memberList;
		JScrollPane sp;
			
		//JFrame - South
		JPanel southPane = new JPanel();
			JLabel searchLbl = new JLabel("�̸�");;
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
		southPane.add(searchLbl);
		southPane.add(searchWord);
		southPane.add(searchBtn);
		
		searchBtn.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae) {
		String eventBtn = ae.getActionCommand();
		if(eventBtn.equals("����߰�")) {
			memberInsert();
		}else if(eventBtn.equals("�������")) {
			formDataClear();
		}else if(eventBtn.equals("����")) {
			System.exit(0);
		}else if(eventBtn.equals("�������")) {
			memberUpdate();
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
