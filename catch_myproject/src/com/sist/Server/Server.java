package com.sist.Server;
import java.util.*;// Vector(Ŭ���̾�Ʈ ����)
import java.net.*;// ServerSocket(����=��ȯ) , Socket(Ŭ���̾�Ʈ�� ���)
import java.io.*;// OutputStream(byte),BufferedReader(char)
import com.sist.common.*;// ��� ��ȣ 
public class Server implements Runnable{
    // ������� (Ŭ���̾�Ʈ ���� ����)
	Vector<Client> waitVc=new Vector<Client>();
	// ���Ӵ�� (��ȯ����)
	ServerSocket ss;
	private final int PORT=3355;
	// ��������
	public Server() 
	{
		try
		{
			ss=new ServerSocket(PORT);
			System.out.println("Server Start...");
		}catch(Exception ex) {}
	}
	// ���Ӵ�� 
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try
		{
			while(true)
			{
				Socket s=ss.accept();// new Socket()
				Client client=new Client(s);
				client.start();// run()
			}
		}catch(Exception ex) {}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Server server=new Server();
        new Thread(server).start();
	}
	// ��Ž���
	class Client extends Thread
	{
		Socket s;
		OutputStream out;
		BufferedReader in;
		
		String id,name,sex;
		
		public Client(Socket s)
		{
			try
			{
				this.s=s;
				out=s.getOutputStream();
				in=new BufferedReader(new InputStreamReader(s.getInputStream()));
			}catch(Exception ex) {}
		}
		
		public void run()
		{
			try
			{
				while(true)
				{
					// 100|id|name|sex
					String msg=in.readLine();//out.write()
					System.out.println(msg);
					StringTokenizer st=
							new StringTokenizer(msg, "|");
					int protocol=Integer.parseInt(st.nextToken());
					switch(protocol)
					{
					case Function.LOGIN:
					     {
					    	 // �α��� => �Է¹޴´� 
						     id=st.nextToken();
						     name=st.nextToken();
						     sex=st.nextToken();
						     
						     // �̹� ���ӵ� ����鿡�� ���� => �α����ϰ� �ִ� ��� 
						     messageAll(Function.LOGIN+"|"
						        +id+"|"+name+"|"+sex);
						     // ����
						     waitVc.addElement(this);
						     // ������ ������ ���� �޴´� 
						     messageTo(Function.MYLOG+"|");
						     for(Client client:waitVc)
						     {
						    	 messageTo(Function.LOGIN+"|"
									     +client.id+"|"
						    			 +client.name
						    			 +"|"+client.sex); 
						     }
						     
					     }
						 break;
					case Function.CHAT:
					     {
					    	 String str=st.nextToken();
					    	 messageAll(Function.CHAT+"|["+name+"]"+str);
					     }
					     break;
					}
				}
			}catch(Exception ex){}
		}
		// ��ü ���� 
		public void messageAll(String msg)
		{
			for(Client client:waitVc)
			{
				try
				{
					client.messageTo(msg);
				}catch(Exception ex){}
			}
		}
		// ���� ����
		public void messageTo(String msg)
		{
			try
			{
				out.write((msg+"\n").getBytes());
			}catch(Exception ex){}
		}
	}

}








