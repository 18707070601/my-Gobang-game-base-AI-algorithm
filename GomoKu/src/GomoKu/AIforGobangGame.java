package GomoKu;
class Result{
	int x;int y;
	public Result()
	{
		x=0;y=0;
	}
	public void set(int i,int j)
	{
		x=i;
		y=j;
	}
	public int getx()
	{
		return x;
	}
	public int gety()
	{
		return y;
	}
}
public class AIforGobangGame {
final public int size=15;
private int myStatus;
private int stepmap[][];
private int step;
private Player p;
private NeuralnetworkofGobangBaseFeature mynet;
private boolean iswin;
private myIO myio;
private String encodingType;
private int judge_result(int []map)//�жϵ�ǰ�����baiwin����heiwin������δ����
{
	int i, j;
	int lenhei = 0;
	int lenbai = 0;
	for (i = 0; i < size; i++)//ɨ����
	{
		lenhei = 0;
		lenbai = 0;
		for (j = 0; j < size; j++){
			if (map[i*size + j] == heizi)//����
			{
				lenhei++;
				lenbai = 0;
			}
			else if (map[i*size + j] == baizi)//����
			{
				lenbai++;
				lenhei = 0;
			}
			else{//����
				lenhei = 0;
				lenbai = 0;
			}
			if (lenhei == 5)
				return heiwin;
			else if (lenbai == 5)
				return baiwin;
		}
	}

	for (j = 0; j < size; j++)//ɨ����
	{
		lenhei = 0;
		lenbai = 0;
		for (i = 0; i < size; i++)
		{
			if (map[i*size + j] == heizi)//����
			{
				lenhei++;
				lenbai = 0;
			}
			else if (map[i*size + j] == baizi)//����
			{
				lenbai++;
				lenhei = 0;
			}
			else{//����
				lenhei = 0;
				lenbai = 0;
			}
			if (lenhei == 5)
				return heiwin;
			else if (lenbai == 5)
				return baiwin;
		}
	}

	for (i = 0; i < size; i++)//ɨ�����°룬��б��
	{
		j = 0;
		lenhei = 0;
		lenbai = 0;
		int rec_i = i;
		while (i < size&&j < size)
		{
			if (map[i*size + j] == heizi)//����
			{
				lenhei++;
				lenbai = 0;
			}
			else if (map[i*size + j] == baizi)//����
			{
				lenbai++;
				lenhei = 0;
			}
			else{//����
				lenhei = 0;
				lenbai = 0;
			}
			if (lenhei == 5)
				return heiwin;
			else if (lenbai == 5)
				return baiwin;
			i++;
			j++;
		}
		i = rec_i;
	}

	for (j = 1; j < size; j++)//ɨ�����ϰ룬��б��
	{
		i = 0;
		lenhei = 0;
		lenbai = 0;
		int rec_j = j;
		while (i < size - 1 && j < size)
		{
			if (map[i*size + j] == heizi)//����
			{
				lenhei++;
				lenbai = 0;
			}
			else if (map[i*size + j] == baizi)//����
			{
				lenbai++;
				lenhei = 0;
			}
			else{//����
				lenhei = 0;
				lenbai = 0;
			}
			if (lenhei == 5)
				return heiwin;
			else if (lenbai == 5)
				return baiwin;
			i++;
			j++;
		}
		j = rec_j;
	}

	for (i = 0; i < size; i++)//ɨ�����ϰ룬��б��
	{
		lenhei = 0;
		lenbai = 0;
		j = 0;
		int rec_i = i;
		while (i >= 0 && j < size)
		{
			if (map[i*size + j] == heizi)//����
			{
				lenhei++;
				lenbai = 0;
			}
			else if (map[i*size + j] == baizi)//����
			{
				lenbai++;
				lenhei = 0;
			}
			else{//����
				lenhei = 0;
				lenbai = 0;
			}
			if (lenhei == 5)
				return heiwin;
			else if (lenbai == 5)
				return baiwin;
			i--;
			j++;
		}
		i = rec_i;
	}
	for (j = 1; j < size; j++)//ɨ�����°룬��б��
	{
		i = size - 1;
		lenhei = 0;
		lenbai = 0;
		int rec_j = j;
		while (i >= 1 && j < size)
		{
			if (map[i*size + j] == heizi)//����
			{
				lenhei++;
				lenbai = 0;
			}
			else if (map[i*size + j] == baizi)//����
			{
				lenbai++;
				lenhei = 0;
			}
			else{//����
				lenhei = 0;
				lenbai = 0;
			}
			if (lenhei == 5)
				return heiwin;
			else if (lenbai == 5)
				return baiwin;
			i--;
			j++;
		}
		j = rec_j;
	}
	return notfinish;
}
private void record(int []map)//��¼�м�����Ϊ1�����ۺڰ�
{
	int tmp[] = new int[size*size];//(int *)malloc(size*size*sizeof(int));//��¼��������ľ���
	int k;
	if (myStatus == Player.baistatus)//���AIִ���壬��¼���ʱ�ȷ�ת
	{
		for (k = 0; k < size*size; k++)
		{
			tmp[k] = map[k] * (-1);
		}
	}
	else {
		for (k = 0; k < size*size; k++)
		{
			tmp[k] = map[k];
		}
	}
	stepmap[step] = tmp;
	step++;
}
//�������֣�
public static final int heiwin = 1;//��Ӯ
public static final int baiwin = -1;
public static final int drawgame = 0;//ƽ��
public static final int notfinish = 9;//��δ����
public static final int heizi = 1;
public static final int baizi = -1;
public static final int nilzi = 0;
//method:
public int AIturn;
public void init()
{
	iswin = false;
	step = 0;
}
public AIforGobangGame(int status, int turn, float qz1[][], float qz2[],String encode)
{
	encodingType=encode;
	myio=new myIO(1);
	stepmap=new int [size*size][size*size];
	myStatus = status;
	p = new Player(myStatus, 0);
	mynet = new NeuralnetworkofGobangBaseFeature(qz1, qz2);
	AIturn = turn;
	step = 0;
}
public AIforGobangGame(int status, int turn, NeuralnetworkofGobangBaseFeature net,String encode)
{
	encodingType=encode;
	myio=new myIO(1);
	stepmap=new int [size*size][size*size];
	myStatus = status;
	p = new Player(myStatus, 0);
	mynet = net;
	AIturn = turn;
	step = 0;
}
public AIforGobangGame(int status, int turn, String src,String encode)//status��AI��״̬����ʾִ�׻���ִ�ڣ�turn���ֵ�AI�µ�ʱ���ֻ�����Ӧ�õ��ڵ�ֵ������Լ�ʵ�ֿ�������Ҳ�����ô˱���
//����ʹ��1��-1��Ϊ�ֻ����������ʱ*-1��1Ϊ�ڣ�-1Ϊ�ף���ʼΪ1
//status����Ϊ1��-1������Ϊ1������Ϊ-1
//srcΪȨֵ�ļ�·�����ļ�������ʱ�Զ��½�����
{
	stepmap=new int[size*size][size*size];
myStatus = status;
encodingType=encode;
p = new Player(myStatus, 0);
AIturn = turn;
step = 0;
boolean isexist = false;
myio=new myIO(1);
isexist = myIO.isFileExist(src);

if (isexist == true)
{
	myio.startRead(src, encodingType, 0);
	float tmp1[][]=new float[96][48];
	float tmp2[]=new float [48];
	int i, j;
	for (i = 0; i < 96; i++)
	{
		for (j = 0; j < 48; j++)
		{
			tmp1[i][j]=Float.parseFloat(myio.readOneSentence(0));
		}
	}
	for (i = 0; i < 48; i++)
	{
		tmp2[i]=Float.parseFloat(myio.readOneSentence(0));
	}
	mynet =new NeuralnetworkofGobangBaseFeature(tmp1, tmp2);
	myio.endRead(0);
}
else{
	mynet =new NeuralnetworkofGobangBaseFeature();
}

}
public void makecmd(int []map, Result rst)//�Է�δ������ʱ�Ż���ã����ֻ���¼δ�����ӵ����
{
	record(map);
	p.computermakecmd(map, rst, mynet);
}
public void saveWeight(String src)//����Ȩֵ
{
	//System.out.println();
	myio.startWrite(src, encodingType, 0);
	int i, j;
	for (i = 0; i < 96; i++)
	{
		for (j = 0; j < 48; j++)
		{
			myio.writeOneString(String.valueOf(mynet.quanzhi1[i][j])+"\r\n", 0);
		}
	}
	for (i = 0; i < 48; i++)
	{
		myio.writeOneString(String.valueOf(mynet.quanzhi2[i])+"\r\n", 0);
	}
	myio.endWrite(0);
	System.out.println("xie ru cg");
}
public void judge_iswin(int winner)//��iswin��������
{
	if (myStatus == winner)
	{
		iswin = true;
	}
	else{
		iswin = false;
	}
}
public void TD_study()
{
	mynet.TD_study(stepmap, step, iswin);//ֻ��¼��δ�����ӵ���֣����û��step��step-1֮��
	/*for (int r = 0; r < step; r++)//ѧϰ��ϣ��ͷſռ�
	{
		
	}*/
}
public int judge(int []map)//�ж����״̬
{
	int s;
	int tmp_judge = judge_result(map);
	for (s = 0; s < size*size; s++)//ɨ�������Ƿ�����
	{
		if (map[s] == 0)
			break;
	}
	if (s == size*size&&tmp_judge == notfinish)//��������������δ������drawgame
	{
		tmp_judge = drawgame;
	}
	return tmp_judge;
}
}
