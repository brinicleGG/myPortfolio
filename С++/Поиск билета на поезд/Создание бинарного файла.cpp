#include <stdio.h>
#include <iostream>

using namespace std;

struct information_about_the_train {
	int train_number;
	int destination_station;
	float departure_time;
	float travel_time;
	bool tickets_availability;
};
	
int main(int argc, const char * argv[]){
	
	information_about_the_train train[24];
	
	train[0];
	train[0].train_number = 12;
	train[0].destination_station = 3;
	train[0].departure_time = 930; //15:30
	train[0].travel_time = 180;
	train[0].tickets_availability = 1;
	
	train[1] = {11, 3, 1360, 550, 1};
	train[2] = {13, 3, 1240, 490, 1};
	train[3] = {14, 3, 1120, 600, 1};
	train[4] = {15, 3, 1000, 590, 0};
	
	train[5] = {31, 4, 1000, 500, 1};
	train[6] = {32, 4, 920, 450, 0};
	train[7] = {33, 4, 1100, 550, 1};
	train[8] = {34, 4, 1320, 600, 0};
	
	train[9] = {50, 1, 120, 60, 1};
	train[10] = {51, 1, 240, 60, 1};
	train[11] = {52, 1, 360, 60, 0};
	train[12] = {53, 1, 480, 60, 1};
	train[13] = {54, 1, 600, 60, 0};
	train[14] = {55, 1, 720, 60, 1};
	train[15] = {56, 1, 840, 60, 0};
	train[16] = {57, 1, 960, 60, 1};
	train[17] = {58, 1, 1080, 60, 1};
	train[18] = {59, 1, 1200, 60, 0};
	
	train[19] = {21, 2, 550, 120, 0};
	train[20] = {22, 2, 120, 240, 1};
	train[21] = {23, 2, 360, 90, 1};
	train[22] = {24, 2, 840, 180, 0};
	train[23] = {25, 2, 720, 90, 1};
	
FILE *fp=fopen("data.bin","wb+");
for (int i=0; i<24; i++){
fwrite(&train[i],sizeof(information_about_the_train),1,fp);}
fclose(fp);
return 0;
}
