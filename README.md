写在开头：
这是我本科时写的一个项目，当时alphaGo刚刚横空出世，怀着对AI的兴趣写了这个五子棋博弈的程序。现在看来有太多粗陋之处，效果也很不好，毕竟理论上讲无禁手的五子棋是先手必胜的。在17年的时候，读了alphazero的论文，又有了想重写这个项目的想法。原本是17年底打算在18年1月份开始做这件事的，但是无奈迫于学业比赛论文等等很多事情，一直没有能真正去做。
把这个项目放到github上以后，我也收到过一些朋友的邮件，有一些问题或建议。在这里我想对每个对棋类博弈AI感兴趣的朋友说，希望我这个项目能为你起到抛砖引玉的作用，不要局限于这个项目，十分建议大家去读一读alphago，alphazero以及一些关于poker的文章：poker-cnn，deep stack，libratus。
最近还是很忙，没有时间去更新这个项目，以后有空会更新的。

2018.6.5


原文：

#研 究 报 告 
##author: Yunli Wang 
## 作品名称  基于神经网络的五子棋博弈系统 
##类    别  科技发明制作B 类 
##2016 年 3 月 

##1.  摘要  
计算机博弈一直是人们很关注的研究方向。从以前的“深蓝”到如今的AlphaGo，计算机博弈取得了很多成就，有了很大进展。AlphaGo与李世乭的围棋之战引得了很多人对深度学习，对人工智能的关注。我对计算机博弈也很感兴趣，尤其是五子棋。现在网络上很多的五子棋游戏都是基于规则的，最大的漏洞就在于你如果赢了它一盘，按照同样的套路下即可赢它。基于上面几点，我想到了可以设计一个有学习性的五子棋博弈算法，改善这种情况，提高五子棋人机博弈的趣味性和多变性；同时我也希望该算法经过一定规模的训练能够达到较高的博弈水平。因此，我利用人工智能的相关知识和计算机博弈的知识设计了基于神经网络的五子棋博弈算法，并开发了可演示算法的演示系统以及算法的接口dll。

本作品的核心和难点在于神经网络的结构（包括网络拓扑结构，输入结构，输出结构）及学习算法。在经过查阅资料和大量实践之后，我确定了三层感知器的拓扑结构和96个实型特征向量的输入结构以及网络以单实型值输出。

算法以博弈树搜索及剪枝为整体架构，结合对棋局的特征提取及神经网络预测局势来完成AI的决策。试验表明，它对于同一套路的棋局学习速度较快，可以在几盘对弈后有明显的表现提升。

在后面的实验中，AI初始表现不佳，对于如何进攻防守的学习较慢，为了增强它的初始“智能”，我对必胜局加入了规则判定以提升AI的初始表现。并利用低层搜索优化了高层搜索的剪枝效率。

现在，我已经设计了用于演示的JAVA程序，并提供了可用于训练的dll接口。演示程序可以通过人机对弈演示它的学习特性，若使用一个未经训练过的网络权值，在重复套路对弈的情况下，它的学习效果通常通过数盘即可显示出来。在经过大规模的训练后，该算法将有更加广泛的应用前景。

> 关键词：五子棋博弈；人工神经网络；强化学习；博弈树搜索；α-β剪枝

## 目录
1.  摘 要...2 

2.  研究背景及意义...4 
3.  核心算法...4 

   3.1.  神经网络结构及学习算法...4 

   3.2.  博弈树搜索及α-β剪枝算法及其优化...5 
   
   3.3.  特征提取...6 
   
   3.4.  必胜局判断...7 
   
4.  演示系统...7 

   4.1.  演示系统功能介绍...7 

   4.2.  演示系统使用说明...7 
   
5.  训练接口...8 

   5.1.  Dll接口介绍...8 

   5.2.  Dll使用说明...9 
   
6.  作品总结...10 

   6.1.  作品创新点及技术关键...10 

   6.2.  作品的先进性，科学性...10 
   
   6.3.  目前存在的问题...10 
   
   6.4.  发展前景...11 
   
7.  参考文献...11 
8.  附件清单...11 

