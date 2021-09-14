package miniBoard;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

public class Write extends JFrame {

	JPanel p = new JPanel(); // North 영역, 라벨부착
	JPanel pCenter = new JPanel(); // Center 영역, pC2, pC3 부착
	JPanel pC2 = new MyJPanel(0,0,0,0); // 제목라벨, TextField 부착
	JPanel pC3 = new JPanel(); // TextArea 부착
	JPanel pSouth = new JPanel();// South 영역, 버튼부착
	
	//JLabel 현재 있는 곳 주소
	JLabel proper,subtitlename;
	
	//게시글 제목, 작성 영역  -> lst2
	JTextField subtitle;
	JTextArea substance;
	
	//게시글 제목, 작성 영역  -> lst3
	JTextField subtitle2;
	JTextArea substance2;
	
	//버튼 생성
	JButton btEnter, btReset, btExit;
   
	public Write() {
		super("::Write::");
		Container cp = getContentPane();
		
		// p, 라벨 영역 -> p에 부착 -> 전체패널 위쪽 부착
		p.setBackground(new Color(255,231,231));
		proper = new JLabel("게시글 작성");
		p.add(proper);
		cp.add(p, "North");
		
		// pCenter 영역에 대한 처리
		pCenter.setLayout(new BorderLayout());
		pCenter.setBackground(new Color(255,231,231));
		cp.add(pCenter,"Center");
		
		// 중앙패널에 pC2, pC3 부착
	    pCenter.add(pC2,"North");
		pCenter.add(pC3,"Center");
		
		// pC2 영역 -> 라벨, TextField 생성 및 부착
		subtitlename = new JLabel("제목 : ");
		subtitle = new JTextField(25);
		subtitle.setBackground(new Color(255,231,231));
		subtitle.setBorder(new LineBorder(Color.black,2));
		pC2.setBackground(new Color(255,231,231));
		pC2.add(subtitlename);
		pC2.add(subtitle);
		
		// pC3 영역 -> TextArea 부착
		substance = new JTextArea(20,40);
		substance.setBackground(new Color(255,231,231));
		substance.setBorder(new LineBorder(Color.black,2));
		JScrollPane js = new JScrollPane(substance);
		js.setBackground(new Color(255,231,231));
		pC3.setBackground(new Color(255,231,231));
		pC3.add(js);
		
		// pSouth 영역에 대한 처리
		pSouth.setBackground(new Color(255,231,231));
		cp.add(pSouth,"South");
		
		// 버튼 생성 및 패널 부착
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
      	      	
      	// btEnter 버튼 이벤트는 Sub1에서 처리
      	// btReset 버튼 이벤트 처리
      	btReset.addActionListener((e)->{
      		subtitle.setText("");
			substance.setText("");
			subtitle.requestFocus();
      	});
      	// btExit 버튼 이벤트 처리
      	btExit.addActionListener((e)->{
      		subtitle.setText("");
			substance.setText("");
      		setVisible(false);
			dispose();
      	});
      	
      	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      	
	} // 생성자-------------------
   
} // Write 클래스 - 제목, 글 작성
