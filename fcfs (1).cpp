#include<iostream>
using namespace std;

int main()
{
	int pid[4],AT[4],c[4],CT[4],BT[4],TAT[4],WT[4],n;
	
	for(int i=0;i<4;i++)
	{
		cout<<"For Process"<<i+1<<endl;
		cout<<"Enter process id:";
		cin>>pid[i];
		cout<<"Enter Burst time:";
		cin>>BT[i];
		cout<<"Enter Arrival time:";
		cin>>AT[i];
		cout<<endl;
		
	}

/*	while (int j<4)
	{
	for(int i=0;i<4;i++)
	{
		if(BT[i]<BT[i+1])
		{
			largest=BT[i+1];
		}
		else
		{
			largest=BT[i];
		}
	}
	a[j]=largest;
	j++
}*/
int comp=0;
for(int j=0;j<4;j++)
{
	comp=comp+BT[j];
	CT[j]=comp;
	cout<<CT[j]<<"   ";
}

for(int j=0;j<4;j++)
{
	comp=comp+BT[j];
	CT[j]=comp;
	cout<<CT[j]<<"   ";
}
for(int i=0;i<4;i++)
{
	TAT[i]=CT[i]-AT[i];
	WT[i]=TAT[i]-BT[i];
}

for(int i=0;i<4;i++)
{
	cout<<endl<<i+1<<"Process:"<<endl;
	cout<<"Process ID:"<<pid[i]<<endl<<"Arrival Time"<<AT[i]<<endl<<"Burst Time:"<<BT[i]<<endl<<"Compeletion Time:"<<CT[i]<<endl<<"TurnAround Time:"<<TAT[i]<<endl<<"Waiting Time"<<WT[i]<<endl<<endl;
	
}
return 0;

}
