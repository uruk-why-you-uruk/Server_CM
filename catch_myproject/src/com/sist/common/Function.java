package com.sist.common; 
//LOGIN|aaaaaaaa
//out.write(("100|id|pwd")) 
//out.write(("LOGIN|id|pwd"))
public class Function { 
	//public static final �������� ������ = ���; // ����
	public static final int LOGIN=100;// �α��� �ȵ� �����  
	public static final int DUPLICATE=110; //�ߺ�ó��
	public static final int SEMILOG=120; //ĳ���ͼ���â�� �ִ� ����� 
    //ĳ����â (������ ȭ��)
    public static final int CHARACTERROOM=200;//ĳ���ͼ���â (����)
    public static final int CHARACTERCHOICE=210;//���õ� ĳ���� ����!!!������ ĳ������ ��ȣ�� ����
    //�α���, ĳ�� �Ϸ�!!��ư�Ϸ�!
    public static final int MYLOG=130;// ��� ������ ������ �α����ϴ� �����
    //����� �޼���
    public static final int MAKEROOM=300;// �游���
    public static final int ROOMIN=310;//�����
    public static final int ROOMOUT=320;//�泪����(�����ִ� ���)
    public static final int MYROOMOUT=330;//�泪���� ��� ó��
    public static final int WAITUPDATE=340;//���� ���� 
    public static final int WAITCHAT=350;//���� ä��

    //GAME �޼���
    public static final int GAMEREADY=400;//���� �غ� �ο� 3�� �̸�
    public static final int GAMESTART=410;//���ӽ��� �ο��� 3���̻��̸� �ڵ�����
    public static final int GAMEMUNJE=420;//������������
    public static final int GAMEMYMUNJE=430;//����������
    public static final int GAMEDAP=440;//�� ����, ������ ��� ä�ÿ��� ģ �� ��
    public static final int GAMEYESNO=450;//����� ���� ����

    public static final int GAMEGIVEUP=460; //��������
    public static final int GAMECLEANALL=470;//����ġȭ�� �ʱ�ȭ
    public static final int GAMECOLOR=480;//������
    public static final int GAMECHAT=490;//���ӹ� ä��
    public static final int GAMEDOMANG=500;//���� ����(���Ƿγ���)
    public static final int GAMEANDOMANG=510; //���� ����(�����ִ»��)
    public static final int GAMETIMEOVER=520; //�ð��� ���������� ���� ����� ���� �� ó��
    public static final int GAMEROUNDEND=530;//���� �� ���� �����
    public static final int GAMEEND=540;//(��� ���� ��)
    // ä�� ����
    public static final int CHAT=700;//ä���ϱ�
    public static final int LOGOUT=900;//Ŭ���̾�Ʈ����??
    
}
