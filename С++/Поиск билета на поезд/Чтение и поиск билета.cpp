#include <stdio.h>
#include <iostream>
#include <Windows.h>

using namespace std;

struct information_about_the_train {
	int train_number;
	int destination_station;
	float departure_time;
	float travel_time;
	bool tickets_availability;
};

int main(int argc, const char * argv[]){
	SetConsoleCP (1251);
	SetConsoleOutputCP (1251);
	int a=0,b=0,c=0,i=0,d=0;
	
	information_about_the_train train[24];
	
	cout << "1.Санкт-Петербург - Зеленогорск." << "\n" << "2.Санкт-Петербург - Тосно." << "\n" << 
	"3.Санкт-Петербург - Ярославль." << "\n" << "4.Санкт-Петербург - Москва." << "\n";
	cin >> a;
	cout << "Время отправления - C ";
	cin >> b;
	cout << "до ";
	cin >> c;
	cout << "\n";

FILE *fp=fopen("data.bin","rb");
for (i=0;i<24;i++){
fread(&train[i],sizeof(information_about_the_train),1,fp);
if (b<=(train[i].departure_time/60) && (train[i].departure_time/60)<=c && train[i].destination_station == a){
	cout << "Номер поезда №" << train[i].train_number << " Время отправления - " << train[i].departure_time/60 << "\n";
}
}
cout << "Для проверки наличия билетов введите номер поезда ";
cin >> d;
cout << "\n";
for (i=0;i<24;i++){
fread(&train[i],sizeof(information_about_the_train),1,fp);
if (train[i].train_number==d){
	if (train[i].tickets_availability){
		cout << "Есть";
	} else cout << "Нет";
}}
fclose(fp);
return 0;
}
