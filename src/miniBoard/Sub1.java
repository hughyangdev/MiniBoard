/*package Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Sub1 extends JFrame {

	JPanel p = new JPanel(new BorderLayout());
	JPanel p1 = new JPanel(new BorderLayout());
	JPanel p2 = new JPanel();
	JTabbedPane tab;
	JButton btEnter, btBack;
	JList<String> lst1, lst2, lst3, lst4;

	public Sub1() {
		super("::Sub1::");
		Container cp = getContentPane();
		cp.add(p, "Center");
		p.setBackground(Color.white);
		
		tab = new JTabbedPane();
		lst1 = new JList<>();
		lst2 = new JList<>();
		lst3 = new JList<>();
		lst4 = new JList<>();
		tab.add("Categoy1", new JScrollPane(lst1));
		tab.add("Categoy2", new JScrollPane(lst2));
		tab.add("Categoy3", new JScrollPane(lst3));
		tab.add("Categoy4", new JScrollPane(lst4));
		
		p1.add(tab, "Center");
		p.add(p1, "Center");
		
		btEnter = new JButton("새글 작성");
		btBack = new JButton("Main으로");
		p2.add(btEnter);
		p2.add(btBack);
		p.add(p2, "South");
		
		btBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setTitle("BACK");
				setVisible(false);
				
			}
		});

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		Sub1 ae = new Sub1();
		ae.setSize(500, 400);
		ae.setVisible(true);

	}

}*/

package miniBoard;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.border.*;
import javax.swing.event.*;

public class Sub1 extends JPanel {

	JPanel cp; // 전체 패널
	JPanel pCenter = new JPanel(); // 중앙 패널 -> tab, TextArea, List 부착
	JPanel pNorth = new JPanel(new GridLayout(1,3)); // 위쪽 패널 -> 버튼, 라벨 부착
	
	JPanel tabP1 = new JPanel(new BorderLayout()); // tab2 에 붙는 패널.
	JPanel tabP1_1 = new JPanel(new GridLayout(1,2,50,50)); // tapP1 에 붙는 패널.
	
	JPanel tabP2 = new JPanel(new BorderLayout()); // tab3 에 붙는 패널.
	JPanel tabP2_2 = new JPanel(new GridLayout(1,2,50,50)); // tabP2 에 붙는 패널.
	
	//tap, TextArea 생성
	JTabbedPane tab = new JTabbedPane();
	JTextArea ta1 = new JTextArea();
	
	//JLabel, 글작성에 대한 버튼 생성
	JLabel lb;
	JButton write1, write2, back1, back2;
	
	//CardLayout 생성
	CardLayout card = new CardLayout();
	
	//Main 불러오기
	Main parent;
	
	// Write 불러오기
	Write w1 = new Write(); // lst2
	Write w2 = new Write(); // lst3
	//
	ReadPage read = new ReadPage();
	
	int no=0;
   
	JList<String> lst2, lst3;
	Vector<String> lst2V1 = new Vector<>();
	Vector<String> lst3V1 = new Vector<>();
   
