package miniBoard;

import javax.swing.*;

import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Main extends JPanel {

	// �г� ����
	JPanel cp ;
	JPanel main1 = new MyJPanel(); // card ���� �г�
	JPanel p = new MyJPanel(20,20,20,20); // ct ���� �г�
	JPanel p1 = new JPanel(); // logo, ��Ʈ ���� �г�
	JPanel p2 = new MyJPanel(); // ���� ��ư ���� �г�
	JPanel p3 = new JPanel(new BorderLayout()); // main�� �ٴ� ��ü �г�
   
	// ��ư, �� ����
	JLabel ct1, ct2, ct3, ct4;
   	JLabel lb1;
	JButton back, close;	
	
	// ī�װ� ����
	Sub1 sub1; // Ŀ�´�Ƽ
	News news; // ��������
	QnA qna; // QnA
	
	Icon i = new ImageIcon();
	Icon i2 = new ImageIcon();
	
	Login login;
	
	Write write = new Write(); // Write ����, �� �ۼ� Ŭ����
	
	CardLayout card = new CardLayout(); // card ���̾ƿ�
	
	Vector<Board> bList=new Vector<>(); // �ۼ� �� ���� Ŭ����
	Vector<Board2> bList2 = new Vector<>(); // lst3
   
	public Main (Login login) {
		this.login = login;
		this.setLayout(new BorderLayout());
		//setTitle("::Main::");
		
		cp = new JPanel(new BorderLayout());
		add(cp, "Center");
		cp.add(main1);
		main1.setLayout(card);
		main1.setBackground(Color.white);
		lb1 = new JLabel(new ImageIcon("images/main_logo.png")); // logo �̹��� �ֱ�
		p1.setBackground(Color.white);
		p1.add(lb1);
	    
		// ī�װ� ���� -> p�� ����
		p.setLayout(new GridLayout(2,2,5,5));
		p.setBackground(new Color(255,231,231));
		
		//Icon i = new ImageIcon("images/menu.png");
		ct1 = new JLabel(new ImageIcon("images/community3.png"));
	    ct2 = new JLabel(new ImageIcon("images/notice3.png"));
	    ct3 = new JLabel(new ImageIcon("images/member.png"));
	    ct4 = new JLabel(new ImageIcon("images/qna3.png"));

		p.add(ct1);
		ct1.setBackground(new Color(255,231,231));
		p.add(ct2);
		ct2.setBackground(new Color(255,231,231));
		p.add(ct3);
		ct3.setBackground(new Color(255,231,231));
		p.add(ct4);
		ct4.setBackground(new Color(255,231,231));
		
		// ���� ���� -> p2�� ����
		p2.setBackground(new Color(255,231,231));
		back = new JButton("BACK");
		back.setPreferredSize(new Dimension(100,30));
		back.setBorder(new LineBorder(new Color(100,200,255), 1));
		back.setBackground(new Color(255,231,231));
		close = new JButton("EXIT");
		close.setPreferredSize(new Dimension(100,30));
		close.setBorder(new LineBorder(new Color(100,200,255), 1));
		close.setBackground(new Color(255,231,231));
		p2.add(back);
		p2.add(close);
		
		// ��ü�гο� �� �г� ����
		p3.add(p1,"North");
		p3.add(p,"Center");
		p3.add(p2,"South");
		 
		// card �гο� ��ü �г� ����
		main1.add(p3,"main");
		
		// ���� ��ü ����
		sub1 = new Sub1(this);
		news = new News(this);
		qna = new QnA(this);
				
		main1.add(sub1,"Sub1");
		main1.add(news,"News");
	    main1.add(qna ,"QnA");
		
		// ���콺�̺�Ʈ ������ ����
		MyHandler my = new MyHandler();
		lb1.addMouseListener(my);
		ct1.addMouseListener(my);
	    ct2.addMouseListener(my);
	    //ct3.addMouseListener(my);
	    ct4.addMouseListener(my);
		
	    
	    // ��ư �̺�Ʈ ó��
		back.addActionListener((e)->{
			login.card.show(login.p1, "login");
		});
		close.addActionListener((e)->{
			System.exit(0);
		});
		
	} // ������-------------------
   
	class MyHandler extends MouseAdapter {
		@Override
		public void mouseEntered(MouseEvent e) {
	         Object obj = e.getSource();
	         if(obj == ct1) {
	            i = new ImageIcon("images/community4.png");
	            ct1.setIcon(i);
	            return;
	         } else if(obj == ct2) {
	            i = new ImageIcon("images/notice4.png");
	            ct2.setIcon(i);
	            return;
	         } /*else if(obj == ct3) {
	            i = new ImageIcon("images/member.png");
	            ct3.setIcon(i);
	            return;
	         }*/ else if(obj == ct4) {
	            i = new ImageIcon("images/qna4.png");
	            ct4.setIcon(i);
	            return;
	         }
	      } // mouseEntered-----------
	      public void mouseExited(MouseEvent e) { 
	         Object obj = e.getSource();
	         if(obj==ct1) {
	            i2 = new ImageIcon("images/community3.png");
	            ct1.setIcon(i2);
	         } else if(obj==ct2) {
	            i2 = new ImageIcon("images/notice3.png");
	            ct2.setIcon(i2);
	         } /*else if(obj==ct3) {
	            i2 = new ImageIcon("images/member.png");
	            ct3.setIcon(i2);
	         }*/ else if(obj==ct4) {
	            i2 = new ImageIcon("images/qna3.png");
	            ct4.setIcon(i2);
	         }
	      } // mouseExited-----------
	      public void mousePressed(MouseEvent e) {
	         Object obj = e.getSource();
	         if(obj == ct1) {
	            i2 = new ImageIcon("images/community3.png");
	            ct1.setIcon(i2);
	            card.show(main1,"Sub1");
	         } else if(obj == ct2) {
	            i2 = new ImageIcon("images/notice3.png");
	            ct2.setIcon(i2);
	            card.show(main1,"News");
	         } /*else if(obj == ct3) {
	            i2 = new ImageIcon("images/member.png");
	            ct3.setIcon(i2);
	            card.show(main1,"QnA");
	         }*/ else if(obj == ct4) {
	            i2 = new ImageIcon("images/qna3.png");
	            ct4.setIcon(i2);
	            card.show(main1,"QnA");
	         }
	      } // mousePressed----------

	} // �̺�ƮŬ����-------------------

} // Main Ŭ���� - ī�װ�
