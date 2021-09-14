package miniBoard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Sub4 extends JPanel {

	JPanel cardP = new JPanel();
	JPanel p = new JPanel(new BorderLayout());
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	
	CardLayout card = new CardLayout();
	
	JLabel lb1, lb2;
	//JButton btBack;
	JTextArea ta;
	JList<String> lst;
	
	Main parent;

	public Sub4(Main parent) {
		this.parent = parent;
		add(p, "Center");
		cardP.setBackground(Color.white);
		cardP.setLayout(card);
		
		//btBack = new JButton("BACK");
		lb1 = new JLabel("BACK", JLabel.LEFT);
		lb2 = new JLabel("공지사항", JLabel.CENTER);
		p1.add(lb1);
		p1.add(lb2);
		p.add(p1, "North");
		
		lst = new JList<>();
		ta = new JTextArea();
		lst.add(ta);
		p2.add(lst);
		p.add(p2, "Center");
		
		setSize(500,500);
		setVisible(true);

		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/*public static void main(String[] args) {
		Sub4 ae = new Sub4();
		ae.setSize(500, 500);
		ae.setVisible(true);

	}*/

}
