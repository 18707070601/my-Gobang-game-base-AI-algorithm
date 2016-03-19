package GomoKu;

import javax.swing.JOptionPane;

class  Dead{
	public int num;
	final public int size=100;
	public int starti[], startj[];
	public int endi[], endj[];
	public int direction[];
	public Dead()
	{
		num=0;
		starti=new int [size];
		startj=new int [size];
		endi=new int [size];
		endj=new int [size];
		direction=new int [size];
	}
	/*public:
	void add(int x, int y, int d){
	i[num] = x;
	i[num] = y;
	direction[num] = d;
	}*/
};
class Halfalive{
	public int num;
	final public int size=100;
	public int starti[], startj[];
	public int endi[], endj[];
	public int direction[];
	public int vir_si[], vir_sj[], vir_ei[], vir_ej[];
	public Halfalive()
	{
		num=0;
		starti=new int [size];
		startj=new int [size];
		endi=new int [size];
		endj=new int [size];
		direction=new int [size];
		vir_si=new int [size];
		vir_sj=new int [size];
		vir_ei=new int [size];
		vir_ej=new int [size];
	}
};
class Alive{
	public int num;
	final public int size=100;
	public int starti[], startj[];
	public int endi[], endj[];
	public int direction[];
	public int vir_si[], vir_sj[], vir_ei[], vir_ej[];
	public Alive()
	{
		num=0;
		starti=new int [size];
		startj=new int [size];
		endi=new int [size];
		endj=new int [size];
		direction=new int [size];
		vir_si=new int [size];
		vir_sj=new int [size];
		vir_ei=new int [size];
		vir_ej=new int [size];
	}
};
class Sumforsearch{
	public int len;//��ʵ���� =2���ǳ���Ϊ2
	public int vir_si, vir_sj, vir_ei, vir_ej;
	public int virlen;
	public int direction;
	public boolean isalive;
	public Sumforsearch()
	{
		
	}
};
class Feature{//����һ������������������Ҫ������������
	final public int size=15;
	//method:
public Dead dead[];
public Halfalive halfalive[];
public Alive alive[];
public int vir_halfdead22, vir_halfdead23, vir_halfdead24, vir_halfdead33, vir_halfdead34, vir_halfdead44;
public int vir_halfalive22, vir_halfalive23, vir_halfalive24, vir_halfalive33, vir_halfalive34, vir_halfalive44;
public int vir_alive22, vir_alive23, vir_alive24, vir_alive33, vir_alive34, vir_alive44;
public int halfdead22, halfdead23, halfdead24, halfdead33, halfdead34, halfdead44;
public int halfalive22, halfalive23, halfalive24, halfalive33, halfalive34, halfalive44;
public int alive22, alive23, alive24, alive33, alive34, alive44;
public int direction1 = 1;//��
public int direction2 = 2;//��
public int direction3 = 3;//����б
public int direction4 = 4;//����б
public float willwin(boolean isyourturn)

{
	if (isyourturn == true)
	{
		if (alive[3].num > 0 || halfalive[3].num>0)//1
		{
			//cout << "5.5route:" << endl;
			return (float) 5.5;
		}
		else if (alive33 > 0 || alive23 > 0 || halfalive33 > 0 || vir_alive33 > 0 || vir_alive23 > 0 || vir_halfalive23 > 0 || vir_halfalive33 > 0 || vir_halfdead33>0)//xiabu*4 2
		{
			//cout << "4.5route:" << endl;
			//cout << alive33 << " " << alive23 << " " << vir_halfdead33 << " " << vir_halfalive33 << " " << vir_halfalive23 << " " << vir_halfdead33 << " " << alive23 << " " << vir_alive23 << " " << halfalive33 << endl;
			return (float) 4.5;
		}
		else if (vir_alive22 > 0)//xiabushuangsan 3
		{
			//cout << "3.5route:" << endl;
			return (float) 3.5;
		}
		else {
			return 0;
		}
	}
	else{
		if (alive[3].num>0 || halfalive34>0 || halfalive44>0 || halfdead44>0 || vir_halfalive34>0 || vir_halfalive44>0 || vir_halfdead44>0)//1
		{
			//cout << "5route:" << endl;
			return 5;
		}
		else if (alive33 > 0 || vir_alive33 > 0)//xiabu*4 2b
		{
			//cout << "4route:" << endl;
			//cout << alive33 << " " << alive23 << " " << vir_halfdead33 << " " << vir_halfalive33 << " " << vir_halfalive23 << " " << vir_halfdead33 << " " << alive23 << " " << vir_alive23 << " " << halfalive33 << endl;
			return 4;
		}
		/*else if (vir_alive22 > 0 )//xiabushuangsan 3
		{
		cout << "3route:" << endl;
		return 3;
		}*/
		else { return 0; }
	}
}
public Feature()
{
	dead=new Dead[4];
	halfalive=new Halfalive[4];
	alive=new Alive[4];
	int i;
	for(i=0;i<4;i++)
	{
		dead[i]=new Dead();
		halfalive[i]=new Halfalive();
		alive[i]=new Alive();
	}
	
	
	
	vir_halfdead22 = 0; vir_halfdead23 = 0; vir_halfdead24 = 0; vir_halfdead33 = 0; vir_halfdead34 = 0; vir_halfdead44 = 0;
	vir_halfalive22 = 0; vir_halfalive23 = 0; vir_halfalive24 = 0; vir_halfalive33 = 0; vir_halfalive34 = 0; vir_halfalive44 = 0;
	vir_alive22 = 0; vir_alive23 = 0; vir_alive24 = 0; vir_alive33 = 0; vir_alive34 = 0; vir_alive44 = 0;
	halfdead22 = 0; halfdead23 = 0; halfdead24 = 0; halfdead33 = 0; halfdead34 = 0; halfdead44 = 0;
	halfalive22 = 0; halfalive23 = 0; halfalive24 = 0; halfalive33 = 0; halfalive34 = 0; halfalive44 = 0;
	alive22 = 0; alive23 = 0; alive24 = 0; alive33 = 0; alive34 = 0; alive44 = 0;
}
public boolean vaild_ij_check(int t)
//false�ǷǷ�
{
	if (t<0 || t>14)
		return false;
	else return true;
}
public void heiOrbai_extractfeature(int []map, int size, int color)
//��ȡ������������ȡ����֮ǰ����������������Ȼ�˺���������Խ��
{
	int i, j;
	//��ɨ�裺
	for (i = 0; i < size; i++)
	{
		int len = 0;
		int last = color;
		int sx=0; int sy=0;int ex=0;int ey=0;
		boolean start_dead = false;
		for (j = 0; j < size; j++)//ɨ����
		{
			if (map[i*size + j] == color)
			{

				if (len == 0)
				{
					sx = i;
					sy = j;
					if (sy == 0 || (last != color&&last != 0))
						start_dead = true;
				}

				len++;
				ex = i;
				ey = j;
				last = color;
			}
			else{
				if (len > 0)
				{
					if (map[i*size + j] == 0){
						if (start_dead == true){
							int id = halfalive[len - 1].num;
							halfalive[len - 1].starti[id] = sx;
							halfalive[len - 1].startj[id] = sy;
							halfalive[len - 1].endi[id] = ex;
							halfalive[len - 1].endj[id] = ey;
							halfalive[len - 1].direction[id] = direction1;
							halfalive[len - 1].num++;
						}
						else {
							int id = alive[len - 1].num;
							alive[len - 1].starti[id] = sx;
							alive[len - 1].startj[id] = sy;
							alive[len - 1].endi[id] = ex;
							alive[len - 1].endj[id] = ey;
							alive[len - 1].direction[id] = direction1;
							alive[len - 1].num++;
						}
					}
					else{
						if (start_dead == true){
							int id = dead[len - 1].num;
							dead[len - 1].starti[id] = sx;
							dead[len - 1].startj[id] = sy;
							dead[len - 1].endi[id] = ex;
							dead[len - 1].endj[id] = ey;
							dead[len - 1].direction[id] = direction1;
							dead[len - 1].num++;
						}
						else {
							int id = halfalive[len - 1].num;
							halfalive[len - 1].starti[id] = sx;
							halfalive[len - 1].startj[id] = sy;
							halfalive[len - 1].endi[id] = ex;
							halfalive[len - 1].endj[id] = ey;
							halfalive[len - 1].direction[id] = direction1;
							halfalive[len - 1].num++;
						}
					}
				}
				len = 0;
				last = map[i*size + j];
			}
		}
		if (len > 0)
		{
			if (start_dead == true)
			{
				int id = dead[len - 1].num;
				dead[len - 1].starti[id] = sx;
				dead[len - 1].startj[id] = sy;
				dead[len - 1].endi[id] = ex;
				dead[len - 1].endj[id] = ey;
				dead[len - 1].direction[id] = direction1;
				dead[len - 1].num++;
			}
			else{
				int id = halfalive[len - 1].num;
				halfalive[len - 1].starti[id] = sx;
				halfalive[len - 1].startj[id] = sy;
				halfalive[len - 1].endi[id] = ex;
				halfalive[len - 1].endj[id] = ey;
				halfalive[len - 1].direction[id] = direction1;
				halfalive[len - 1].num++;
			}
		}
	}
	//��ɨ�裺
	for (j = 0; j < size; j++)
	{
		int len = 0;
		int last = color;
		int sx=0; int sy=0;int ex=0;int ey=0;
		boolean start_dead = false;
		for (i = 0; i < size; i++)//ɨ��lie
		{
			if (map[i*size + j] == color)
			{

				if (len == 0)
				{
					sx = i;
					sy = j;
					if (sx == 0 || (last != color&&last != 0))//�жϿ�ͷ�Ƿ񱻶�
						start_dead = true;
				}
				len++;
				ex = i;
				ey = j;
				last = color;
			}
			else{
				if (len > 0)//��Ѱ��������0
				{
					if (map[i*size + j] == 0){//��βͨ
						if (start_dead == true){
							int id = halfalive[len - 1].num;
							halfalive[len - 1].starti[id] = sx;
							halfalive[len - 1].startj[id] = sy;
							halfalive[len - 1].endi[id] = ex;
							halfalive[len - 1].endj[id] = ey;
							halfalive[len - 1].direction[id] = direction2;
							halfalive[len - 1].num++;
						}
						else {
							int id = alive[len - 1].num;
							alive[len - 1].starti[id] = sx;
							alive[len - 1].startj[id] = sy;
							alive[len - 1].endi[id] = ex;
							alive[len - 1].endj[id] = ey;
							alive[len - 1].direction[id] = direction2;
							alive[len - 1].num++;
						}
					}
					else{//��β����
						if (start_dead == true){
							int id = dead[len - 1].num;
							dead[len - 1].starti[id] = sx;
							dead[len - 1].startj[id] = sy;
							dead[len - 1].endi[id] = ex;
							dead[len - 1].endj[id] = ey;
							dead[len - 1].direction[id] = direction2;
							dead[len - 1].num++;
						}
						else {
							int id = halfalive[len - 1].num;
							halfalive[len - 1].starti[id] = sx;
							halfalive[len - 1].startj[id] = sy;
							halfalive[len - 1].endi[id] = ex;
							halfalive[len - 1].endj[id] = ey;
							halfalive[len - 1].direction[id] = direction2;
							halfalive[len - 1].num++;
						}
					}
				}
				len = 0;
				last = map[i*size + j];
			}
		}
		if (len > 0)
		{
			if (start_dead == true)
			{
				int id = dead[len - 1].num;
				dead[len - 1].starti[id] = sx;
				dead[len - 1].startj[id] = sy;
				dead[len - 1].endi[id] = ex;
				dead[len - 1].endj[id] = ey;
				dead[len - 1].direction[id] = direction2;
				dead[len - 1].num++;
			}
			else{
				int id = halfalive[len - 1].num;
				halfalive[len - 1].starti[id] = sx;
				halfalive[len - 1].startj[id] = sy;
				halfalive[len - 1].endi[id] = ex;
				halfalive[len - 1].endj[id] = ey;
				halfalive[len - 1].direction[id] = direction2;
				halfalive[len - 1].num++;
			}
		}
	}
	//����->����ɨ�裺
	//�°벿�֣�
	for (i = 0; i < size; i++)
	{
		j = 0;
		int len = 0;
		int last = color;
		int sx=0; int sy=0;int ex=0;int ey=0;
		boolean start_dead = false;
		int rec_i = i;
		while (i < size&&j < size)//ɨ��3 xia
		{
			if (map[i*size + j] == color)
			{

				if (len == 0)
				{
					sx = i;
					sy = j;
					if (sy == 0 || (last != color&&last != 0))//�жϿ�ͷ�Ƿ񱻶�
						start_dead = true;
				}
				len++;
				ex = i;
				ey = j;
				last = color;
			}
			else{
				if (len > 0)//��Ѱ��������0
				{
					if (map[i*size + j] == 0){//��βͨ
						if (start_dead == true){
							int id = halfalive[len - 1].num;
							halfalive[len - 1].starti[id] = sx;
							halfalive[len - 1].startj[id] = sy;
							halfalive[len - 1].endi[id] = ex;
							halfalive[len - 1].endj[id] = ey;
							halfalive[len - 1].direction[id] = direction3;
							halfalive[len - 1].num++;
						}
						else {
							int id = alive[len - 1].num;
							alive[len - 1].starti[id] = sx;
							alive[len - 1].startj[id] = sy;
							alive[len - 1].endi[id] = ex;
							alive[len - 1].endj[id] = ey;
							alive[len - 1].direction[id] = direction3;
							alive[len - 1].num++;
						}
					}
					else{//��β����
						if (start_dead == true){
							int id = dead[len - 1].num;
							dead[len - 1].starti[id] = sx;
							dead[len - 1].startj[id] = sy;
							dead[len - 1].endi[id] = ex;
							dead[len - 1].endj[id] = ey;
							dead[len - 1].direction[id] = direction3;
							dead[len - 1].num++;
						}
						else {
							int id = halfalive[len - 1].num;
							halfalive[len - 1].starti[id] = sx;
							halfalive[len - 1].startj[id] = sy;
							halfalive[len - 1].endi[id] = ex;
							halfalive[len - 1].endj[id] = ey;
							halfalive[len - 1].direction[id] = direction3;
							halfalive[len - 1].num++;
						}
					}
				}
				len = 0;
				last = map[i*size + j];
			}
			i++;
			j++;
		}
		if (len > 0)
		{
			if (start_dead == true)
			{
				int id = dead[len - 1].num;
				dead[len - 1].starti[id] = sx;
				dead[len - 1].startj[id] = sy;
				dead[len - 1].endi[id] = ex;
				dead[len - 1].endj[id] = ey;
				dead[len - 1].direction[id] = direction3;
				dead[len - 1].num++;
			}
			else{
				int id = halfalive[len - 1].num;
				halfalive[len - 1].starti[id] = sx;
				halfalive[len - 1].startj[id] = sy;
				halfalive[len - 1].endi[id] = ex;
				halfalive[len - 1].endj[id] = ey;
				halfalive[len - 1].direction[id] = direction3;
				halfalive[len - 1].num++;
			}
		}
		i = rec_i;
	}
	//�ϰ벿�֣�
	for (j = 1; j < size; j++)
	{
		i = 0;
		int len = 0;
		int last = color;
		int sx=0; int sy=0;int ex=0;int ey=0;
		boolean start_dead = false;
		int rec_j = j;
		while (i < size - 1 && j < size)//ɨ��3 shang
		{
			if (map[i*size + j] == color)
			{

				if (len == 0)
				{
					sx = i;
					sy = j;
					if (sx == 0 || (last != color&&last != 0))//�жϿ�ͷ�Ƿ񱻶�
						start_dead = true;
				}
				len++;
				ex = i;
				ey = j;
				last = color;
			}
			else{
				if (len > 0)//��Ѱ��������0
				{
					if (map[i*size + j] == 0){//��βͨ
						if (start_dead == true){
							int id = halfalive[len - 1].num;
							halfalive[len - 1].starti[id] = sx;
							halfalive[len - 1].startj[id] = sy;
							halfalive[len - 1].endi[id] = ex;
							halfalive[len - 1].endj[id] = ey;
							halfalive[len - 1].direction[id] = direction3;
							halfalive[len - 1].num++;
						}
						else {
							int id = alive[len - 1].num;
							alive[len - 1].starti[id] = sx;
							alive[len - 1].startj[id] = sy;
							alive[len - 1].endi[id] = ex;
							alive[len - 1].endj[id] = ey;
							alive[len - 1].direction[id] = direction3;
							alive[len - 1].num++;
						}
					}
					else{//��β����
						if (start_dead == true){
							int id = dead[len - 1].num;
							dead[len - 1].starti[id] = sx;
							dead[len - 1].startj[id] = sy;
							dead[len - 1].endi[id] = ex;
							dead[len - 1].endj[id] = ey;
							dead[len - 1].direction[id] = direction3;
							dead[len - 1].num++;
						}
						else {
							int id = halfalive[len - 1].num;
							halfalive[len - 1].starti[id] = sx;
							halfalive[len - 1].startj[id] = sy;
							halfalive[len - 1].endi[id] = ex;
							halfalive[len - 1].endj[id] = ey;
							halfalive[len - 1].direction[id] = direction3;
							halfalive[len - 1].num++;
						}
					}
				}
				len = 0;
				last = map[i*size + j];
			}
			i++;
			j++;
		}
		if (len > 0)
		{
			if (start_dead == true)
			{
				int id = dead[len - 1].num;
				dead[len - 1].starti[id] = sx;
				dead[len - 1].startj[id] = sy;
				dead[len - 1].endi[id] = ex;
				dead[len - 1].endj[id] = ey;
				dead[len - 1].direction[id] = direction3;
				dead[len - 1].num++;
			}
			else{
				int id = halfalive[len - 1].num;
				halfalive[len - 1].starti[id] = sx;
				halfalive[len - 1].startj[id] = sy;
				halfalive[len - 1].endi[id] = ex;
				halfalive[len - 1].endj[id] = ey;
				halfalive[len - 1].direction[id] = direction3;
				halfalive[len - 1].num++;
			}
		}
		j = rec_j;
	}
	//����->����ɨ�裺
	//�°벿�֣�
	for (j = 0; j < size; j++)
	{
		i = size - 1;
		int len = 0;
		int last = color;
		int sx=0; int sy=0;int ex=0;int ey=0;
		boolean start_dead = false;
		int rec_j = j;
		while (i >= 0 && j < size)//ɨ��4 xia
		{
			if (map[i*size + j] == color)
			{

				if (len == 0)
				{
					sx = i;
					sy = j;
					if (sx == size - 1 || (last != color&&last != 0))//�жϿ�ͷ�Ƿ񱻶�
						start_dead = true;
				}
				len++;
				ex = i;
				ey = j;
				last = color;
			}
			else{
				if (len > 0)//��Ѱ��������0
				{
					if (map[i*size + j] == 0){//��βͨ
						if (start_dead == true){
							int id = halfalive[len - 1].num;
							halfalive[len - 1].starti[id] = sx;
							halfalive[len - 1].startj[id] = sy;
							halfalive[len - 1].endi[id] = ex;
							halfalive[len - 1].endj[id] = ey;
							halfalive[len - 1].direction[id] = direction4;
							halfalive[len - 1].num++;
						}
						else {
							int id = alive[len - 1].num;
							alive[len - 1].starti[id] = sx;
							alive[len - 1].startj[id] = sy;
							alive[len - 1].endi[id] = ex;
							alive[len - 1].endj[id] = ey;
							alive[len - 1].direction[id] = direction4;
							alive[len - 1].num++;
						}
					}
					else{//��β����
						if (start_dead == true){
							int id = dead[len - 1].num;
							dead[len - 1].starti[id] = sx;
							dead[len - 1].startj[id] = sy;
							dead[len - 1].endi[id] = ex;
							dead[len - 1].endj[id] = ey;
							dead[len - 1].direction[id] = direction4;
							dead[len - 1].num++;
						}
						else {
							int id = halfalive[len - 1].num;
							halfalive[len - 1].starti[id] = sx;
							halfalive[len - 1].startj[id] = sy;
							halfalive[len - 1].endi[id] = ex;
							halfalive[len - 1].endj[id] = ey;
							halfalive[len - 1].direction[id] = direction4;
							halfalive[len - 1].num++;
						}
					}
				}
				len = 0;
				last = map[i*size + j];
			}
			i--;
			j++;
		}
		if (len > 0)
		{
			if (start_dead == true)
			{
				int id = dead[len - 1].num;
				dead[len - 1].starti[id] = sx;
				dead[len - 1].startj[id] = sy;
				dead[len - 1].endi[id] = ex;
				dead[len - 1].endj[id] = ey;
				dead[len - 1].direction[id] = direction4;
				dead[len - 1].num++;
			}
			else{
				int id = halfalive[len - 1].num;
				halfalive[len - 1].starti[id] = sx;
				halfalive[len - 1].startj[id] = sy;
				halfalive[len - 1].endi[id] = ex;
				halfalive[len - 1].endj[id] = ey;
				halfalive[len - 1].direction[id] = direction4;
				halfalive[len - 1].num++;
			}
		}
		j = rec_j;
	}
	//�ϰ벿�֣�
	for (i = 0; i < size - 1; i++)
	{
		j = 0;
		int len = 0;
		int last = color;
		int sx=0; int sy=0;int ex=0;int ey=0;
		boolean start_dead = false;
		int rec_i = i;
		while (i >= 0 && j < size - 1)//ɨ��4 shang
		{
			if (map[i*size + j] == color)
			{

				if (len == 0)
				{
					sx = i;
					sy = j;
					if (sy == 0 || (last != color&&last != 0))//�жϿ�ͷ�Ƿ񱻶�
						start_dead = true;
				}
				len++;
				ex = i;
				ey = j;
				last = color;
			}
			else{
				if (len > 0)//��Ѱ��������0
				{
					if (map[i*size + j] == 0){//��βͨ
						if (start_dead == true){
							int id = halfalive[len - 1].num;
							halfalive[len - 1].starti[id] = sx;
							halfalive[len - 1].startj[id] = sy;
							halfalive[len - 1].endi[id] = ex;
							halfalive[len - 1].endj[id] = ey;
							halfalive[len - 1].direction[id] = direction4;
							halfalive[len - 1].num++;
						}
						else {
							int id = alive[len - 1].num;
							alive[len - 1].starti[id] = sx;
							alive[len - 1].startj[id] = sy;
							alive[len - 1].endi[id] = ex;
							alive[len - 1].endj[id] = ey;
							alive[len - 1].direction[id] = direction4;
							alive[len - 1].num++;
						}
					}
					else{//��β����
						if (start_dead == true){
							int id = dead[len - 1].num;
							dead[len - 1].starti[id] = sx;
							dead[len - 1].startj[id] = sy;
							dead[len - 1].endi[id] = ex;
							dead[len - 1].endj[id] = ey;
							dead[len - 1].direction[id] = direction4;
							dead[len - 1].num++;
						}
						else {
							int id = halfalive[len - 1].num;
							halfalive[len - 1].starti[id] = sx;
							halfalive[len - 1].startj[id] = sy;
							halfalive[len - 1].endi[id] = ex;
							halfalive[len - 1].endj[id] = ey;
							halfalive[len - 1].direction[id] = direction4;
							halfalive[len - 1].num++;
						}
					}
				}
				len = 0;
				last = map[i*size + j];
			}
			i--;
			j++;
		}
		if (len > 0)
		{
			if (start_dead == true)
			{
				int id = dead[len - 1].num;
				dead[len - 1].starti[id] = sx;
				dead[len - 1].startj[id] = sy;
				dead[len - 1].endi[id] = ex;
				dead[len - 1].endj[id] = ey;
				dead[len - 1].direction[id] = direction4;
				dead[len - 1].num++;
			}
			else{
				int id = halfalive[len - 1].num;
				halfalive[len - 1].starti[id] = sx;
				halfalive[len - 1].startj[id] = sy;
				halfalive[len - 1].endi[id] = ex;
				halfalive[len - 1].endj[id] = ey;
				halfalive[len - 1].direction[id] = direction4;
				halfalive[len - 1].num++;
			}
		}
		i = rec_i;
	}
}
public void extend_feature(int []map, int size, int color)
//��������չ,��������չ�����ף����̴�С��Ҫ��չ���ӣ���or�ף�
{
	int number;
	int i, k;
	//������飺
	for (k = 0; k < 4; k++){
		number = halfalive[k].num;
		for (i = 0; i < number; i++)
		{
			int tmpi;
			int tmpj;
			switch (halfalive[k].direction[i])
			{
			case 1:tmpi = halfalive[k].starti[i];
				tmpj = halfalive[k].startj[i];
				while (tmpj >= 0)//����ɨ��
				{
					
					if (map[tmpi*size + tmpj] != 0 && map[tmpi*size + tmpj] != color)//��ǰ���ǶԷ�������ʱ�˳�
						break;
					tmpj--;
				}
				halfalive[k].vir_si[i] = tmpi;
				halfalive[k].vir_sj[i] = tmpj + 1;
				tmpi = halfalive[k].endi[i];
				tmpj = halfalive[k].endj[i];
				while (tmpj < size)
				{
					
					if (map[tmpi*size + tmpj] != 0 && map[tmpi*size + tmpj] != color)
						break;
					tmpj++;
				}
				halfalive[k].vir_ei[i] = tmpi;
				halfalive[k].vir_ej[i] = tmpj - 1;
				break;
			case 2:tmpi = halfalive[k].starti[i];
				tmpj = halfalive[k].startj[i];
				while (tmpi >= 0)//����ɨ��
				{
					
					if (map[tmpi*size + tmpj] != 0 && map[tmpi*size + tmpj] != color)//��ǰ���ǶԷ�������ʱ�˳�
						break;
					tmpi--;
				}
				halfalive[k].vir_si[i] = tmpi + 1;
				halfalive[k].vir_sj[i] = tmpj;
				tmpi = halfalive[k].endi[i];
				tmpj = halfalive[k].endj[i];
				while (tmpi < size)
				{
					
					if (map[tmpi*size + tmpj] != 0 && map[tmpi*size + tmpj] != color)
						break;
					tmpi++;
				}
				halfalive[k].vir_ei[i] = tmpi - 1;
				halfalive[k].vir_ej[i] = tmpj;
				break;
			case 3:tmpi = halfalive[k].starti[i];
				tmpj = halfalive[k].startj[i];
				while (tmpi >= 0 && tmpj >= 0)//����ɨ��
				{
					
					if (map[tmpi*size + tmpj] != 0 && map[tmpi*size + tmpj] != color)
						break;
					tmpi--;
					tmpj--;
				}
				halfalive[k].vir_si[i] = tmpi + 1;
				halfalive[k].vir_sj[i] = tmpj + 1;
				tmpi = halfalive[k].endi[i];
				tmpj = halfalive[k].endj[i];
				while (tmpi < size&&tmpj < size)//����ɨ��
				{
					
					if (map[tmpi*size + tmpj] != 0 && map[tmpi*size + tmpj] != color)
						break;
					tmpi++;
					tmpj++;
				}
				halfalive[k].vir_ei[i] = tmpi - 1;
				halfalive[k].vir_ej[i] = tmpj - 1;
				break;
			case 4:tmpi = halfalive[k].starti[i];
				tmpj = halfalive[k].startj[i];
				while (tmpi < size && tmpj >= 0)//����ɨ��
				{
					
					if (map[tmpi*size + tmpj] != 0 && map[tmpi*size + tmpj] != color)
						break;
					tmpi++;
					tmpj--;
				}
				halfalive[k].vir_si[i] = tmpi - 1;
				halfalive[k].vir_sj[i] = tmpj + 1;
				tmpi = halfalive[k].endi[i];
				tmpj = halfalive[k].endj[i];
				while (tmpi >= 0 && tmpj < size)//����ɨ��
				{
					
					if (map[tmpi*size + tmpj] != 0 && map[tmpi*size + tmpj] != color)
						break;
					tmpi--;
					tmpj++;
				}
				halfalive[k].vir_ei[i] = tmpi + 1;
				halfalive[k].vir_ej[i] = tmpj - 1;
				break;
			default:
				break;
			}
		}
	}
	//�����飺
	for (k = 0; k < 4; k++){
		number = alive[k].num;
		for (i = 0; i < number; i++)
		{
			int tmpi;
			int tmpj;
			switch (alive[k].direction[i])
			{
			case 1:tmpi = alive[k].starti[i];
				tmpj = alive[k].startj[i];
				while (tmpj >= 0)//����ɨ��
				{
					
					if (map[tmpi*size + tmpj] != 0 && map[tmpi*size + tmpj] != color)//��ǰ���ǶԷ�������ʱ�˳�
						break;
					tmpj--;
				}
				alive[k].vir_si[i] = tmpi;
				alive[k].vir_sj[i] = tmpj + 1;
				tmpi = alive[k].endi[i];
				tmpj = alive[k].endj[i];
				while (tmpj < size)
				{
					
					if (map[tmpi*size + tmpj] != 0 && map[tmpi*size + tmpj] != color)
						break;
					tmpj++;
				}
				alive[k].vir_ei[i] = tmpi;
				alive[k].vir_ej[i] = tmpj - 1;
				break;
			case 2:tmpi = alive[k].starti[i];
				tmpj = alive[k].startj[i];
				while (tmpi >= 0)//����ɨ��
				{
					
					try {
						if (map[tmpi*size + tmpj] != 0 && map[tmpi*size + tmpj] != color)
							break;
						tmpi--;
					} catch (java.lang.ArrayIndexOutOfBoundsException e) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(null, tmpi+"  "+tmpj+"  "+map.length, tmpi+"  "+tmpj+"  "+map.length, JOptionPane.ERROR_MESSAGE); 
					}
				}
				alive[k].vir_si[i] = tmpi + 1;
				alive[k].vir_sj[i] = tmpj;
				tmpi = alive[k].endi[i];
				tmpj = alive[k].endj[i];
				while (tmpi < size)
				{
					
					try {
						if (map[tmpi*size + tmpj] != 0 && map[tmpi*size + tmpj] != color)
							break;
						tmpi++;
					} catch (java.lang.ArrayIndexOutOfBoundsException e) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(null, tmpi+"  "+tmpj+"  "+map.length, tmpi+"  "+tmpj+"  "+map.length, JOptionPane.ERROR_MESSAGE); 
					}
					
				}
				alive[k].vir_ei[i] = tmpi - 1;
				alive[k].vir_ej[i] = tmpj;
				break;
			case 3:tmpi = alive[k].starti[i];
				tmpj = alive[k].startj[i];
				while (tmpi >= 0 && tmpj >= 0)//����ɨ��
				{
					
					if (map[tmpi*size + tmpj] != 0 && map[tmpi*size + tmpj] != color)
						break;
					tmpi--;
					tmpj--;
				}
				alive[k].vir_si[i] = tmpi + 1;
				alive[k].vir_sj[i] = tmpj + 1;
				tmpi = alive[k].endi[i];
				tmpj = alive[k].endj[i];
				while (tmpi < size&&tmpj < size)//����ɨ��
				{
					
					if (map[tmpi*size + tmpj] != 0 && map[tmpi*size + tmpj] != color)
						break;
					tmpi++;
					tmpj++;
				}
				alive[k].vir_ei[i] = tmpi - 1;
				alive[k].vir_ej[i] = tmpj - 1;
				break;
			case 4:tmpi = alive[k].starti[i];
				tmpj = alive[k].startj[i];
				while (tmpi < size && tmpj >= 0)//����ɨ��
				{
					
					if (map[tmpi*size + tmpj] != 0 && map[tmpi*size + tmpj] != color)
						break;
					tmpi++;
					tmpj--;
				}
				alive[k].vir_si[i] = tmpi - 1;
				alive[k].vir_sj[i] = tmpj + 1;
				tmpi = alive[k].endi[i];
				tmpj = alive[k].endj[i];
				while (tmpi >= 0 && tmpj < size)//����ɨ��
				{
					
					if (map[tmpi*size + tmpj] != 0 && map[tmpi*size + tmpj] != color)
						break;
					tmpi--;
					tmpj++;
				}
				alive[k].vir_ei[i] = tmpi + 1;
				alive[k].vir_ej[i] = tmpj - 1;
				break;
			default:
				break;
			}
		}
	}
}
public void search_nodes(int []map, int size)
//�󽻲�㣬ȷ��˫�������ĸ���
{
	int i, j, k;
	int sum = 0;//���л���Ͱ���������
	sum += halfalive[1].num;
	sum += halfalive[2].num;
	sum += halfalive[3].num;
	sum += alive[1].num;
	sum += alive[2].num;
	sum += alive[3].num;
	Sumforsearch p[]=new Sumforsearch[sum];
	for(i=0;i<sum;i++)
	{
		p[i]=new Sumforsearch();
	}
	k = 0;
	//Ԥ����1�������ͻ���ŵ�sumforsearch���������ܳ����ӵ�
	for (i = 1; i < 4; i++)
	{
		for (j = 0; j < halfalive[i].num; j++)
		{
			if (Math.abs(halfalive[i].vir_si[j] - halfalive[i].vir_ei[j]) >= 4 || Math.abs(halfalive[i].vir_sj[j] - halfalive[i].vir_ej[j]) >= 4)
			{
				p[k].len = i + 1;//ʵ����
				p[k].vir_si = halfalive[i].vir_si[j];//������
				p[k].vir_sj = halfalive[i].vir_sj[j];
				p[k].vir_ei = halfalive[i].vir_ei[j];
				p[k].vir_ej = halfalive[i].vir_ej[j];
				p[k].direction = halfalive[i].direction[j];
				p[k].isalive = false;
				p[k].virlen = Math.abs(halfalive[i].vir_si[j] - halfalive[i].vir_ei[j]) + 1;//�鳤��
				if (p[k].virlen == 1)
				{
					p[k].virlen = Math.abs(halfalive[i].vir_sj[j] - halfalive[i].vir_ej[j]) + 1;
				}
				k++;
			}
		}
	}
	for (i = 1; i < 4; i++)
	{
		for (j = 0; j < alive[i].num; j++)
		{
			if (Math.abs(alive[i].vir_si[j] - alive[i].vir_ei[j]) >= 4 || Math.abs(alive[i].vir_sj[j] - alive[i].vir_ej[j]) >= 4)
			{
				p[k].len = i + 1;//ʵ����
				p[k].vir_si = alive[i].vir_si[j];//������
				p[k].vir_sj = alive[i].vir_sj[j];
				p[k].vir_ei = alive[i].vir_ei[j];
				p[k].vir_ej = alive[i].vir_ej[j];
				p[k].direction = alive[i].direction[j];
				p[k].isalive = true;
				p[k].virlen = Math.abs(alive[i].vir_si[j] - alive[i].vir_ei[j]) + 1;//�鳤��
				if (p[k].virlen == 1)
				{
					p[k].virlen = Math.abs(alive[i].vir_sj[j] - alive[i].vir_ej[j]) + 1;
				}
				k++;
			}
		}
	}
	sum = k;//��ʱsum��p��������Чֵ�ĸ���
	//Ԥ����2,����sumforsearch�������ʵ�ʳ���
	for (i = 0; i < sum; i++)
	{
		int tmpi;
		int tmpj;
		int counter;
		switch (p[i].direction)
		{
		case 1:tmpj = p[i].vir_sj;
			counter = 0;
			while (tmpj <= p[i].vir_ej)
			{
				if (map[p[i].vir_si*size + tmpj] != 0)
				{
					counter++;
				}
				tmpj++;
			}
			p[i].len = counter;
			break;
		case 2:tmpi = p[i].vir_si; counter = 0;
			while (tmpi <= p[i].vir_ei)
			{
				if (map[tmpi*size + p[i].vir_sj] != 0)
				{
					counter++;
				}
				tmpi++;
			}
			p[i].len = counter;
			break;
		case 3:tmpi = p[i].vir_si; tmpj = p[i].vir_sj; counter = 0;
			while (tmpi <= p[i].vir_ei&&tmpj <= p[i].vir_ej)
			{
				if (map[tmpi*size + tmpj] != 0)
				{
					counter++;
				}
				tmpi++;
				tmpj++;
			}
			p[i].len = counter;
			break;
		case 4:tmpi = p[i].vir_si; tmpj = p[i].vir_sj; counter = 0;
			while (tmpi >= p[i].vir_ei&&tmpj <= p[i].vir_ej)
			{
				if (map[tmpi*size + tmpj] != 0)
				{
					counter++;
				}
				tmpi--;
				tmpj++;
			}
			p[i].len = counter;
			break;
		default:
			break;
		}
	}
	//����ƥ�䣬�󽻵�
	for (i = 0; i < sum; i++)
	{
		for (j = i + 1; j < sum; j++)
		{
			int judge = is_crossing(p[i].vir_si, p[i].vir_sj, p[i].vir_ei, p[i].vir_ej, p[j].vir_si, p[j].vir_sj, p[j].vir_ei, p[j].vir_ej, map, p[i].direction, p[j].direction);
			if (judge == 0)
			{
				//�޽���
			}
			else if (judge == 1)
			{
				//������ʵ��
				switch (p[i].len)
				{
				case 2:
					if (p[j].len == 2)//pi =2 ;pj==2
					{
						if (p[i].isalive == true)
						{
							if (p[j].isalive == true)//zhenzhen
							{
								alive22++;
							}
							else{//zhenjia
								halfalive22++;
							}
						}
						else
						{
							if (p[j].isalive == true)//zhenjia
							{
								halfalive22++;
							}
							else{//jiajia
								halfdead22++;
							}
						}
					}
					else if (p[j].len == 3)//pi 2 pj 3
					{
						if (p[i].isalive == true)
						{
							if (p[j].isalive == true)//zhenzhen
							{
								alive23++;
							}
							else{//zhenjia
								halfalive23++;
							}
						}
						else
						{
							if (p[j].isalive == true)//zhenjia
							{
								halfalive23++;
							}
							else{//jiajia
								halfdead23++;
							}
						}
					}
					else {//p[j].len==4
						if (p[i].isalive == true)
						{
							if (p[j].isalive == true)//zhenzhen
							{
								alive24++;
							}
							else{//zhenjia
								halfalive24++;
							}
						}
						else
						{
							if (p[j].isalive == true)//zhenjia
							{
								halfalive24++;
							}
							else{//jiajia
								halfdead24++;
							}
						}
					}
					break;
				case 3:
					if (p[j].len == 2)//pi =2 ;pj==2
					{
						if (p[i].isalive == true)
						{
							if (p[j].isalive == true)//zhenzhen
							{
								alive23++;
							}
							else{//zhenjia
								halfalive23++;
							}
						}
						else
						{
							if (p[j].isalive == true)//zhenjia
							{
								halfalive23++;
							}
							else{//jiajia
								halfdead23++;
							}
						}
					}
					else if (p[j].len == 3)//pi 2 pj 3
					{
						if (p[i].isalive == true)
						{
							if (p[j].isalive == true)//zhenzhen
							{
								alive33++;
							}
							else{//zhenjia
								halfalive33++;
							}
						}
						else
						{
							if (p[j].isalive == true)//zhenjia
							{
								halfalive33++;
							}
							else{//jiajia
								halfdead33++;
							}
						}
					}
					else {//p[j].len==4
						if (p[i].isalive == true)
						{
							if (p[j].isalive == true)//zhenzhen
							{
								alive34++;
							}
							else{//zhenjia
								halfalive34++;
							}
						}
						else
						{
							if (p[j].isalive == true)//zhenjia
							{
								halfalive34++;
							}
							else{//jiajia
								halfdead34++;
							}
						}
					}
					break;
				case 4:
					if (p[j].len == 2)//pi =2 ;pj==2
					{
						if (p[i].isalive == true)
						{
							if (p[j].isalive == true)//zhenzhen
							{
								alive24++;
							}
							else{//zhenjia
								halfalive24++;
							}
						}
						else
						{
							if (p[j].isalive == true)//zhenjia
							{
								halfalive24++;
							}
							else{//jiajia
								halfdead24++;
							}
						}
					}
					else if (p[j].len == 3)//pi 2 pj 3
					{
						if (p[i].isalive == true)
						{
							if (p[j].isalive == true)//zhenzhen
							{
								alive34++;
							}
							else{//zhenjia
								halfalive34++;
							}
						}
						else
						{
							if (p[j].isalive == true)//zhenjia
							{
								halfalive34++;
							}
							else{//jiajia
								halfdead34++;
							}
						}
					}
					else {//p[j].len==4
						if (p[i].isalive == true)
						{
							if (p[j].isalive == true)//zhenzhen
							{
								alive44++;
							}
							else{//zhenjia
								halfalive44++;
							}
						}
						else
						{
							//1322
							;
							if (p[j].isalive == true)//zhenjia
							{
								halfalive44++;
							}
							else{//jiajia
								halfdead44++;
							}
						}
					}
					break;
				default:
					break;
				}
			}
			else//judge==2
			{
				//���������
				switch (p[i].len)
				{
				case 2:
					if (p[j].len == 2)//pi =2 ;pj==2
					{
						if (p[i].isalive == true)
						{
							if (p[j].isalive == true)//zhenzhen
							{
								vir_alive22++;
							}
							else{//zhenjia
								vir_halfalive22++;
							}
						}
						else
						{
							if (p[j].isalive == true)//zhenjia
							{
								vir_halfalive22++;
							}
							else{//jiajia
								vir_halfdead22++;
							}
						}
					}
					else if (p[j].len == 3)//pi 2 pj 3
					{
						if (p[i].isalive == true)
						{
							if (p[j].isalive == true)//zhenzhen
							{
								vir_alive23++;
							}
							else{//zhenjia
								vir_halfalive23++;
							}
						}
						else
						{
							if (p[j].isalive == true)//zhenjia
							{
								vir_halfalive23++;
							}
							else{//jiajia
								vir_halfdead23++;
							}
						}
					}
					else {//p[j].len==4
						if (p[i].isalive == true)
						{
							if (p[j].isalive == true)//zhenzhen
							{
								vir_alive24++;
							}
							else{//zhenjia
								vir_halfalive24++;
							}
						}
						else
						{
							if (p[j].isalive == true)//zhenjia
							{
								vir_halfalive24++;
							}
							else{//jiajia
								vir_halfdead24++;
							}
						}
					}
					break;
				case 3:
					if (p[j].len == 2)//pi =2 ;pj==2
					{
						if (p[i].isalive == true)
						{
							if (p[j].isalive == true)//zhenzhen
							{
								vir_alive23++;
							}
							else{//zhenjia
								vir_halfalive23++;
							}
						}
						else
						{
							if (p[j].isalive == true)//zhenjia
							{
								vir_halfalive23++;
							}
							else{//jiajia
								vir_halfdead23++;
							}
						}
					}
					else if (p[j].len == 3)//pi 2 pj 3
					{
						if (p[i].isalive == true)
						{
							if (p[j].isalive == true)//zhenzhen
							{
								vir_alive33++;
							}
							else{//zhenjia
								vir_halfalive33++;
							}
						}
						else
						{
							if (p[j].isalive == true)//zhenjia
							{
								vir_halfalive33++;
							}
							else{//jiajia
								vir_halfdead33++;
							}
						}
					}
					else {//p[j].len==4
						if (p[i].isalive == true)
						{
							if (p[j].isalive == true)//zhenzhen
							{
								vir_alive34++;
							}
							else{//zhenjia
								vir_halfalive34++;
							}
						}
						else
						{
							if (p[j].isalive == true)//zhenjia
							{
								vir_halfalive34++;
							}
							else{//jiajia
								vir_halfdead34++;
							}
						}
					}
					break;
				case 4:
					if (p[j].len == 2)//pi =2 ;pj==2
					{
						if (p[i].isalive == true)
						{
							if (p[j].isalive == true)//zhenzhen
							{
								vir_alive24++;
							}
							else{//zhenjia
								vir_halfalive24++;
							}
						}
						else
						{
							if (p[j].isalive == true)//zhenjia
							{
								vir_halfalive24++;
							}
							else{//jiajia
								vir_halfdead24++;
							}
						}
					}
					else if (p[j].len == 3)//pi 2 pj 3
					{
						if (p[i].isalive == true)
						{
							if (p[j].isalive == true)//zhenzhen
							{
								vir_alive34++;
							}
							else{//zhenjia
								vir_halfalive34++;
							}
						}
						else
						{
							if (p[j].isalive == true)//zhenjia
							{
								vir_halfalive34++;
							}
							else{//jiajia
								vir_halfdead34++;
							}
						}
					}
					else {//p[j].len==4
						if (p[i].isalive == true)
						{
							if (p[j].isalive == true)//zhenzhen
							{
								vir_alive44++;
							}
							else{//zhenjia
								vir_halfalive44++;
							}
						}
						else
						{
							if (p[j].isalive == true)//zhenjia
							{
								vir_halfalive44++;
							}
							else{//jiajia
								vir_halfdead44++;
							}
						}
					}
					break;
				default:
					break;
				}
			}
		}
	}
	
}
public int is_crossing(int si, int sj, int ei, int ej, int sx, int sy, int ex, int ey, int []map, int d1, int d2)
//0û�н��㣬1������ʵ�㣬2���������
{
	int len1 = max(Math.abs(si - ei) + 1, Math.abs(sj - ej) + 1);
	int len2 = max(Math.abs(sx - ex) + 1, Math.abs(sy - ey) + 1);
	int i, j;
	for (i = 0; i < len1; i++)
	{
		int recsx = sx, recsy = sy;
		for (j = 0; j < len2; j++)
		{
			if (si == sx&&sj == sy)
			{
				if (map[si*size + sj] == 0)
				{
					//cout << "222" << endl;
					return 2;
				}
				else
				{
					//cout << "111" << endl;
					return 1;
				}
			}
			switch (d2)
			{
			case 1:sy++; break;
			case 2:sx++; break;
			case 3:sx++; sy++; break;
			case 4:sx--; sy++; break;
			default:
				break;
			}
		}
		sx = recsx;
		sy = recsy;
		switch (d1)
		{
		case 1:sj++; break;
		case 2:si++; break;
		case 3:si++; sj++; break;
		case 4:si--; sj++; break;
		default:
			break;
		}
	}
	return 0;
}
public int max(int a, int b)