## 2.  研究背景及意义
如今的大多数五子棋博弈程序都是完全基于规则的，即使搜索层数足够多，有不错的对战表现，但无法避免“定式定局”的情况（即采用相同走法对战得到相同结局）。我们希望避免这种情况并且能提高算法对弈水平。恰逢最近深度学习在计算机博弈上取得了很大成就，2015年10月AlphaGo在没有任何让子的情况下，以5:0完胜欧洲围棋冠军、职业二段选手樊麾。在围棋人工智能领域，实现了一次史无前例的突破。2016年3月15日，“人机大战”最后一场对弈中，“AlphaGo”在一度不利的情况下于收官阶段中盘战胜李世石，总比分被定格为1:4，五番棋最终以“AlphaGo”胜出而告终。基于人工智能在计算机博弈中的优秀表现，我想也可以利用神经网络来改进传统的完全基于规则的五子棋博弈算法。基于神经网络的五子棋博弈不仅能表现出学习特性，克服“定式定局”的缺点，还能再经过足够的训练之后表现出传统算法更优秀的博弈表现，无论在科学研究还是商业应用中都有一定意义。
## 3.  核心算法
### 3.1.  神经网络结构及学习算法
神经网络采用3层感知器结构，输入节点96个，中间层48个节点，输出层1个节点。采用线性激活函数，权值在-1-1之间。输入为提取到的特征向量。

学习算法采用TD强化学习算法：

我们唯一能准确确定最后的可估值局面就是胜负已分的时候。如果最后自己输了，则估值为-1，赢了估值为1。和棋的时候不进行学习。

我们也不能只对最后一个局面进行学习，我们希望能够对每个局面都进行学习，我们希望根据这个最后的局面给出前面若干个局面的合理估值。

于是我们做这样的假设：在开始的时候，双方优势相当，评估值应为0，然后随着对弈，优势逐渐改变，直到决出胜负。我们假设局势是渐变的，这样我们就可以从最后的局面开始，逐步向前进行学习。

对每个局面的学习，根据误差逆传播原理，进行一次权值的调整，接下来我们要确定每个局面的误差。我们假设误差为e，期待输出为a，网络输出为f(),第n个局面为结局且记为An，这样，对于An的误差e[n]=a-f(An),进行一次学习，调整了权值之后，若再对An进行计算，得到f’ (An),这个值会比f(An)更接近a。对于前一个局面An-1的学习，我们不能准确知道它的期待输出为多少，但我们根据假设知道，它应该是一个接近于a的值，我们不妨选用f ‘(An)作为An-1的期待输出。这样依次类推，就能完成整个学习过程，学习完一盘棋局，我们的网络对这局的每个局面的估值比原先的估值更为接近预期。
###3.2.  博弈树搜索及α-β剪枝算法及其优化
(1)   博弈树搜索：

对于任何一种博弈竞赛，都可以构成一个博弈树。它类似于状态图和问题求解搜索中使用的搜索树。博弈树的结点对应于某一个棋局，其分支表示走一步棋；根部对应于开始位置，其叶表示对弈到此结束。在叶节点对应的棋局中，竞赛的结果可以是赢、输或者和。

在二人博弈问题中，为了从众多可供选择的行动方案中选出一个对自己最为有利的行动方案，就需要对当前的情况以及将要发生的情况进行分析，通过某搜索算法从中选出最优的走步。

博弈树搜索的基本思想是：

a. 设博弈的双方中一方为MAX，另一方为MIN。然后为其中的一方寻找一个最优行动方案。

b. 为了找到当前的最优行动方案，需要对各个可能的方案所产生的后果进行比较,具体地说，就是要考虑每一方案实施后对方可能采取的所有行动，并计算可能的得分。

c. 为计算得分，需要根据问题的特性信息定义一个估价函数（我们使用3.1中的神经网络做估价函数），用来估算当前博弈树端节点的得分。此时估算出来的得分称为静态估值。

d. 当端节点的估值计算出来后，再推算出父节点的得分，推算的方法是：对“或”节点，选其子节点中一个最大的得分作为父节点的得分，这是为了使自己在可供选择的方案中选一个对自己最有利的方案；对“与”节点，选其子节点中一个最小的得分作为父节点的得分，这是为了立足于最坏的情况。这样计算出的父节点的得分称为倒推值。

e. 如果一个行动方案能获得较大的倒推值，则它就是当前最好的行动方案。

(2)   α-β剪枝：

为了提高博弈树搜索的效率，引入了通过对评估值的上下限进行估计，从而减少需进行评估节点的范围的方法。

MAX节点的评估下限值α：

作为MAX节点，假定它的MIN节点有N个，那么当它的第一个MIN节点的评估值为α时，则对于其它节点，如果有高于α的节点，就取那最高的节点值作为MAX节点的值；否则，该点的评估值为α。

