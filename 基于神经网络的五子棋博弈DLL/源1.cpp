/*class GobangGame
{
friend class player;
private:
int *map;//������ -1��ʾ��������1��ʾ��������0��ʾ
int turns;//��¼�ֵ�˭����ı�־��1��-1��
AIforGobangGame myAI;
player person;
public:
static const int heiturn = 1;//�ֵ���
static const int baiturn = -1;//�ֵ���
static const int heiwin = 1;//��Ӯ
static const int baiwin = -1;
static const int drawgame = 0;//ƽ��
static const int notfinish = 9;//��δ����
static const int heizi = 1;
static const int baizi = -1;
static const int nilzi = 0;
static const int heistatus = 1;
static const int baistatus = -1;
GobangGame(int status, neuralnetworkofGobangBaseFeature net){
map = (int*)malloc(size*size*sizeof(int));
turns = 1;
myAI = AIforGobangGame(status, status, net);
person = player(status*(-1), 1);// ��
}
void init()
{
initmap();
turns = 1;
myAI.init();
}
void initmap()//��ʼ������
{
int i, j;
for (i = 0; i < size; i++)
{
for (j = 0; j < size; j++)
{
map[i*size + j] = 0;
}
}
}
~GobangGame(){
free(map);
}
void nextturn()//�����´��ֵ�˭
{
turns = turns*(-1);
}
int judge()//�ж����
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
bool movement(int who, int i, int j)//һ���ж�
{
if (map[i*size + j] == nilzi){
if (who == heiturn)
{
map[i*size + j] = heizi;
}
else if (who == baiturn){
map[i*size + j] = baizi;
}
else{
//wrong
}
nextturn();
return true;
}
else{
return false;//�˴���������
}
}
int * getmap()
{
return map;
}
void updateUI()
{
system("cls");
int r = 0, i;
for (i = 0; i < size*size; i++)
{
if (map[i] == 0)
cout << "." << " ";
else if (map[i] == 1)
cout << "*" << " ";
else cout << "o" << " ";
r++;
if (r == size){
r = 0;
cout << endl;
}
}
}
void controller()//�������̿���,һ��
{
int tmp_judge = notfinish;
while (tmp_judge == notfinish)
{
if (turns == myAI.AIturn)//�ֵ�������
{
//cout << turns << endl;
int i = 0, j = 0;
myAI.makecmd(map, i, j);
map[i*size + j] = myAI.AIturn;

//update UI:
updateUI();

}
else//�ֵ������
{
//cout << turns << endl;
int i = 0, j = 0;
person.waitpersonmakecmd(map, i, j);
map[i*size + j] = turns;
updateUI();
}
tmp_judge = judge();
nextturn();
int s;
for (s = 0; s < size*size; s++)//ɨ�������Ƿ�����
{
if (map[s] == 0)
break;
}
if (s == size*size&&tmp_judge == notfinish)//��������������δ������drawgame
{
tmp_judge = drawgame;
break;
}
}
if (tmp_judge == heiwin){
//����Ӯ
cout << "heiwin" << endl;
}
else if (tmp_judge == baiwin){
//����Ӯ
cout << "baiwin" << endl;
}
else if (tmp_judge == drawgame)
{
cout << "drawgame" << endl;//ƽ�ֲ�ѧϰ
}
if (tmp_judge == myAI.AIturn)
{
cout << "you lose" << endl;
myAI.judge_iswin(tmp_judge);
myAI.TD_study();
}
else{
cout << "you win" << endl;
myAI.judge_iswin(tmp_judge);
myAI.TD_study();
}


}
void save()
{
myAI.saveWeight(quanzhi_src);
}
};
void BP_learn(){
srand(time(NULL));
int inputarray[size*size] = { 0 };
bool isexist;
fstream read;
read.open(input_src, ios::_Nocreate | ios::in);
for (int i = 0; i < size*size; i++)
{
read >> inputarray[i];
}
fstream file;
file.open(quanzhi_src, ios::_Nocreate | ios::in);
isexist = file.is_open();
neuralnetworkofGobangBaseFeature mynet;
if (isexist == true)
{
cout << "quanzhi.txt����" << endl;
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
fstream input;
input.open(input_src, ios::_Nocreate | ios::in);
int i = 0, r = 0;
for (i = 0; i < size*size; i++)
{
cout << inputarray[i] << " ";
r++;
if (r == size){
r = 0;
cout << endl;
}
}
float reward = 0;
mynet.getshuru(inputarray);
do
{
mynet.cal_shuchu();
cout << fixed << setprecision(2) << mynet.getshuchu() << endl;
cin >> reward;
if (fabs(reward) < 0.01) {
if (!input.eof()){
for (int i = 0; i < size*size; i++)//�������
{
read >> inputarray[i];
}
//��ʾ��
for (int i = 0; i < size*size; i++)
{
cout << inputarray[i] << " ";
r++;
if (r == size){
r = 0;
cout << endl;
}
}
//��������������룺
mynet.getshuru(inputarray);
continue;
}
else{
break;
}
}
if (fabs(reward - 99999)<0.01) break;
mynet.feedback(reward);
} while (1);
read.close();
file.open(quanzhi_src, fstream::out | ios_base::trunc);
int j;
for (i = 0; i < 96; i++)
{
for (j = 0; j < 48; j++)
{
file << fixed << setprecision(2) << mynet.quanzhi1[i][j];
file << endl;
}
}
for (i = 0; i < 48; i++)
{

file << fixed << setprecision(2) << mynet.quanzhi2[i];
file << endl;
}
input.close();
file.close();
}*/
/*void pvc()//�˻�����
{
cout << "��ӭʹ�ñ����򣬱�������������������룬Ĭ����ִ�����У�ף�������죡����ڴ������汾�����ע����git:https://github.com/jimth001/my-Gobang-game-base-AI-algorithm " << endl;
cout << "���ߣ�������" << endl;
bool isexist = false;
fstream file;
file.open(quanzhi_src, ios::_Nocreate | ios::in);
isexist = file.is_open();
neuralnetworkofGobangBaseFeature mynet;
if (isexist == true)
{
cout << "quanzhi.txt����" << endl;
system("pause");
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
player com = player(1, 0);//����ִ��
int AIstatus = -1;
int restart = 1;
while (restart == 1)
{
GobangGame *ga = new GobangGame(AIstatus, mynet);//size*size ����ִ��
ga->init();
ga->controller();
cout << "����������1" << endl;
cin >> restart;
ga->save();
delete ga;
}

}*/


/*void printArray(int *inputarray)
{
int i = 0, r = 0;
for (i = 0; i < size*size; i++)
{
cout << inputarray[i] << " ";
r++;
if (r == size){
r = 0;
cout << endl;
}
}
}*/