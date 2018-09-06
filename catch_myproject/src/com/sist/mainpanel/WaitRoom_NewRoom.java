package com.sist.mainpanel;

import javax.swing.*;
import java.awt.*;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WaitRoom_NewRoom extends JFrame implements ActionListener {
	WaitRoom_NewRoom_Panel wnp = new WaitRoom_NewRoom_Panel();
	CardLayout card = new CardLayout();

	public WaitRoom_NewRoom() {
		setLayout(card);
		add("WNP", wnp);
		
		setSize(600, 350);
		card.show(getContentPane(), "WNP");
		setUndecorated(true);
		setResizable(false); // ȭ�� �� ���̰��ϱ�
		wnp.noButton.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) { // �游��� â �ݱ�.
		if (e.getSource() == wnp.noButton) {
			this.dispose();
		}
	}
}