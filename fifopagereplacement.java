import java.util.*;
class test
{
	public static void main(String args [])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Number of page:");
		int n=sc.nextInt();
		int page[]=new int [n];
		for(int i=0;i<n;i++)
			page[i]=sc.nextInt();
		System.out.println("Number of page frames:");
		int m=sc.nextInt();
		int frame[]=new int [m];
		int hit=0,fault=0;
			int k=0;
		HashSet<Integer> hs=new HashSet<Integer>();
		for(int i=0;i<n;i++)
		{
			if(hs.contains(page[i]))
			{
				hit++;
			}
			else
			{
					fault++;
					hs.remove(frame[k]);
					frame[k]=page[i];
					hs.add(page[i]);
					k++;
				/*	System.out.println("Frame:");
					for(int j=0;j<m;j++)
					{
					System.out.println(frame[j]+" ");
					}
					System.out.println("Hashet:"+hs);*/
			}
			if(k==m)
			{
				k=0;
			}
		}
		System.out.println("Hits:"+hit);
		System.out.println("fault:"+fault);
		
	}
}