package miniBoard;

import javax.swing.*;

import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Main extends JPanel {

	// 패널 생성
	JPanel cp ;
	JPanel main1 = new MyJPanel(); // card 적용 패널
	JPanel p = new MyJPanel(20,20,20,20); // ct 부착 패널
	JPanel p1 = new JPanel(); // logo, 멘트 부착 패널
	JPanel p2 = new MyJPanel(); // 종료 버튼 부착 패널
	JPanel p3 = new JPanel(new BorderLayout()); // main에 붙는 전체 패널
   
	// 버튼, 라벨 생성
	JLabel ct1, ct2, ct3, ct4;
   	JLabel lb1;
	JButton back, close;	
	
	// 카테고리 선언
	Sub1 sub1; // 커뮤니티
	News news; // 공지사항
	QnA qna; // QnA
	
	Icon i = new ImageIcon();
	Icon i2 = new ImageIcon();
	
	Login login;
	
	Write write = new Write(); // Write 생성, 글 작성 클래스
	
	CardLayout card = new CardLayout(); // card 레이아웃
	
	Vector<Board> bList=new Vector<>(); // 작성 글 저장 클래스
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
		lb1 = new JLabel(new ImageIcon("images/main_logo.png")); // logo 이미지 넣기
		p1.setBackground(Color.white);
		p1.add(lb1);
	    
		// 카테고리 영역 -> p에 부착
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
		
		// 퇴장 영역 -> p2에 부착
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
		
		// 전체패널에 각 패널 부착
		p3.add(p1,"North");
		p3.add(p,"Center");
		p3.add(p2,"South");
		 
		// card 패널에 전체 패널 부착
		main1.add(p3,"main");
		
		// 연결 객체 생성
		sub1 = new Sub1(this);
		news = new News(this);
		qna = new QnA(this);
				
		main1.add(sub1,"Sub1");
		main1.add(news,"News");
	    main1.add(qna ,"QnA");
		
		// 마우스이벤트 리스너 부착
		MyHandler my = new MyHandler();
		lb1.addMouseListener(my);
		ct1.addMouseListener(my);
	    ct2.addMouseListener(my);
	    //ct3.addMouseListener(my);
	    ct4.addMouseListener(my);
		
	    
	    // 버튼 이벤트 처리
		back.addActionListener((e)->{
			login.card.show(login.p1, "login");
		});
		close.addActionListener((e)->{
			System.exit(0);
		});
		
	} // 생성자-------------------
   
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

	} // 이벤트클래스-------------------

} // Main 클래스 - 카테고리
