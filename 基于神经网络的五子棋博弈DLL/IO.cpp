#include "DllGobangAI.h"
void writeMapIntoTXT(int *inputarray, const char *src)//��inputarray����д��·��Ϊsrc��txt��
{
	std::fstream write;
	write.open(src, std::fstream::out | std::ios::app);
	int k;
	for (k = 0; k < size*size; k++){
		write << inputarray[k];
		write << std::endl;
	}
	write.close();
}