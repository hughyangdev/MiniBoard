package miniBoard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

import javax.swing.border.*;

public class Sub2 extends JFrame {

	JPanel p = new JPanel(new BorderLayout());
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel(new BorderLayout());
	JPanel p3 = new MyJPanel();
	JLabel lb1, lb2;
	JTextArea ta;
	JButton btCreate, btClose;
	
	JList<String> lst;
	Vector<String> lstV;
	//DefaultListModel<String> model;

	public Sub2() {
		super("::Sub2::");
		Container cp = getContentPane();
		cp.add(p, "Center");
		p.setBackground(Color.white);
		
		lb1 = new JLabel("BACK");
		lb2 = new JLabel("공지사항", JLabel.CENTER);
		p1.add(lb2);
		p.add(p1, "North");
		
		lstV = new Vector<>();
		ta = new JTextArea(10, 10);
		ta.setFont(new Font("궁서체", Font.PLAIN, 18));
		lst = new JList<>(lstV);
		ta.add(lst);
		
		p2.add(new JScrollPane(lst), "Center");
		p.add(p2, "Center");
		
		btCreate = new JButton("작성");
		btClose = new JButton("종료");
		p3.add(btCreate);
		p3.add(btClose);
		p.add(p3,"South");
		
		btCreate.addActionListener((e)->{
			String s = JOptionPane.showInputDialog("공지사항 입력");
			if (s == null) return;
			lstV.add(s);
			//lst.setListData(lstV);
			lst.updateUI();
		});
		btClose.addActionListener((e)->{
			dispose();
		});
		

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		Sub2 ae = new Sub2();
		ae.setSize(500, 500);
		ae.setVisible(true);

	}

}