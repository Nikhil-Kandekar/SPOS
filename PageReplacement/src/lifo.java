import java.util.Scanner;

public class lifo {
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
{
	int j=0;
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
{ 
	System.out.println("Page No \t Layout \t Distance");
	for(int i=0;i<pgno;i++)
	{
		int res=search(pg_seq[i]);
		if(res==-1)
		{  
			int res2=findempty();
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
				//int res3=findmax();
				buffer[fno-1]=pg_seq[i];
				for(int z=0;z<fno;z++)
				{
					dist[z]++;
				}
				dist[fno-1]=0;
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
	for(int q=0;q<fno;q++) {
		System.out.print(" "+buffer[q]);
	}
	System.out.print("\t \t");
	for(int q=0;q<fno;q++){
		System.out.print(" "+dist[q]);}
		System.out.println();
	}
	System.out.println("Hits="+hit);
	System.out.println("Fault="+fault);
}

	public static void main(String[] args)
	{
		lifo l=new lifo();
		l.input();
		l.calc();
	}

}

/*Output
 * Enter no of pages:
40
enter sequence of pages:
1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20
1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20
enter no of frames:
10
Page No 	 Layout 	 Distance
1	 	 1 -1 -1 -1 -1 -1 -1 -1 -1 -1	 	 0 1 1 1 1 1 1 1 1 1
2	 	 1 2 -1 -1 -1 -1 -1 -1 -1 -1	 	 1 0 2 2 2 2 2 2 2 2
3	 	 1 2 3 -1 -1 -1 -1 -1 -1 -1	 	 2 1 0 3 3 3 3 3 3 3
4	 	 1 2 3 4 -1 -1 -1 -1 -1 -1	 	 3 2 1 0 4 4 4 4 4 4
5	 	 1 2 3 4 5 -1 -1 -1 -1 -1	 	 4 3 2 1 0 5 5 5 5 5
6	 	 1 2 3 4 5 6 -1 -1 -1 -1	 	 5 4 3 2 1 0 6 6 6 6
7	 	 1 2 3 4 5 6 7 -1 -1 -1	 	 6 5 4 3 2 1 0 7 7 7
8	 	 1 2 3 4 5 6 7 8 -1 -1	 	 7 6 5 4 3 2 1 0 8 8
9	 	 1 2 3 4 5 6 7 8 9 -1	 	 8 7 6 5 4 3 2 1 0 9
10	 	 1 2 3 4 5 6 7 8 9 10	 	 9 8 7 6 5 4 3 2 1 0
11	 	 1 2 3 4 5 6 7 8 9 11	 	 10 9 8 7 6 5 4 3 2 0
12	 	 1 2 3 4 5 6 7 8 9 12	 	 11 10 9 8 7 6 5 4 3 0
13	 	 1 2 3 4 5 6 7 8 9 13	 	 12 11 10 9 8 7 6 5 4 0
14	 	 1 2 3 4 5 6 7 8 9 14	 	 13 12 11 10 9 8 7 6 5 0
15	 	 1 2 3 4 5 6 7 8 9 15	 	 14 13 12 11 10 9 8 7 6 0
16	 	 1 2 3 4 5 6 7 8 9 16	 	 15 14 13 12 11 10 9 8 7 0
17	 	 1 2 3 4 5 6 7 8 9 17	 	 16 15 14 13 12 11 10 9 8 0
18	 	 1 2 3 4 5 6 7 8 9 18	 	 17 16 15 14 13 12 11 10 9 0
19	 	 1 2 3 4 5 6 7 8 9 19	 	 18 17 16 15 14 13 12 11 10 0
20	 	 1 2 3 4 5 6 7 8 9 20	 	 19 18 17 16 15 14 13 12 11 0
1	 	 1 2 3 4 5 6 7 8 9 20	 	 20 19 18 17 16 15 14 13 12 1
2	 	 1 2 3 4 5 6 7 8 9 20	 	 21 20 19 18 17 16 15 14 13 2
3	 	 1 2 3 4 5 6 7 8 9 20	 	 22 21 20 19 18 17 16 15 14 3
4	 	 1 2 3 4 5 6 7 8 9 20	 	 23 22 21 20 19 18 17 16 15 4
5	 	 1 2 3 4 5 6 7 8 9 20	 	 24 23 22 21 20 19 18 17 16 5
6	 	 1 2 3 4 5 6 7 8 9 20	 	 25 24 23 22 21 20 19 18 17 6
7	 	 1 2 3 4 5 6 7 8 9 20	 	 26 25 24 23 22 21 20 19 18 7
8	 	 1 2 3 4 5 6 7 8 9 20	 	 27 26 25 24 23 22 21 20 19 8
9	 	 1 2 3 4 5 6 7 8 9 20	 	 28 27 26 25 24 23 22 21 20 9
10	 	 1 2 3 4 5 6 7 8 9 10	 	 29 28 27 26 25 24 23 22 21 0
11	 	 1 2 3 4 5 6 7 8 9 11	 	 30 29 28 27 26 25 24 23 22 0
12	 	 1 2 3 4 5 6 7 8 9 12	 	 31 30 29 28 27 26 25 24 23 0
13	 	 1 2 3 4 5 6 7 8 9 13	 	 32 31 30 29 28 27 26 25 24 0
14	 	 1 2 3 4 5 6 7 8 9 14	 	 33 32 31 30 29 28 27 26 25 0
15	 	 1 2 3 4 5 6 7 8 9 15	 	 34 33 32 31 30 29 28 27 26 0
16	 	 1 2 3 4 5 6 7 8 9 16	 	 35 34 33 32 31 30 29 28 27 0
17	 	 1 2 3 4 5 6 7 8 9 17	 	 36 35 34 33 32 31 30 29 28 0
18	 	 1 2 3 4 5 6 7 8 9 18	 	 37 36 35 34 33 32 31 30 29 0
19	 	 1 2 3 4 5 6 7 8 9 19	 	 38 37 36 35 34 33 32 31 30 0
20	 	 1 2 3 4 5 6 7 8 9 20	 	 39 38 37 36 35 34 33 32 31 0
Hits=9
Fault=31
*/
