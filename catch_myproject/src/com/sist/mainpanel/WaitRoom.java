package com.sist.mainpanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.imageio.ImageIO;
import java.io.File;
import javax.swing.table.*;

public class WaitRoom extends JPanel implements ActionListener {
   Image back; //���ȭ��
   JLabel la1, la2, mc, nickName, rank; 
   //la1 = �氳�� ���̺��� ���̴� ��,  la2 = ������ ���̺��� ���̴¶�,  mc=�� ĳ�����̹���,  nickName =�г���,    rank=���
   JTable table1, table2; //table1 = �氳�� ���̺� ��,  table2 = ������ ���̺� ��
   DefaultTableModel model1, model2; //���̺���� row col���� 
   JTextArea ta; //ä��â ��
   JTextField tf; //ä��ġ�� ��
   JButton b1,b2; //b1 = �游��� ��ư,   b2= ������������ư(���ӷ��̵�) �� ��� ���°�.
   ImageIcon mb, ci, rankI; //�游����ư �̹���, ���� ĳ���� �̹���. , ����̹���
   

   WaitRoom() {
      setLayout(null); //����� ���� ���̾ƿ����� 
      back = Toolkit.getDefaultToolkit().getImage("image\\waitingroom.png");//�޹��ȭ��

      la1 = new JLabel(""); 
      la2 = new JLabel(""); 
      mc = new JLabel("");
      nickName = new JLabel("�г���");
      rank = new JLabel("");
      ta = new JTextArea(); 
      JScrollPane js3 = new JScrollPane(ta); //ä�ú信 ��ũ���� �־��ֱ�.
      tf = new JTextField();      
      b2 = new JButton("����������");   
      
      //��ư�� ���̹��� ����
      mb=new ImageIcon("image\\newroombtn.png");//�游��� ��ư �̹���
      b1 = new JButton("",mb); //�游��� ��ư�� �̹��� �����鼭 �ʱ�ȭ.
      ci=new ImageIcon("image\\jam.png");
      rankI=new ImageIcon("image\\RANK\\FF.png");
      Image  img = getImageSizeChange(ci, 90, 90);
      mc.setIcon(new ImageIcon(img));
      img = getImageSizeChange(rankI, 20, 20);
      rank.setIcon(new ImageIcon(img));

      // �氳�� ���̺� 
      String[] col1 = {"No", "���̸�", "����/�����", "���ο�" };
      String[][] row1 = new String[0][4];
      model1 = new DefaultTableModel(row1, col1);
      table1 = new JTable(model1);
      table1.getColumn("No").setPreferredWidth(60);
      table1.getColumn("���̸�").setPreferredWidth(440); 
      table1.getColumn("����/�����").setPreferredWidth(120);
      table1.getColumn("���ο�").setPreferredWidth(80);
      table1.getTableHeader().setReorderingAllowed(false); // �̵� �Ұ� 
      table1.getTableHeader().setResizingAllowed(false); //ũ�⺯��Ұ�
      JScrollPane js1 = new JScrollPane(table1);
      
      // ������ ���̺� 
      String[] col2 = { "�г���", "����ġ" };
      String[][] row2 = new String[0][2];
      model2 = new DefaultTableModel(row2, col2);
      table2 = new JTable(model2);
      table2.getTableHeader().setReorderingAllowed(false); // �̵� �Ұ� 
      table2.getTableHeader().setResizingAllowed(false); //ũ�⺯��Ұ�
      JScrollPane js2 = new JScrollPane(table2);

      // �氳�� ���̺� ��ġ
      la1.setBounds(30, 70, 100, 30);
      js1.setBounds(30, 95, 700, 300);
      js1.setOpaque(false);
      js1.getViewport().setOpaque(false);
      add(js1);

      // ������ ���̺� ��ġ
      la2.setBounds(820, 70, 130, 30);
      js2.setBounds(820, 95, 340, 350);
      js2.setOpaque(false);
      js2.getViewport().setOpaque(false);
      add(js2);
      
      // ä��â �� ��ġ
      js3.setBounds(30, 440, 700, 225); 
      js3.setOpaque(true);
      add(js3);
      // ä��ġ�°� ��ġ
      tf.setBounds(30, 685, 700, 20); 
      tf.setOpaque(true);
      add(tf);
      
      
      b1.setBounds(930, 645, 120, 50); //�游��� ��ư ��ġ
      b2.setBounds(930, 600, 120, 30); //���������� ��ư ��ġ //�� �������
      
      b1.setOpaque(false);
      //�̹��� �ڿ� ��ư ���� �Ⱥ��̰� �ϴ°�
      b1.setBorderPainted(false); 
      b1.setFocusPainted(false); 
      b1.setContentAreaFilled(false);
      
      //��ư��ġ
      add(b1);
      add(b2);
      
      //My Info~
      mc.setBounds(870, 500, 90, 90);
      mc.setOpaque(false);
      nickName.setBounds(1018, 523, 120, 30);
      nickName.setOpaque(false);
      rank.setBounds(1029, 563, 20, 20);
      rank.setOpaque(false);
      add(mc);
      add(nickName);
      add(rank);

      setSize(1251, 750);
      setVisible(true);

      tf.addActionListener(this); //ä��ġ�°� �׼Ǹ�����
   }

   public static void main(String[] args) {
      WaitRoom wr = new WaitRoom();
   }

   @Override
   public void actionPerformed(ActionEvent e) { // ä����ġ�� ä��â�� �ԷµȰ� �ö󰡴°�
      if (e.getSource() == tf) {
         String s = tf.getText();
         ta.append(s + "\n");
         tf.setText("");
      }
   }

   //��׶��� ���ȭ�� : Ŭ�������� ������ Ŭ�� -> Source->Override����� ->paintComponent
   @Override
   protected void paintComponent(Graphics g) {
      g.drawImage(back, 0, 0, getWidth(), getHeight(), this);

   }
   public Image getImageSizeChange(ImageIcon icon,int width,int height)
   {
         Image img=icon.getImage();
         Image change=img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
         return change;
   }
}