MIN节点的评估上限值β：

作为MIN节点，同样假定它的MAX节点有N个，那么当它的第一个MAX节点的评估值为β时，则对于其他节点，如果有低于β的节点，就取最低的节点值作为MIN节点的值；否则，该店的评估值为β。

依据这种评估值上下限即可省去许多不必搜索的节点。

(3)  传统α-β剪枝的优化：

传统的α-β剪枝只是提供了剪枝的基本策略，保证了一定能得到正确解，但并没有保证它的效率。最坏的情况可能是从最坏的解按顺序搜到了最好的解，相当于没剪枝，还付出了额外的判断代价。所以搜索方向很重要。如果我们能从一个好的解开始搜，那么就会剪掉很多无用的分支，大大提升剪枝效果。

因此我们需要一定的启发式信息辅助搜索。比如我们决定搜索4层，那么2层的搜索结果就是一个很好的启发式信息。我们可以这样做：先搜2层，得到结果 (i,j) ,然后从 (i,j) 处开始进行4层搜索。不仅是对根节点我们可以这样做，对于博弈树中每个叶节点我们都可以这样做，用低层搜索为高层搜索做预测。这里要注意，对于MIN节点预测时要站在对方角度，选择对方最有利的落子处作为启发式信息，因为我们假设对手是十分聪明的。

###3.3.  特征提取
我们选用特征向量作为神经网络的输入。对于五子棋，一个棋局局面的特征是什么？这可以有很多种定义，我们选择的特征描述就是敌我双方的棋型和棋型长度。敌我双方各有48个特征，一种特定长度的棋型即一种特征（即活三为一种特征，眠二为一种特征，冲四活三也为一种特征），特征向量即这些特征的统计值构成的向量。定义了这些特征，我们就可以通过遍历棋局获得特征向量。为了精确提取，我们需要一些预处理工序，其间可能搜索棋盘多次，但不会每次遍历整个棋盘。

定义了特征之后，我们从棋盘提取特征向量的做法并不唯一，不同的人可能有不同的实现，只要保证提取的准确性即可，因此本文不详细介绍特征提取所用的方法。
###3.4.  必胜局判断
必胜局即虽然未成五子，但是已能判断胜负的局面。必胜局是完全可以基于规则设计的。因为我们能清楚地知道什么样的棋局是必胜局，所以我们不依靠神经网络来识别必胜局，而是使用固定规则处理必胜局。

必胜局的判定可以基于特征向量。例如出现双三（本算法基于无禁手规则设计）等棋型时就出现了必胜局。 
## 4.  演示系统
###4.1.  演示系统功能介绍
演示系统可以实现人机对弈。默认玩家执黑先行，电脑执白后行。对弈中一局结束自动学习。由使用者手动保存学习结果。可以保存和加载棋谱进行复盘。未来还会提供学习接口来学习棋谱。
###4.2.  演示系统使用说明
界面及按键说明如下：

a.      在棋盘中双击落子。

b.      重新开始:单机即清除当前棋盘重新开始。

c.       悔棋：因不支持玩家选择先后手，玩家固定先手，优势很大，所以暂不提供悔棋功能。

d.      保存棋谱：将当前下完的一局的棋谱保存到指定位置。文件名自命名，保存类型为txt文件。

e.      载入棋谱：载入指定位置的棋谱，可供复盘查看。

f.       学习：保存学习结果（学习过程是在分出胜负的时候自动完成的）。

g.      刷新界面：刷新界面显示。有时程序会出现白屏，点击刷新界面重新加载界面，显示棋局。

h.      quanzhi.txt文件内置于程序包中，若有需要请在文件夹中查找替换（不要更改其位置，若在相应位置查找不到，程序会自动建立初始的未经训练的quanzhi.txt文件）。

## 5.  训练接口
###5.1.  Dll接口介绍
AiforGobangGame类提供如下函数接口：

a.      AIforGobangGame(int status, int turn, const char * src, int search_para);

构造函数，status是电脑身份，1为黑棋，-1为白棋，与先后手无关。

turn是轮换标记，以前是为配合控制流程保留，当前版本中暂无作用。为了和后续版本兼容，此参数值的选取请和status值保持一致。

src是权值文件路径（要包括文件名）

search_para是搜索层数，推荐选择3或4层**注意奇数层和偶数层的权值文件不能互通使用**。

b.      void makecmd(int *map, int&i, int &j);