	public Sub1(Main parent) {
		this.parent = parent;
		this.setLayout(new BorderLayout());
		
		lst2 = new JList<>(lst2V1);
		lst3 = new JList<>(lst3V1);
		
		cp=new JPanel(new BorderLayout());
		add(cp);
		
		pNorth.setBackground(new Color(255,231,231));
	    pCenter.setLayout(new BorderLayout());
	    pCenter.setBackground(new Color(255,231,231));
	    cp.add(pNorth,"North");
		cp.add(pCenter, "Center");  
		
		//JLabel,JButton 영역
		back1 = new JButton("Back");
		back2 = new JButton("Back");
	    write1 = new JButton("Wirte");
		write2 = new JButton("Wirte");
		back1.setBackground(new Color(255,231,231));
		back2.setBackground(new Color(255,231,231));
		write1.setBackground(new Color(255,231,231));
		write2.setBackground(new Color(255,231,231));
		
		lb = new JLabel(new ImageIcon("images/sub1.png"));
		//lb.setFont(new Font("",Font.BOLD),20);
	    pNorth.add(lb,"Center");
	    
	    // 세부 tab
	 	tabP1.add(new JScrollPane(lst2), "Center");
	 	tabP1.add(tabP1_1, "South");
	 	tabP1_1.add(back1);
	 	tabP1_1.add(write1);		
	 	tabP1_1.setBorder(new LineBorder(new Color(255,231,231),2));
	 	tabP1.setBackground(new Color(255,231,231));
	 	tabP1_1.setBackground(new Color(255,231,231));
	 
	 	tabP2.add(new JScrollPane(lst3), "Center");
	 	tabP2.add(tabP2_2, "South");
	 	tabP2_2.add(back2);
	 	tabP2_2.add(write2);
	 	tabP2_2.setBorder(new LineBorder(new Color(255,231,231),2));
	 	tabP2.setBackground(new Color(255,231,231));
	 	tabP2_2.setBackground(new Color(255,231,231));
	 		
	    // tab 에 대한 목록
	    pCenter.add(tab,"Center");
	    tab.add("여행",tabP1);
	    tab.add("당산맛집",tabP2);
	    tab.setBackground(new Color(255,231,231));
	      
	    tab.setSelectedIndex(0);
	    
	    // 이벤트리스너 부착
		MyHandler1 my1 = new MyHandler1();
		write1.addActionListener(my1);
		write1.setPreferredSize(new Dimension(100,30));
		write1.setBorder(new LineBorder(new Color(100,200,255), 1));
		write1.setBackground(new Color(255,231,231));
		write2.addActionListener(my1);
		write2.setPreferredSize(new Dimension(100,30));
		write2.setBorder(new LineBorder(new Color(100,200,255), 1));
		write2.setBackground(new Color(255,231,231));
		back1.addActionListener(my1);		
		back1.setPreferredSize(new Dimension(100,30));
		back1.setBorder(new LineBorder(new Color(100,200,255), 1));
		back1.setBackground(new Color(255,231,231));
		back2.addActionListener(my1);		
		back2.setPreferredSize(new Dimension(100,30));
		back2.setBorder(new LineBorder(new Color(100,200,255), 1));
		back2.setBackground(new Color(255,231,231));
		w1.btEnter.addActionListener(my1);
		w2.btEnter.addActionListener(my1);
		
		lst2.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				int indx = lst2.getSelectedIndex();
				Board gul = parent.bList.get(indx);
				boolean b=e.getValueIsAdjusting();
				if (b==true) {
					read.subtitle.setText(gul.getTitle());
					read.substance.setText(gul.getContent());
					read.setSize(500,600);
					read.setLocation(500, 0);
					read.setVisible(true);
				}
			}
		});
		
		lst3.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				int indx = lst3.getSelectedIndex();
				Board2 gul2 = parent.bList2.get(indx);
				boolean b=e.getValueIsAdjusting();
				if (b==true) {
					read.subtitle.setText(gul2.getTitle());
					read.substance.setText(gul2.getContent());
					read.setSize(500,600);
					read.setLocation(500, 0);
					read.setVisible(true);
				}
			}
		});
		
	} // 생성자-------------------
	
	class MyHandler1 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent d) {
			String tc = w1.subtitle.getText();
	        String cont = w1.substance.getText();
	        String tc2 = w2.subtitle.getText();
			String cont2 = w2.substance.getText();
			Object obj1 = d.getSource();
			if(obj1 == write1) {
				w1.setSize(500,600);
				w1.setLocation(500, 0);
				w1.setResizable(false);
				w1.setVisible(true);
			}
			if(obj1 == back1) {
				setVisible(false);
			}
			if(obj1 == back2) {
				setVisible(false);
			}
			if(obj1 == w1.btEnter) {
	            if (tc.equals("") || cont.equals("")) {
	               JOptionPane.showMessageDialog(w1.pCenter, "제목과 글을 입력해 주세요.");
	            } else {
	               Board gul = new Board(++no,"홍길동",tc,cont);
	               parent.bList.add(gul);
	               lst2V1.add(tc);
	               lst2.updateUI();
	               w1.subtitle.setText("");
	               w1.substance.setText("");
	               w1.setVisible(false);
	               w1.dispose();
	            }
	        }
			if(obj1 == write2 ) {
				w2.setSize(500,600);
				w2.setLocation(500, 0);
				w2.setResizable(false);
				w2.setVisible(true);
			}
			if(obj1 == back1) {
				setVisible(false);
			}
			if(obj1 == back2) {
				setVisible(false);
			}
			if(obj1 == w2.btEnter) {
				if (tc2.equals("") || cont2.equals("")) {
		               JOptionPane.showMessageDialog(w2.pCenter, "제목과 글을 입력해 주세요.");
				} else {
				Board2 gul2 = new Board2(++no, "홍길동", tc2, cont2);
				parent.bList2.add(gul2);
				lst3V1.add(tc2);
				lst3.updateUI();				
				w2.subtitle.setText("");
				w2.substance.setText("");
				w2.setVisible(false);
				w2.dispose();
				}
			}
		}
		
	} // 이벤트클래스-------------------

} // Sub1 클래스 - 카테고리 별 작성글 리스트
