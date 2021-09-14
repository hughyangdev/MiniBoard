package miniBoard;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class QnA extends JPanel {
   JPanel cp;
   JPanel card1 = new JPanel();
   JPanel mainp = new JPanel(new BorderLayout());
   JPanel pN = new JPanel(new BorderLayout());
   JPanel pC = new JPanel();
   JPanel p1 = new JPanel();
   
   Main parent1;
   
   Icon i = new ImageIcon();
   JLabel back,QnA1;
   
   JTextField tf = new JTextField();
   TextArea ta;
   
   CardLayout card = new CardLayout();
   public QnA(Main parent1) {
      this.parent1 = parent1;
      this.setLayout(new BorderLayout());
      JPanel cp = new JPanel(new BorderLayout());
      
      add(cp);
      cp.add(card1,"Center");
      card1.setLayout(card);
      card1.add(mainp);
      mainp.add(pN,"North");
      mainp.add(pC,"Center");

      pN.setBackground(new Color(255,231,231));
      pC.setBackground(new Color(255,231,231));

      ta = new TextArea(" Q : 주요 기능은? \n "
      		+ "A : CardLayout을 사용하여 화면 전환을 하였습니다.\n"
      		+ "\t 커뮤니티 앱으로 글 작성 기능을 구현하였습니다.",20,60);
      //ta.setFont(new Font("궁서체", Font.BOLD, 16));
      back = new JLabel(new ImageIcon("images/back.png"));
      QnA1 = new JLabel(new ImageIcon("images/qna.png"));
      //QnA1.setBounds(13,29, 56, 46);
      ta.setBackground(new Color(255,231,231));
      pN.add(back, BorderLayout.WEST);
      pN.add(QnA1);
      JScrollPane js = new JScrollPane(ta);
      ta.setEditable(false);
      pC.add(js);
      MyHandler my2 = new MyHandler();
      back.addMouseListener(my2);
   
   }
      class MyHandler extends MouseAdapter
      {
         @Override
         public void mousePressed(MouseEvent e)
         {
            Object obj = e.getSource();
            if(obj == back)
            {
            	parent1.card.show(parent1.main1,"main");
            }
         }
      }

}

