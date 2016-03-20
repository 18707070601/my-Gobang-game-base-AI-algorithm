package GomoKu;

public class Player {
public int mystatus;//��ݣ����廹�ǰ���
public int myid;//idΪ0��������Ϊ1�������
public static final int computer = 0;
public static final int person = 1;
public int cmdi, cmdj;
public float maxint;
public float minint;
public static final int heistatus = 1;
public static final int baistatus = -1;
public static final int heiwin = 1;//��Ӯ
public static final int baiwin = -1;
public static final int drawgame = 0;//ƽ��
public static final int notfinish = 9;//��δ����
public static final int heizi = 1;
public static final int baizi = -1;
public static final int nilzi = 0;
final public int size=15;
public int tmpcounter=0;
int search_layer;
//method:
public Player()
{
	tmpcounter=0;
	mystatus = 0;
	myid = 0;
	cmdi = 0;
	cmdj = 0;
	maxint = 10000000;
	minint = -10000000;
}
public Player(int sta, int id, int search_para)
{
	search_layer = search_para;
	mystatus = sta;
	cmdi = 0;
	cmdj = 0;
	maxint = (float)10000000;
	minint = (float)(-10000000);
	if (id == computer || id == person)
		myid = id;
	else{
		//����
	}
}
public float valuefunc(int []p, Result rst, NeuralnetworkofGobangBaseFeature net,boolean is_computer_turn){//��ֵ����
	//Ҫ�����ҷ�ִ��/�׶�+1-1����ת����
	//Ĭ���ҷ������ԣ� ��
	int r = notfinish;
	r = judge(p, rst, 5);
	//baiwin=-1,heiwin=1
	if (r == (mystatus*(-1))) { /*printArray(p); system("pause");*/return  minint / 2; }
	else if (r == mystatus)  { /*printArray(p); system("pause");*/ return  maxint / 2; }
	int tmp[]=new int[size*size];
	int i;
	if (mystatus == baistatus)
	{
		for (i = 0; i < size*size; i++)//�ҷ�ִ�ף���ת֮�����жϾ���
		{
			if (p[i] == 0)
				tmp[i] = 0;
			else if (p[i]>0)
			{
				tmp[i] = -1;
			}
			else {
				tmp[i] = 1;
			}
		}
		net.getshuru(tmp);
	}
	else
	{
		net.getshuru(p);
	}
	net.cal_shuchu();
	float tmpf;
	tmpf = net.wofangf.willwin(is_computer_turn);
	tmpf -= net.duifangf.willwin(!is_computer_turn);
	if (tmpf > 0.3) { /*printArray(tmp); system("pause"); */return net.getshuchu() + maxint / 100 * tmpf+net.wofangf.count_win_num(is_computer_turn); }
	else if (tmpf < -0.3) { /*printArray(tmp); system("pause");*/ return net.getshuchu() + maxint / 100 * tmpf + net.duifangf.count_win_num(!is_computer_turn); }
	//cout << "valuefunc:" << net.getshuchu()<<endl;
	return net.getshuchu();
}
public float max(float a, float b)
{
	if (a > b)
		return a;
	else return b;
}
public float min(float a, float b)
{
	if (a < b)
		return a;
	else return b;
}
public int judge(int []tmap, Result rst, int lenlian)//�ж����
{
	int countbailian = 0, countheilian = 0;
	int i, j;
	int lenhei = 0;
	int lenbai = 0;
	for (i = 0; i < size; i++)//ɨ����
	{
		lenhei = 0;
		lenbai = 0;
		for (j = 0; j < size; j++){
			if (tmap[i*size + j] >0)//����
			{
				if (tmap[i*size + j] != 1)//record for juece
				{
					rst.set(i, j);
					
				}
				lenhei++;
				lenbai = 0;
			}
			else if (tmap[i*size + j] <0)//����
			{
				if (tmap[i*size + j] != -1)//record for juece
				{
					rst.set(i, j);
				}
				lenbai++;
				lenhei = 0;
			}
			else{//����
				lenhei = 0;
				lenbai = 0;
			}
			if (lenbai == lenlian)
			{
				//cout << "direction42bai" << endl;
				countbailian++;
			}

			if (lenhei == lenlian)
			{
				//cout << "direction42hei" << endl;
				countheilian++;
			}

		}
	}

	for (j = 0; j < size; j++)//ɨ����
	{
		lenhei = 0;
		lenbai = 0;
		for (i = 0; i < size; i++)
		{
			if (tmap[i*size + j] >0)//����
			{
				if (tmap[i*size + j] != 1)//record for juece
				{
					rst.set(i, j);
				}
				lenhei++;
				lenbai = 0;
			}
			else if (tmap[i*size + j] <0)//����
			{
				if (tmap[i*size + j] != -1)//record for juece
				{
					rst.set(i, j);
				}
				lenbai++;
				lenhei = 0;
			}
			else{//����
				lenhei = 0;
				lenbai = 0;
			}
			if (lenbai == lenlian)
			{
				//cout << "direction42bai" << endl;
				countbailian++;
			}

			if (lenhei == lenlian)
			{
				//cout << "direction42hei" << endl;
				countheilian++;
			}

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
			if (tmap[i*size + j] >0)//����
			{
				if (tmap[i*size + j] != 1)//record for juece
				{
					rst.set(i, j);
				}
				lenhei++;
				lenbai = 0;
			}
			else if (tmap[i*size + j] <0)//����
			{
				if (tmap[i*size + j] != -1)//record for juece
				{
					rst.set(i, j);
				}
				lenbai++;
				lenhei = 0;
			}
			else{//����
				lenhei = 0;
				lenbai = 0;
			}
			if (lenbai == lenlian)
			{
				//cout << "direction42bai" << endl;
				countbailian++;
			}

			if (lenhei == lenlian)
			{
				//cout << "direction42hei" << endl;
				countheilian++;
			}

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
			if (tmap[i*size + j] >0)//����
			{
				if (tmap[i*size + j] != 1)//record for juece
				{
					rst.set(i, j);
				}
				lenhei++;
				lenbai = 0;
			}
			else if (tmap[i*size + j] <0)//����
			{
				if (tmap[i*size + j] != -1)//record for juece
				{
					rst.set(i, j);
				}
				lenbai++;
				lenhei = 0;
			}
			else{//����
				lenhei = 0;
				lenbai = 0;
			}
			if (lenbai == lenlian)
			{
				//cout << "direction42bai" << endl;
				countbailian++;
			}

			if (lenhei == lenlian)
			{
				//cout << "direction42hei" << endl;
				countheilian++;
			}

			i++;
			j++;
		}
		j = rec_j;
	}

	for (i = 0; i < size; i++)//ɨ�����ϰ룬zuoб��
	{
		lenhei = 0;
		lenbai = 0;
		j = 0;
		int rec_i = i;
		while (i >= 0 && j < size)
		{
			if (tmap[i*size + j] >0)//����
			{
				if (tmap[i*size + j] != 1)//record for juece
				{
					rst.set(i, j);
				}
				lenhei++;
				lenbai = 0;
			}
			else if (tmap[i*size + j] <0)//����
			{
				if (tmap[i*size + j] != -1)//record for juece
				{
					rst.set(i, j);
				}
				lenbai++;
				lenhei = 0;
			}
			else{//����
				lenhei = 0;
				lenbai = 0;
			}
			if (lenbai == lenlian)
			{
				//cout << "direction42bai" << endl;
				countbailian++;
			}

			if (lenhei == lenlian)
			{
				//cout << "direction42hei" << endl;
				countheilian++;
			}

			i--;
			j++;
		}
		i = rec_i;
	}
	for (j = 1; j < size; j++)//ɨ�����°룬zuoб��
	{
		i = size - 1;
		lenhei = 0;
		lenbai = 0;
		int rec_j = j;
		while (i >= 1 && j < size)
		{
			if (tmap[i*size + j] >0)//����
			{
				if (tmap[i*size + j] != 1)//record for juece
				{
					rst.set(i, j);
				}
				lenhei++;
				lenbai = 0;
			}
			else if (tmap[i*size + j] <0)//����
			{
				if (tmap[i*size + j] != -1)
				{
					rst.set(i, j);
				}
				lenbai++;
				lenhei = 0;
			}
			else{//����
				lenhei = 0;
				lenbai = 0;
			}
			if (lenbai == lenlian)
			{
				//cout << "direction42bai" << endl;
				countbailian++;
			}

			if (lenhei == lenlian)
			{
				//cout << "direction42hei" << endl;
				countheilian++;
			}

			i--;
			j++;
		}
		j = rec_j;
	}
	if (countbailian > 0)
		return baiwin;
	if (countheilian > 0)
		return heiwin;
	return notfinish;
}
public float search(int []p, Result rst, int depth, int depthlimit, float rootvalue, NeuralnetworkofGobangBaseFeature net,int x_first_search_node,int y_first_search_node)
//depth��ǰ������ȣ����ڵ�Ϊ0��depthlimit����ȵ�����,���������01234����һ����5��.�״�����rootvalueֵ����
//depth��ǰ������ȣ����ڵ�Ϊ0��depthlimit����ȵ�����,���������01234����һ����5��.�״�����rootvalueֵ����
{

	float value = 0;
	//�� map ���÷�-1��0��1��ֵ�����ʱ���ӣ��������Ҫ���
	//�� map �е�x����չ���Ľڵ㣬��map�е�����1+x+1��-1-x-1���
	//depth%2==0ʱ�����Լ��£�ȡmax��==1ʱ��ȡmin
	if (depth % 2 == 0){
		value = minint;
	}
	else{
		value = maxint;
	}
	if (depth == depthlimit - 1)
	{
		value = valuefunc(p, rst, net,(boolean)(depthlimit%2==1));
		//cout << "cengshu" << depth << "zhi:" << value << endl;
		tmpcounter++;
		return value;
	}
	else
	{
		int x, y;
		//�������½ǣ�
		for (x = x_first_search_node; x < size; x++)
		{
			for (y = y_first_search_node; y < size; y++)
			{
				/*//������Ϣstart
				if (depth == 0)
					std::cout << x << "  " << y << std::endl;
					//������Ϣend*/
				if (p[x*size + y] == 0)//δ����
				{
					if (mystatus == heistatus)
					{
						if (depth % 2 == 0)
						{
							p[x*size + y] = 1 + depth + 1;
						}
						else
						{
							p[x*size + y] = -1 - depth - 1;
						}
					}
					else{
						if (depth % 2 == 0)
						{
							p[x*size + y] = -1 - depth - 1;
						}
						else{
							p[x*size + y] = 1 + depth + 1;
						}
					}
					if (depth % 2 == 0)
					{
						if (depth > 0 && rootvalue <= value)
						{
							p[x*size + y] = 0;
							// cout << "cengshu" << depth << "zhi:" << value << endl;
							return value;
						}
						else{
							float tmpvalue = value;
							value = max(search(p, rst, depth + 1, depthlimit, value, net,size/2,size/2), value);
							if (depth == 0 && Math.abs(tmpvalue - value) >= 0.001){//���ڵ����ֵ��ʱ�򣬼�¼�����ӵ�λ��
								cmdi = x;
								cmdj = y;
							}
						}
					}
					else{//depth%2==1
						if (rootvalue >= value){
							p[x*size + y] = 0;
							//  cout << "cengshu" << depth << "zhi:" << value << endl;
							return value;
						}
						else{
							value = min(search(p, rst, depth + 1, depthlimit, value, net,size/2,size/2), value);
						}

					}
					p[x*size + y] = 0;

				}

			}
		}
		//�������Ͻǣ�
		for (x = x_first_search_node; x >= 0; x--)
		{
			for (y = y_first_search_node; y < size; y++)
			{
				if (p[x*size + y] == 0)//δ����
				{
					if (mystatus == heistatus)
					{
						if (depth % 2 == 0)
						{
							p[x*size + y] = 1 + depth + 1;
						}
						else
						{
							p[x*size + y] = -1 - depth - 1;
						}
					}
					else{
						if (depth % 2 == 0)
						{
							p[x*size + y] = -1 - depth - 1;
						}
						else{
							p[x*size + y] = 1 + depth + 1;
						}
					}
					if (depth % 2 == 0)
					{
						if (depth > 0 && rootvalue <= value)
						{
							p[x*size + y] = 0;
							//  cout << "cengshu" << depth << "zhi:" << value << endl;
							return value;
						}
						else{
							float tmpvalue = value;
							value = max(search(p, rst, depth + 1, depthlimit, value, net,size/2,size/2), value);
							if (depth == 0 && Math.abs(tmpvalue - value) >= 0.001){//���ڵ����ֵ��ʱ�򣬼�¼�����ӵ�λ��
								cmdi = x;
								cmdj = y;
							}
						}
					}
					else{//depth%2==1
						if (rootvalue >= value){
							p[x*size + y] = 0;
							//   cout << "cengshu" << depth << "zhi:" << value << endl;
							return value;
						}
						else{
							value = min(search(p, rst, depth + 1, depthlimit, value, net,size/2,size/2), value);
						}

					}
					p[x*size + y] = 0;

				}

			}
		}
		//�������Ͻǣ�
		for (x = x_first_search_node; x >= 0; x--)
		{
			for (y = y_first_search_node; y >= 0; y--)
			{
				if (p[x*size + y] == 0)//δ����
				{
					if (mystatus == heistatus)
					{
						if (depth % 2 == 0)
						{
							p[x*size + y] = 1 + depth + 1;
						}
						else
						{
							p[x*size + y] = -1 - depth - 1;
						}
					}
					else{
						if (depth % 2 == 0)
						{
							p[x*size + y] = -1 - depth - 1;
						}
						else{
							p[x*size + y] = 1 + depth + 1;
						}
					}
					if (depth % 2 == 0)
					{
						if (depth > 0 && rootvalue <= value)
						{
							p[x*size + y] = 0;
							//  cout << "cengshu" << depth << "zhi:" << value << endl;
							return value;
						}
						else{
							float tmpvalue = value;
							value = max(search(p, rst, depth + 1, depthlimit, value, net,size/2,size/2), value);
							if (depth == 0 && Math.abs(tmpvalue - value) >= 0.001){//���ڵ����ֵ��ʱ�򣬼�¼�����ӵ�λ��
								cmdi = x;
								cmdj = y;
							}
						}
					}
					else{//depth%2==1
						if (rootvalue >= value){
							p[x*size + y] = 0;
							//  cout << "cengshu" << depth << "zhi:" << value << endl;
							return value;
						}
						else{
							value = min(search(p, rst, depth + 1, depthlimit, value, net,size/2,size/2), value);
						}

					}
					p[x*size + y] = 0;

				}

			}
		}
		//�������½ǣ�
		for (x = x_first_search_node; x < size; x++)
		{
			for (y = y_first_search_node; y >= 0; y--)
			{
				if (p[x*size + y] == 0)//δ����
				{
					if (mystatus == heistatus)
					{
						if (depth % 2 == 0)
						{
							p[x*size + y] = 1 + depth + 1;
						}
						else
						{
							p[x*size + y] = -1 - depth - 1;
						}
					}
					else{
						if (depth % 2 == 0)
						{
							p[x*size + y] = -1 - depth - 1;
						}
						else{
							p[x*size + y] = 1 + depth + 1;
						}
					}
					if (depth % 2 == 0)
					{
						if (depth > 0 && rootvalue <= value)
						{
							p[x*size + y] = 0;
							//  cout << "cengshu" << depth << "zhi:" << value << endl;
							return value;
						}
						else{
							float tmpvalue = value;
							value = max(search(p, rst, depth + 1, depthlimit, value, net,size/2,size/2), value);
							if (depth == 0 && Math.abs(tmpvalue - value) >= 0.001){//���ڵ����ֵ��ʱ�򣬼�¼�����ӵ�λ��
								cmdi = x;
								cmdj = y;
							}
						}
					}
					else{//depth%2==1
						if (rootvalue >= value){
							p[x*size + y] = 0;
							return value;
						}
						else{
							value = min(search(p, rst, depth + 1, depthlimit, value, net,size/2,size/2), value);
						}

					}
					p[x*size + y] = 0;
				}
			}
		}
		return value;
	}
}
public void computermakecmd(int []map, Result rst, NeuralnetworkofGobangBaseFeature  net)
{
	tmpcounter = 0;
	int x = 0, y = 0;
	if (search_layer % 2 == 1)
	{
		search(map, rst, 0, 3, maxint, net,size/2,size/2);//����3��
	}
	else{
		search(map, rst, 0, 2, maxint, net,size/2,size/2);//����2��
	}
	if(search_layer>3) search(map, rst, 0, search_layer, maxint, net,cmdi,cmdj);//�������������Ľ����Ϊ�������
	if (map[cmdi*size + cmdj] != 0)
	{
		cmdi = x;
		cmdj = y;
		
	}
	rst.set(cmdi, cmdj);
}
public void setmyid(int id){//����player��id���Լ����Ƕ��֡�
	if (id == computer || id == person){
		myid = id;
	}
	else{
		//id ֵ����
	}
}

}
