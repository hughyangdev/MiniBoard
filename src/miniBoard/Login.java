package miniBoard;

import javax.swing.*;

import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame {
	JPanel p = new JPanel(); // c1에 부착할 중앙패널
	JPanel p1 = new JPanel(); // 전체패널
	JPanel p2 = new JPanel(); // c1에 부착할 위쪽패널
	JPanel p3= new JPanel(); // c1에 부착할 아래쪽패널
	JPanel c1 = new JPanel(new BorderLayout()); // 중앙패널
			
	JLabel l= new JLabel();
	JLabel l2= new JLabel();
	JLabel l3= new JLabel();
	JLabel l4= new JLabel();
	//JLabel lbExit;
	JButton btLogin, btExit;
	
	JTextField tId;
	JPasswordField tPs;
	TitledBorder t = new TitledBorder("아이디");
	
	
	Main mainConn = new Main(this);
	
	CardLayout card = new CardLayout();
	
	public Login() {
		super("::SIMSIM::");
		Container cp = getContentPane();
		cp.add(p1);
		p1.setLayout(card);
				
		c1.add(p2,"North");
		c1.add(p,"Center");
		c1.add(p3,"South");
		
		// c1에 위쪽 영역 -> p2에 라벨 부착 -> c1에 p2 부착
		p2.setBackground(Color.white);
		l2=new JLabel(new ImageIcon("images/white.PNG"));
		p2.add(l2);
		
		// c1에 중앙 영역 -> p에 라벨, ID, PASSWORD 부착 -> c1에 p 부착
		p.setBackground(new Color(255,231,231));
		l=new JLabel(new ImageIcon("images/logo.png"));
		tId=new JTextField(25);
		tPs=new JPasswordField(25);
		tId.setBorder(new TitledBorder("아이디"));
		tPs.setBorder(new TitledBorder("비밀번호"));
		tId.setBackground(new Color(255,231,231));
		tPs.setBackground(new Color(255,231,231));
		p.add(l);
		p.add(tId);
		p.add(tPs);
		
		// c1에 아래쪽 영역 -> p3에 라벨, 버튼 부착 -> c1에 p3 부착
		p3.setBackground(new Color(255,231,231));
		l3=new JLabel(new ImageIcon("images/2.PNG"));
		
		btLogin=new JButton("Login");
		btLogin.setPreferredSize(new Dimension(100,30));
		btLogin.setBorder(new LineBorder(new Color(100,200,255), 1));
		btLogin.setBackground(new Color(255,231,231));
		btExit = new JButton("Exit");
		btExit.setPreferredSize(new Dimension(100,30));
		btExit.setBorder(new LineBorder(new Color(100,200,255), 1));
		btExit.setBackground(new Color(255,231,231));
		p3.add(btLogin);
		p3.add(btExit);
		p3.add(l3);
		p3.add(l4);
		
		l4=new JLabel(new ImageIcon("images/3.PNG"));
		//lbExit = new JLabel(new ImageIcon("images/exit3.png"));
		
		p1.add(c1, "login");
		
		// main 객체 생성, 부착
		p1.add(mainConn, "Main");
		
		// 이벤트 처리
		btLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String uid=tId.getText();
				char[]ch=tPs.getPassword();
				String pwd=new String(ch);
				//유효성 체크
				if(uid==null||pwd==null||uid.trim().equals("")||pwd.trim().isEmpty()) {
					JOptionPane.showMessageDialog(p1, "아이디와 비밀번호를 입력하세요");
					tId.requestFocus();
					return;
				}
				if(uid.contentEquals("user")&&pwd.contentEquals("1")) {
					card.show(p1,"Main");
	        		mainConn.setSize(500,500);
	        		mainConn.setVisible(true);	             
	        	} else {
	        		JOptionPane.showMessageDialog(p1,"Sorry. re-enter Please");
	        	}
			}
        });
		btExit.addActionListener((e)->{
			System.exit(0);
		});
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	} // 생성자----------------

	public static void main(String[] args) {
		Login ae = new Login();
		ae.setSize(500, 500);
		ae.setResizable(false);
		ae.setVisible(true);
	} // main()---------------

} // Login 클래스 - id, pwd 입력