决策函数，map是大小为225的一维数组，表示当前棋盘，采用行坐标x，列坐标y进行定位，map[x*size+y]表示x行y列的点（左上角为0，0），1为黑子，-1为白子，0为无子。I，j参数是引用的，调用完之后，i，j的值即为电脑决定落子处的行列坐标。此函数不会改变map的值，所以得到落子坐标后请在其他函数中进行落子操作。

c.       void saveWeight(const char* src);

保存权值函数，src是保存路径（要包括文件名）

d.      void judge_iswin(intwinner);

胜负状态设置函数，辅助TD_study()所用。调用TD_study()之前必须先调用此函数。和棋请不要调用

winner表示该局的胜利者，黑棋胜为1，白棋胜为-1

e.      void TD_study();

学习函数，调用此函数对刚下完的一局进行学习。和棋请不要调用。

f.       int judge(int *map);

判断棋局辅助函数，可用于判断当前棋局的状态，map是当前棋盘。
返回值说明如下：
```c++
static const int heiwin = 1;//黑赢

static const int baiwin = -1;//白赢

static const int drawgame = 0;//平局

static const int notfinish = 9;//尚未结束
```
四个返回值在AiforGobangGame中均定义了常量。
若有必要使用此函数，请尽量使用AiforGobangGame.heiwin形式，不要直接使用相应数字，以保持和后续版本的兼容性。

###5.2.  Dll使用说明
使用时请将GobangAI.dll,GobangAI.lib,DllGobangAI.h放在所需工程相应目录下。若是用作训练，还需要其他五子棋博弈源码，自己实现或重写一个简单的main函数。

Dll中封装了类player，AIforGobangGame等，虽然都进行了导出。但是用作训练或和其他程序对弈只需使用AIforGobangGame，所以请只直接使用此类，以保证您的程序对后续dll版本的兼容。因dll是以导出类的形式提供接口，且该dll较小，使用时推荐使用静态调用方法，若使用动态调用方法会麻烦很多。

使用AIforGobangGame时按照5.1接口介绍中的参数标准调用即可。
## 6.  作品总结
###6.1.  作品创新点及技术关键
a.       打破传统的基于规则的确定性估值函数，克服了编程者对棋局的主观认知失误造成的不可逆的评估偏差。

b.       使用TD强化学习训练神经网络，对每个局面的学习采用BP反向传播的方式对权值进行单次调整。

c.        利用低层的搜索结果为高层搜索提供启发式信息，大大减少了搜索所用时间，提高剪枝效率。

d.       对于确定性因素采用规则判断而不是神经网络（必胜局判定）。
###6.2.  作品的先进性，科学性
a.       通过特征提取和神经网络将确定性信息和非确定性信息完美耦合在一起。

b.       通过规则和神经网络的结合避免了在确定性棋局下的失误，且完好地保留了神经网络的学习特性。

c.        为了增强剪枝效果，使用低级层数的搜索为高级层数的搜索做预测。
###6.3.  目前存在的问题
a.       没有很好地预防过学习。没有噪声识别和处理，因此学习过程中必须和棋力较好的程序对弈。

b.       没有对自己棋力的评估机制，对于任何阶段都采用相同的学习率进行学习。

c.        演示程序及Dll暂时并未实现剪枝中非叶节点的启发式搜索。只是实现了根节点的启发式搜索。

d.       该版本代码不支持禁手规则。若要在有禁手的场合中使用Dll，需要在主程序中进行处理。

e.       没有提供经过大量训练过的权值文件，对战测试不够充分。
###6.4.  发展前景
学习效果明显，改进过学习的问题并进行执行效率优化后表现将更好。经过大规模训练之后应可达到专业水准。可以加入专业级规则，加大训练规模，推广到专业级五子棋博弈的比赛或者游戏中。
## 7.  参考文献
a.       基于TD强化学习智能博弈程序的设计与实现  莫建文，林士敏，张顺岚  《计算机应用》, 2004, 24(z1):287-288

b.       博弈树搜索与α-β为成熟算法，且较为简单。本文中相关叙述部分采用了http://cnblogs.com/coder2012/p/3165301.html中的描述
## 8.  附件清单
Dll源码一份。
Dll调用所需文件一份：DllGobangAI.h,GobangAI.dll,GobangAI.lib。
演示系统源码一份。
演示系统一份：image文件夹包含资源文件，jre1.8.0_45文件夹下为程序运行所需jre，权值文件(quanzhi.txt)，java jar包(基于神经网络的五子棋博弈演示系统)，start.bat(点此打开程序)。







