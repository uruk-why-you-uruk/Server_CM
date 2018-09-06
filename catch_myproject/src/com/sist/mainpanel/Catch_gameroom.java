package com.sist.mainpanel;

import javax.swing.*;
import com.sist.Vo.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class char_if {
	JLabel id, rank, score, icon;
}

public class Catch_gameroom extends JPanel implements ActionListener, MouseListener {
	static int k;
	boolean flag = false;
	Image back;
	// ��ư �� ������Ʈ�� ��� �гε�
	JPanel draw, timer, color_Panel;
	// �� ����
	JLabel room_grade, chat, qus;
	// ĳ���� ������ ��� Ŭ���� �迭
	CharVO[] player = new CharVO[8];
	// ĳ���� ������ ������� ���� ��� Ŭ���� �迭
	CharLabelVO[] char_group = new CharLabelVO[8];
	
	JLabel timerLabel = new JLabel("0");
	// ä��â�� ���� �ý�Ʈ�ʵ� ����
	JTextArea ta;
	JTextField tf;
	// �ȷ�Ʈ ��ư�� ���� ��ư
	JButton[] color = new JButton[6];

	ImageIcon out_img, giveup, eraser;
	JButton out_btn,giveup_btn, eraser_btn;

	JButton timer_btn = new JButton("Ÿ�̸ӽ���");
	JButton qus_btn = new JButton("���� ����");
	TimeThread t = new TimeThread();

	static boolean bThread;

	Catch_gameroom() {

		// �����ڿ��� ���̴� ���� 
		qus = new JLabel(new ImageIcon("image\\question.png"));
		qus.setBounds(265, 70, 197, 31);
		add(qus);

		setLayout(null);
		// ����̹��� ���
		back = Toolkit.getDefaultToolkit().getImage("image\\gamm.png");
		
		// ������ ��ư
		out_img = new ImageIcon("image\\roomexit.png");
		out_btn = new JButton("", out_img);
		out_btn.setBounds(1060, 600, 115, 51);
		out_btn.setBorderPainted(false); // �׵θ� ��� ���ֱ�
		add(out_btn);
		

		// ���� ��ư
		giveup = new ImageIcon("image\\giveup_btn.png");
		giveup_btn = new JButton(giveup);
		giveup_btn.setBounds(790, 45, 67, 66);
		giveup_btn.setBorderPainted(false);
		giveup_btn.setContentAreaFilled(false);
		add(giveup_btn);
		
		// ��ü����� ��ư
		eraser = new ImageIcon("image\\eraser_btn.png");
		eraser_btn = new JButton(eraser);
		eraser_btn.setBounds(930, 50, 64, 70);
		eraser_btn.setBorderPainted(false);
		eraser_btn.setContentAreaFilled(false);
		add(eraser_btn);
		
		

		qus_btn.setBounds(50, 600, 115, 51);
		qus_btn.setBackground(Color.YELLOW);
		add(qus_btn);
		

		// ä��â ����



		ta = new JTextArea();
		JScrollPane js3 = new JScrollPane(ta); // ��ũ���� ���� �����ִ� ������Ʈ
		tf = new JTextField();
		
		// �÷��̾���� ������ ���� Ŭ���� �����ϱ�
		for (int i = 0; i < 8; i++) {
			player[i] = new CharVO();
		}
		
		// ĳġ���ε� �׸��� �κ�
		draw = new JPanel();
		draw.setBackground(Color.BLACK);
		
		// ���� ǥ���ϴ� ��
		room_grade = new JLabel();
		
		// ä��â ǥ���ϴ�  �κ�
		chat = new JLabel();
		
		// �ȷ�Ʈ ǥ���ϴ� �κ�
		color_Panel = new JPanel();
		color_Panel.setOpaque(false); // �г��� �޹�� ���� 
		color_Panel.setLayout(new FlowLayout()); // ��ư�� ������ ǥ���ϱ� ���� ���̾ƿ� ����
		
		for (int i = 0; i < color.length; i++) {
			// ��ư�� �̹��� ��������
			ImageIcon img2 = new ImageIcon("image\\color\\" + (i + 1) + ".png");
			Image img3 = getImageSizeChange(img2, 25, 28);
			ImageIcon ii = new ImageIcon(img3);
			//////////////////////////////////////////
			color[i] = new JButton(ii);
			color[i].setPreferredSize(new Dimension(25, 28)); // �̹��� ũ�� ����  
			// �̹��� 
			color[i].setBorderPainted(false);
			color[i].setFocusPainted(false);
			color[i].setContentAreaFilled(false);
			color_Panel.add(color[i]);
		}
		
		for (int i = 0; i < char_group.length; i++) {
			// ImageIcon img2 = new ImageIcon("image\\nickname.png");
			char_group[i] = new CharLabelVO();
			char_group[i].setOpaque(false);

		}
		for (int i = 0; i < char_group.length; i++) {
			add(char_group[i]);

		}

		add(color_Panel);
		add(draw);
		add(tf);
		add(timerLabel);
		add(timer_btn);
		timerLabel.setText(String.valueOf(String.format("%02d:%02d", 2, 30)));
		timer_btn.setBounds(580, 580, 150, 150);
		timerLabel.setFont(new Font("Gothic", Font.ITALIC, 50));
		timerLabel.setForeground(Color.WHITE);
		int y1 = 112;
		// int y= 110;
		char_group[0].setBounds(45, y1, 180, 110);
		char_group[1].setBounds(45, y1 + 120, 180, 110);
		char_group[2].setBounds(45, y1 + 240, 180, 110);
		char_group[3].setBounds(45, y1 + 360, 180, 110);
		char_group[4].setBounds(1022, y1, 180, 110);
		char_group[5].setBounds(1022, y1 + 120, 180, 110);
		char_group[6].setBounds(1022, y1 + 240, 180, 110);
		char_group[7].setBounds(1022, y1 + 360, 180, 110);

		color_Panel.setBounds(265, 510, 220, 60);
		draw.setBounds(265, 110, 725, 370);
		timerLabel.setBounds(265, 580, 300, 150);
		js3.setBounds(700, 500, 290, 100);
		add(js3);
		tf.setBounds(700, 620, 290, 30);

		setLayout(null);
		setVisible(true);

		qus_btn.addMouseListener(this);
		timer_btn.addMouseListener(this);
		tf.addActionListener(this);
	}

	public Image getImageSizeChange(ImageIcon icon, int width, int height) {
		Image img = icon.getImage();
		Image change = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		return change;
	}

	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(back, 0, 0, getWidth(), getHeight(), this);

	}

	@Override
	public void actionPerformed(ActionEvent e) { // ä����ġ�� ä��â�� �ԷµȰ� �ö󰡴°�
		if (e.getSource() == tf) {
			String s = tf.getText();
			ta.append(s + "\n");
			tf.setText("");
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == timer_btn) {
			t = new TimeThread();
			bThread = true;
			t.start();
			qus.setVisible(false);
		}
		if (e.getSource() == qus_btn) {
			// t.interrupt();
			bThread = false;
			qus.setVisible(true);
		}
	} 

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	class TimeThread extends Thread {
		public void run() {
			k = 150;
			if (flag == false) {
				flag = true;
				while (bThread) {
					if (k < 0)
						interrupt();
					try {
						int minutes = k / 60;
						int seconds = k % 60;
						timerLabel.setText(String.valueOf(String.format("%02d:%02d", minutes, seconds)));
						System.out.printf("%d\n", k);
						Thread.sleep(1000);
						// timerLabel.repaint();
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}

					k--;
				}
				flag = false;
			}
		}
	}

}