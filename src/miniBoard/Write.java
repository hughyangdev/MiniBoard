package miniBoard;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

public class Write extends JFrame {

	JPanel p = new JPanel(); // North ����, �󺧺���
	JPanel pCenter = new JPanel(); // Center ����, pC2, pC3 ����
	JPanel pC2 = new MyJPanel(0,0,0,0); // �����, TextField ����
	JPanel pC3 = new JPanel(); // TextArea ����
	JPanel pSouth = new JPanel();// South ����, ��ư����
	
	//JLabel ���� �ִ� �� �ּ�
	JLabel proper,subtitlename;
	
	//�Խñ� ����, �ۼ� ����  -> lst2
	JTextField subtitle;
	JTextArea substance;
	
	//�Խñ� ����, �ۼ� ����  -> lst3
	JTextField subtitle2;
	JTextArea substance2;
	
	//��ư ����
	JButton btEnter, btReset, btExit;
   
	public Write() {
		super("::Write::");
		Container cp = getContentPane();
		
		// p, �� ���� -> p�� ���� -> ��ü�г� ���� ����
		p.setBackground(new Color(255,231,231));
		proper = new JLabel("�Խñ� �ۼ�");
		p.add(proper);
		cp.add(p, "North");
		
		// pCenter ������ ���� ó��
		pCenter.setLayout(new BorderLayout());
		pCenter.setBackground(new Color(255,231,231));
		cp.add(pCenter,"Center");
		
		// �߾��гο� pC2, pC3 ����
	    pCenter.add(pC2,"North");
		pCenter.add(pC3,"Center");
		
		// pC2 ���� -> ��, TextField ���� �� ����
		subtitlename = new JLabel("���� : ");
		subtitle = new JTextField(25);
		subtitle.setBackground(new Color(255,231,231));
		subtitle.setBorder(new LineBorder(Color.black,2));
		pC2.setBackground(new Color(255,231,231));
		pC2.add(subtitlename);
		pC2.add(subtitle);
		
		// pC3 ���� -> TextArea ����
		substance = new JTextArea(20,40);
		substance.setBackground(new Color(255,231,231));
		substance.setBorder(new LineBorder(Color.black,2));
		JScrollPane js = new JScrollPane(substance);
		js.setBackground(new Color(255,231,231));
		pC3.setBackground(new Color(255,231,231));
		pC3.add(js);
		
		// pSouth ������ ���� ó��
		pSouth.setBackground(new Color(255,231,231));
		cp.add(pSouth,"South");
		
		// ��ư ���� �� �г� ����
		btEnter = new JButton("Complete");
		btReset = new JButton("Reset");
		btExit = new JButton("Exit");
      	btEnter.setPreferredSize(new Dimension(100,30));
      	btReset.setPreferredSize(new Dimension(100,30));
      	btExit.setPreferredSize(new Dimension(100,30));
      	btEnter.setBorder(new LineBorder(new Color(100,200,255), 1));
      	btReset.setBorder(new LineBorder(new Color(100,200,255), 1));
      	btExit.setBorder(new LineBorder(new Color(100,200,255), 1));
      	btEnter.setBackground(new Color(255,231,231));
      	btReset.setBackground(new Color(255,231,231));
      	btExit.setBackground(new Color(255,231,231));
      	pSouth.add(btEnter);
      	pSouth.add(btReset);
      	pSouth.add(btExit);
      	      	
      	// btEnter ��ư �̺�Ʈ�� Sub1���� ó��
      	// btReset ��ư �̺�Ʈ ó��
      	btReset.addActionListener((e)->{
      		subtitle.setText("");
			substance.setText("");
			subtitle.requestFocus();
      	});
      	// btExit ��ư �̺�Ʈ ó��
      	btExit.addActionListener((e)->{
      		subtitle.setText("");
			substance.setText("");
      		setVisible(false);
			dispose();
      	});
      	
      	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      	
	} // ������-------------------
   
} // Write Ŭ���� - ����, �� �ۼ�
