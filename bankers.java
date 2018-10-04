import java.util.Scanner;
class test{
	
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter no. of process:");
		int np=sc.nextInt();
		System.out.println("Enter number of resources");
		int nr=sc.nextInt();
		int allocation[][]=new int [np][nr];
		int max[][]=new int [np][nr];
		int available[]=new int [nr];
		int need[][]=new int [np][nr];
		boolean finish[]=new boolean[np];
		System.out.println("\nEnter elements in allocation:\n");
		for(int i=0;i<np;i++)
		{
			for(int j=0;j<nr;j++)
			{
				allocation[i][j]=sc.nextInt();
			}
		}
		System.out.println("\nEnter elements in MAX:\n");
		for(int i=0;i<np;i++)
		{
			for(int j=0;j<nr;j++)
			{
				max[i][j]=sc.nextInt();
			}
		}
		System.out.println("\nEnter elements in available:\n");
		for(int i=0;i<nr;i++)
		{
			available[i]=sc.nextInt();
		}
		for(int i=0;i<np;i++)
		{
			for(int j=0;j<nr;j++)
			{
				need [i][j]=max[i][j]-allocation[i][j];
			}
		}
		System.out.println("\nAllocation Matrix:\n");
		for(int i=0;i<np;i++)
		{
			for(int j=0;j<nr;j++)
			{
				System.out.print(allocation[i][j]+" ");
			}
			System.out.println("");
		}
		System.out.println("\nMax Matrix:\n");
		for(int i=0;i<np;i++)
		{
			for(int j=0;j<nr;j++)
			{
				System.out.print(max[i][j]+" ");
			}
			System.out.println("");
		}
		
		System.out.println("\nAvailable:\n");
		for(int i=0;i<nr;i++)
			System.out.print(available[i]+" ");
		
		System.out.println("\nNeed:\n");
		for(int i=0;i<np;i++)
		{
			for(int j=0;j<nr;j++)
			{
				System.out.print(need[i][j]+" ");
			}
			System.out.println("");
		}
		System.out.println("/nFinish Array:");
		for(int i=0;i<np;i++)
			System.out.println(finish[i]+" ");
		int counter,count=0,l=0;
		while(count!=np)
		{
			int i,s=0;
			if(finish[s]==false){
			for( i=0;i<np;i++)
			{
				counter=0;
				for(int j=0;j<nr;j++)
				{
					if(need[i][j]<=available[j])
					{
						counter++;
					}
				}
				if(counter==nr){
					for(int y=0;y<nr;y++)
						{
							available[y]=available[y]+allocation[i][y];
						}
					finish[i]=true;
					System.out.println("\nUpdated available :");
						for(int j=0;j<nr;j++)
							{
								System.out.print(available[j]+" ");
							}
						
				}
				
			}
			count=0;
			for(int k=0;k<np;k++)
			{
				if(finish[k]==true){
					System.out.println("\nProcess "+k+" finished:");
				count++;}
			}
			System.out.println("\nFinish Array in loop:");
		for(int f=0;f<np;f++)
			System.out.println(finish[f]+" ");
		}
		else
			s++;
		l++;
		}
		if(l==1)
		System.out.println("Safe");
	else
		System.out.println("Unsafe");
		
		
	}
} 
