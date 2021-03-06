import java.util.Scanner;

public class fifo {
	int pgno=0,fno=0,hit=0,fault=0;
	int pg_seq[],buffer[],dist[];
	Scanner sc=new Scanner(System.in);
void input()
{
	System.out.println("Enter no of pages:");
	pgno=sc.nextInt();
	pg_seq=new int[pgno];
	System.out.println("enter sequence of pages:");
	for(int i=0;i<pgno;i++)
	{
		pg_seq[i]=sc.nextInt();
	}
	System.out.println("enter no of frames:");
	fno=sc.nextInt();
	buffer=new int[fno];
	dist=new int[fno];
	for(int i=0;i<fno;i++)
	{
		buffer[i]=-1;
		dist[i]=0;
	}
}
int search(int a)
{
	for(int i=0;i<fno;i++)
	{
		if(buffer[i]==a)
		{
			return i;
		}
	}
	return -1;
}

int findempty()
{
	for(int i=0;i<fno;i++)
	{
		if(buffer[i]==-1)
		{
			return i;
		}
	}
	return -1;
}


int findmax()
{int j=0;
	for(int i=0;i<fno;i++)
	{
		if(dist[i]>dist[j])
		{
			j=i;
		}
	}
	return j;
}
void calc()
{ System.out.println("Page No \t Layout \t Distance");
	for(int i=0;i<pgno;i++)
	{
		int res=search(pg_seq[i]);
		if(res==-1)
		{  int res2=findempty();
			if(res2!=-1)
			{
				for(int k=0;k<fno;k++)
				{
					dist[k]++;
				}
				dist[res2]=0;
				buffer[res2]=pg_seq[i];
			}
			else
			{
				int res3=findmax();
				buffer[res3]=pg_seq[i];
				for(int z=0;z<fno;z++)
				{
					dist[z]++;
				}
				dist[res3]=0;
			}
			fault++;
		}
		else
		{
			hit++;
			for(int j=0;j<fno;j++)
			{
					dist[j]++;
			}
			
		}
	
	System.out.print(pg_seq[i]+"\t \t");
	for(int q=0;q<fno;q++)
	{System.out.print(" "+buffer[q]);}
	System.out.print("\t \t");
	for(int q=0;q<fno;q++)
	{System.out.print(" "+dist[q]);}
		System.out.println();
	}
	System.out.println("Hits="+hit);
	System.out.println("Fault="+fault);
}

public static void main(String[] args)
{
	fifo l=new fifo();
	l.input();
	l.calc();
}


}

/* Output 
Enter no of pages:
6
enter sequence of pages:
1
3
0
3
5
6
enter no of frames:
3
Page No 	 Layout 	 Distance
1	 	 1 -1 -1	 	 0 1 1
3	 	 1 3 -1	 	 1 0 2
0	 	 1 3 0	 	 2 1 0
3	 	 1 3 0	 	 3 2 1
5	 	 5 3 0	 	 0 3 2
6	 	 5 6 0	 	 1 0 3
Hits=1
Fault=5
*/