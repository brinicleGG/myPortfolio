#include <iostream>
#include <fstream>
#include <stdlib.h>
#include <ctime>
using namespace std;

void input(int *massiv, int N, int M){
int i,j,x;
for (i=0; i<N; i++){
	for (j=0; j<M; j++){
*(massiv+i*M+j) = 1 + rand() % 2;
/*cout << "Элемент №" << ++x << " = " << *(massiv+i*M+j) << "\n"; */}
}
}

void output (int *massiv1, int N1, int M1){
	int i1,j1;
	for (i1=0; i1<N1; i1++){
		for (j1=0; j1<M1; j1++){
cout << *(massiv1+i1*M1+j1) << "\t";
} cout << "\n";
}
}

int main(){
	setlocale(LC_ALL, "Russian");
	int z,v,h,l,w,n,t,c;
	srand( time(NULL));
	cout << "Введите размер квадратной матрицы - ";
	cin >> c;
	z=v=h=l=w=n=t=c;
	cout << "Матрица А \n";
	int A[z][v];
	input(&A[0][0],z,v);
	output(&A[0][0],z,v);
    cout << "Матрица B \n";
	int B[h][l];
	input(&B[0][0],h,l);
	output(&B[0][0],h,l);
	cout << "\n\n\n";
	int C[w][n];
	for (w=0;w<c;w++){
		for (n=0;n<c;n++){
			C[w][n]=0;
			for (t=0;t<c;t++){
		C[w][n]+=A[w][t]*B[t][n];
		}}}
	output(&C[0][0],w,n);
return 0;
}
