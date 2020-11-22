#include <iostream>
#include <fstream>
#include <stdlib.h>
#include <ctime>
using namespace std;

void input(int *massiv, int N, int M){
srand( time(NULL));
int i,j,x;
for (i=0; i<N; i++){
	for (j=0; j<M; j++){
*(massiv+i*M+j) = 1 + rand() % 9;
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

void sort (int *m2, int z1, int v1) {
	int vsp,r,b;
	cout << "Сколько столбцов будем сортировать? - ";
	cin >> r;
	cout << "\n";
	for (int k=0; k<r; k++){
    cout << "Введите номер столбца - ";
	cin >> b;
	b--;
	cout << "\n";
	for(int p=1; p<z1; p++){
    vsp = *(m2+p*v1+b);
        for(int u=p-1; vsp<*(m2+u*v1+b)&&u>=0; u--){                                       //*(massiv+i*M+j)  *(m2+p*v1+b) *(m2+u*v1+b)
           *(m2+(u+1)*v1+b) = *(m2+u*v1+b);
           *(m2+u*v1+b) = vsp;
           }}}
}

int main(){
	setlocale(LC_ALL, "Russian");
	int z=0,v=0,h=0,l=0;
	cout << "Матрица А \n";
	cout << "Кол-во строк - ";
	cin >> z;
	cout << "Кол-во столбцов - ";
	cin >> v;
	int A[z][v];
	input(&A[0][0],z,v);
	output(&A[0][0],z,v);
	sort (&A[0][0],z,v);
    output(&A[0][0],z,v);
    cout << "Матрица B \n";
	cout << "Кол-во строк - ";
	cin >> h;
	cout << "Кол-во столбцов - ";
	cin >> l;
	int B[h][l];
	input(&B[0][0],h,l);
	output(&B[0][0],h,l);
	sort (&B[0][0],h,l);
    output(&B[0][0],h,l);
return 0;
}
