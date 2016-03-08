#include "DllGobangAI.h"
void  test()
{
	std::cout << "hello" << std::endl;
}

AIforGobangGame*   createInstanceOfAI(int status, int turn, const char * src)
{
	return new AIforGobangGame(status, turn, src);
}
	int AIforGobangGame::judge_result(int *map)//�жϵ�ǰ�����baiwin����heiwin������δ����
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
	void AIforGobangGame::record(int *map)//��¼�м�����Ϊ1�����ۺڰ�
	{
		int *tmp = (int *)malloc(size*size*sizeof(int));//��¼��������ľ���
		int k;
		if (myStatus == p.baistatus)//���AIִ���壬��¼���ʱ�ȷ�ת
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
	void AIforGobangGame::init()
	{
		iswin = false;
		step = 0;
	}
	AIforGobangGame::AIforGobangGame(int status, int turn, float qz1[96][48], float qz2[48])
	{
		myStatus = status;
		p = player(myStatus, 0);
		mynet = neuralnetworkofGobangBaseFeature(qz1, qz2);
		AIturn = turn;
		step = 0;
	}
	AIforGobangGame::AIforGobangGame(int status, int turn, neuralnetworkofGobangBaseFeature &net)
	{
		myStatus = status;
		p = player(myStatus, 0);
		mynet = net;
		AIturn = turn;
		step = 0;
	}
	AIforGobangGame::AIforGobangGame(int status, int turn, const char * src)//status��AI��״̬����ʾִ�׻���ִ�ڣ�turn���ֵ�AI�µ�ʱ���ֻ�����Ӧ�õ��ڵ�ֵ������Լ�ʵ�ֿ�������Ҳ�����ô˱���
		//����ʹ��1��-1��Ϊ�ֻ����������ʱ*-1��1Ϊ�ڣ�-1Ϊ�ף���ʼΪ1
		//status����Ϊ1��-1������Ϊ1������Ϊ-1
		//srcΪȨֵ�ļ�·�����ļ�������ʱ�Զ��½�����
	{
		myStatus = status;
		p = player(myStatus, 0);
		AIturn = turn;
		step = 0;
		bool isexist = false;
		std::fstream file;
		file.open(src, std::ios::_Nocreate | std::ios::in);
		isexist = file.is_open();
		if (isexist == true)
		{
			float tmp1[96][48];
			float tmp2[48];
			int i, j;
			for (i = 0; i < 96; i++)
			{
				for (j = 0; j < 48; j++)
				{
					file >> tmp1[i][j];
				}
			}
			for (i = 0; i < 48; i++)
			{
				file >> tmp2[i];
			}
			mynet = neuralnetworkofGobangBaseFeature(tmp1, tmp2);
		}
		else{
			mynet = neuralnetworkofGobangBaseFeature();
		}
		file.close();
	}
	void AIforGobangGame::makecmd(int *map, int &i, int &j)//�Է�δ������ʱ�Ż���ã����ֻ���¼δ�����ӵ����
	{
		record(map);
		p.computermakecmd(map, i, j, mynet);
	}
	void AIforGobangGame::saveWeight(const char * src)//����Ȩֵ
	{
		std::fstream file;
		file.open(src, std::fstream::out | std::ios_base::trunc);
		int i, j;
		for (i = 0; i < 96; i++)
		{
			for (j = 0; j < 48; j++)
			{
				file << std::fixed << std::setprecision(2) << mynet.quanzhi1[i][j];
				file << std::endl;
			}
		}
		for (i = 0; i < 48; i++)
		{

			file << std::fixed << std::setprecision(2) << mynet.quanzhi2[i];
			file << std::endl;

		}
		file.close();
	}
	void AIforGobangGame::judge_iswin(int winner)//��iswin��������
	{
		if (myStatus == winner)
		{
			iswin = true;
		}
		else{
			iswin = false;
		}
	}
	void AIforGobangGame::TD_study()
	{
		mynet.TD_study(stepmap, step, iswin);//ֻ��¼��δ�����ӵ���֣����û��step��step-1֮��
		for (int r = 0; r < step; r++)//ѧϰ��ϣ��ͷſռ�
		{
			free(stepmap[r]);
		}
	}
	int AIforGobangGame::judge(int *map)//�ж����״̬
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