{
	if (a > b)
		return a;
	else return b;
}
public void clear()

{
	dead[0].num = 0;
	dead[1].num = 0;
	dead[2].num = 0;
	dead[3].num = 0;
	halfalive[0].num = 0;
	halfalive[1].num = 0;
	halfalive[2].num = 0;
	halfalive[3].num = 0;
	alive[0].num = 0;
	alive[1].num = 0;
	alive[2].num = 0;
	alive[3].num = 0;
	vir_halfdead22 = 0; vir_halfdead23 = 0; vir_halfdead24 = 0; vir_halfdead33 = 0; vir_halfdead34 = 0; vir_halfdead44 = 0;
	vir_halfalive22 = 0; vir_halfalive23 = 0; vir_halfalive24 = 0; vir_halfalive33 = 0; vir_halfalive34 = 0; vir_halfalive44 = 0;
	vir_alive22 = 0; vir_alive23 = 0; vir_alive24 = 0; vir_alive33 = 0; vir_alive34 = 0; vir_alive44 = 0;
	halfdead22 = 0; halfdead23 = 0; halfdead24 = 0; halfdead33 = 0; halfdead34 = 0; halfdead44 = 0;
	halfalive22 = 0; halfalive23 = 0; halfalive24 = 0; halfalive33 = 0; halfalive34 = 0; halfalive44 = 0;
	alive22 = 0; alive23 = 0; alive24 = 0; alive33 = 0; alive34 = 0; alive44 = 0;
}
public void input(float shuru[], int pyl)
//���������ƫ����
{
	int i;
	for (i = 0; i < 4; i++)
	{
		shuru[i + pyl] = (float)dead[i].num;
	}
	for (i = 0; i < 4; i++)
	{
		shuru[i + 4 + pyl] = (float)halfalive[i].num;
	}
	for (i = 0; i < 4; i++)
	{
		shuru[i + 8 + pyl] = (float)alive[i].num;
	}
	shuru[12 + pyl] = (float)vir_halfdead22; shuru[13 + pyl] = (float)vir_halfdead23; shuru[14 + pyl] = (float)vir_halfdead24; shuru[size + pyl] = (float)vir_halfdead33; shuru[16 + pyl] = (float)vir_halfdead34; shuru[17 + pyl] = (float)vir_halfdead44;
	shuru[18 + pyl] = (float)vir_halfalive22; shuru[19 + pyl] = (float)vir_halfalive23; shuru[20 + pyl] = (float)vir_halfalive24; shuru[21 + pyl] = (float)vir_halfalive33; shuru[22 + pyl] = (float)vir_halfalive34; shuru[23 + pyl] = (float)vir_halfalive44;
	shuru[24 + pyl] = (float)vir_alive22; shuru[25 + pyl] = (float)vir_alive23; shuru[26 + pyl] = (float)vir_alive24; shuru[27 + pyl] = (float)vir_alive33; shuru[28 + pyl] = (float)vir_alive34; shuru[29 + pyl] = (float)vir_alive44;
	shuru[30 + pyl] = (float)halfdead22; shuru[31 + pyl] = (float)halfdead23; shuru[32 + pyl] = (float)halfdead24; shuru[33 + pyl] = (float)halfdead33; shuru[34 + pyl] = (float)halfdead34; shuru[35 + pyl] = (float)halfdead44;
	shuru[36 + pyl] = (float)halfalive22; shuru[37 + pyl] = (float)halfalive23; shuru[38 + pyl] = (float)halfalive24; shuru[39 + pyl] = (float)halfalive33; shuru[40 + pyl] = (float)halfalive34; shuru[41 + pyl] = (float)halfalive44;
	shuru[42 + pyl] = (float)alive22; shuru[43 + pyl] = (float)alive23; shuru[44 + pyl] = (float)alive24; shuru[45 + pyl] = (float)alive33; shuru[46 + pyl] = (float)alive34; shuru[47 + pyl] = (float)alive44;
}
};
