package miniBoard;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.*;

public class ReadPage extends JFrame {

   // p�� North ��������
   JPanel p = new JPanel();
   //pCenter ����
   JPanel pCenter = new JPanel();
   JPanel pC2 = new MyJPanel(0,0,0,0);
   JPanel pC3 = new JPanel();
   //pSouth ����
   JPanel pSouth = new JPanel();
   //JLabel ���� �ִ� �� �ּ�
   JLabel proper,subtitlename;
   //�Խñ� ���� ����
   JTextField subtitle;
   //�Խñ� �ۼ� ����
   JTextArea substance;
   //��ư ����
   JButton btBack;
   
   public ReadPage() {
      super("::ReadPage::");
      Container cp = getContentPane();
      // p, North ������ ���� ó��
      cp.add(p, "North");
      p.setBackground(new Color(255,231,231));
      proper = new JLabel("�Խñ�");
      p.add(proper);

      // pCenter ������ ���� ó��
      pCenter.setLayout(new BorderLayout());
      cp.add(pCenter,"Center");
      pCenter.setBackground(new Color(255,231,231));
      
      // pC2�� ���� ����
      pCenter.add(pC2,"North");
      // pC3�� ���� ����
      pCenter.add(pC3,"Center");
      // TextField, TextArea ����
      subtitlename = new JLabel("���� : ");
      pC2.add(subtitlename,"West");
      subtitle = new JTextField(25);
      subtitle.setBackground(new Color(255,231,231));
      subtitle.setEditable(false);
      
      pC2.setBackground(new Color(255,231,231));
      pC2.add(subtitle,"East");
      subtitle.setBorder(new LineBorder(Color.black,2));
      
      // pC3 �� ���� ����
      substance = new JTextArea(20,40);
      JScrollPane js = new JScrollPane(substance);
      substance.setBackground(new Color(255,231,231));
      pC3.add(js);
      js.setBackground(new Color(255,231,231));
      substance.setEditable(false);
      pC3.setBackground(new Color(255,231,231));
      substance.setBorder(new LineBorder(Color.black,2));

      // pSouth ������ ���� ó��
      pSouth = new JPanel();
      pCenter.add(pSouth,"South");
      pSouth.setBackground(new Color(255,231,231));
      
      // ��ư�� ���� ó��
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
      
   } // ������-----------------------------

   public static void main(String[] args) {
      ReadPage wr = new ReadPage();
      wr.setSize(600, 550);
      wr.setVisible(true);
   }
}

