package com.sist.mainpanel;
import java.awt.*;
import javax.swing.*;

import com.sist.mainpanel.Catch_gameroom;
import com.sist.mainpanel.Character_select;
import com.sist.mainpanel.MainView;
import com.sist.mainpanel.WaitRoom;
import com.sist.mainpanel.WaitRoom_NewRoom;


public class ClientMainForm extends JFrame{
	
	CardLayout card = new CardLayout();
	MainView mv = new MainView();
	WaitRoom wr = new WaitRoom();
	WaitRoom_NewRoom wrn = new WaitRoom_NewRoom();
	Character_select cs = new Character_select();
	Catch_gameroom gr = new Catch_gameroom();
	
	public ClientMainForm()
	{
		setLayout(card);
<<<<<<< HEAD
		//add("MV", mv);  
		add("CS", cs);
		//add("GR", gr);
		//add("WR", wr);
=======
		add("MV", mv);  
		add("CS", cs);
		add("GR", gr);
		add("WR", wr);
>>>>>>> branch 'master' of https://github.com/uruk-why-you-uruk/Server_CM.git
		
		setSize(1251,750);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) { 
		ClientMainForm a = new ClientMainForm();
		a.setLocationRelativeTo(null);

	}

}
