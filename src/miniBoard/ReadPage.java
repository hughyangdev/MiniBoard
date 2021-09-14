package miniBoard;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.*;

public class ReadPage extends JFrame {

   // p는 North 영역으로
   JPanel p = new JPanel();
   //pCenter 영역
   JPanel pCenter = new JPanel();
   JPanel pC2 = new MyJPanel(0,0,0,0);
   JPanel pC3 = new JPanel();
   //pSouth 영역
   JPanel pSouth = new JPanel();
   //JLabel 현재 있는 곳 주소
   JLabel proper,subtitlename;
   //게시글 제목 영역
   JTextField subtitle;
   //게시글 작성 영역
   JTextArea substance;
   //버튼 생성
   JButton btBack;
   
   public ReadPage() {
      super("::ReadPage::");
      Container cp = getContentPane();
      // p, North 영역에 대한 처리
      cp.add(p, "North");
      p.setBackground(new Color(255,231,231));
      proper = new JLabel("게시글");
      p.add(proper);

      // pCenter 영역에 대한 처리
      pCenter.setLayout(new BorderLayout());
      cp.add(pCenter,"Center");
      pCenter.setBackground(new Color(255,231,231));
      
      // pC2에 대한 영역
      pCenter.add(pC2,"North");
      // pC3에 대한 영역
      pCenter.add(pC3,"Center");
      // TextField, TextArea 생성
      subtitlename = new JLabel("제목 : ");
      pC2.add(subtitlename,"West");
      subtitle = new JTextField(25);
      subtitle.setBackground(new Color(255,231,231));
      subtitle.setEditable(false);
      
      pC2.setBackground(new Color(255,231,231));
      pC2.add(subtitle,"East");
      subtitle.setBorder(new LineBorder(Color.black,2));
      
      // pC3 에 대한 영역
      substance = new JTextArea(20,40);
      JScrollPane js = new JScrollPane(substance);
      substance.setBackground(new Color(255,231,231));
      pC3.add(js);
      js.setBackground(new Color(255,231,231));
      substance.setEditable(false);
      pC3.setBackground(new Color(255,231,231));
      substance.setBorder(new LineBorder(Color.black,2));

      // pSouth 영역에 대한 처리
      pSouth = new JPanel();
      pCenter.add(pSouth,"South");
      pSouth.setBackground(new Color(255,231,231));
      
      // 버튼에 대한 처리
      btBack = new JButton("CLOSE");
      btBack.setPreferredSize(new Dimension(100,30));
      btBack.setBorder(new LineBorder(new Color(100,200,255), 1));
      btBack.setBackground(new Color(255,231,231));
      pSouth.add(btBack);
      
      btBack.addActionListener((e)->{
    	  setVisible(false);
          dispose();
      });
      
      this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      
   } // 생성자-----------------------------

   public static void main(String[] args) {
      ReadPage wr = new ReadPage();
      wr.setSize(600, 550);
      wr.setVisible(true);
   }
}

