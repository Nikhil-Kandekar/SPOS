import java.util.Scanner;
class process
{
	int allo[];
	int maxneed[];
	int need[];
	boolean done=false;
}
public class bankers {
	Scanner sc=new Scanner(System.in);
	int rno=0,pno=0,o=0;
	process p[];
	int avail[],order[];
	void get()
	{
		System.out.println("enter no of resources:");
		rno=sc.nextInt();
		System.out.println("enter no of processes:");
		pno=sc.nextInt();
		p=new process[pno];
		order=new int[pno];
		avail=new int[rno];
		
		for(int i=0;i<pno;i++)
		{
			p[i]=new process();
			p[i].allo=new int[rno];
			p[i].maxneed=new int[rno];
			p[i].need=new int[rno];
			for(int j=0;j<rno;j++){
			System.out.println("Enter Allocation for process"+i+" resources "+j);
			p[i].allo[j]=sc.nextInt();
			System.out.println("Enter maxneed for "+i+" resources "+j);
			p[i].maxneed[j]=sc.nextInt();
			}
		}
		for(int i=0;i<rno;i++)
		{
			System.out.println("Enter no of available resources "+i);
			avail[i]=sc.nextInt();
		}
		
	}
	void calc()
	{
		for(int i=0;i<pno;i++)
		{ 
			for(int j=0;j<rno;j++)
			{
				p[i].need[j]=p[i].maxneed[j]-p[i].allo[j];
			}
		}
		int count=0,z=0,f=0;
		boolean fl=false;
		while(count<pno)
		{
			if(z>=pno)
			{
				z=0;
			}
			if(p[z].done==false){
			for(int i=0;i<rno;i++)
			{
			if(p[z].need[i]<=avail[i])
			{
				f++;
				fl=true;
			}
			}
			if(f>=rno && fl==true)
			{
			  for(int i=0;i<rno;i++)
			  {
				  avail[i]+=p[z].allo[i];
			  }
			  count++;
			  order[o]=z;
			  o++;
			}}
			z++;
		}
	}
	void display()
	{
		System.out.println("Safe Sequence");
		for(int i=0;i<o;i++)
				{
					System.out.print("P"+order[i]+" ");
				}
		System.out.println("\navailable");
		for(int i=0;i<rno;i++)
		{
			System.out.print(avail[i]+" ");
		}
	}
	public static void main(String[] args) {
		bankers b=new bankers();
		b.get();
		b.calc();
		b.display();
	}
}

/*Output
 * 
 * enter no of resources:
5
enter no of processes:
4
Enter Allocation for process0 resources 0
1
Enter maxneed for 0 resources 0
1
Enter Allocation for process0 resources 1
0
Enter maxneed for 0 resources 1
1
Enter Allocation for process0 resources 2
2
Enter maxneed for 0 resources 2
2
Enter Allocation for process0 resources 3
1
Enter maxneed for 0 resources 3
1
Enter Allocation for process0 resources 4
1
Enter maxneed for 0 resources 4
3
Enter Allocation for process1 resources 0
2
Enter maxneed for 1 resources 0
2
Enter Allocation for process1 resources 1
0
Enter maxneed for 1 resources 1
2
Enter Allocation for process1 resources 2
1
Enter maxneed for 1 resources 2
2
Enter Allocation for process1 resources 3
1
Enter maxneed for 1 resources 3
1
Enter Allocation for process1 resources 4
0
Enter maxneed for 1 resources 4
0
Enter Allocation for process2 resources 0
1
Enter maxneed for 2 resources 0
2
Enter Allocation for process2 resources 1
1
Enter maxneed for 2 resources 1
1
Enter Allocation for process2 resources 2
0
Enter maxneed for 2 resources 2
3
Enter Allocation for process2 resources 3
1
Enter maxneed for 2 resources 3
1
Enter Allocation for process2 resources 4
1
Enter maxneed for 2 resources 4
1
Enter Allocation for process3 resources 0
1
Enter maxneed for 3 resources 0
1
Enter Allocation for process3 resources 1
1
Enter maxneed for 3 resources 1
1
Enter Allocation for process3 resources 2
1
Enter maxneed for 3 resources 2
2
Enter Allocation for process3 resources 3
1
Enter maxneed for 3 resources 3
2
Enter Allocation for process3 resources 4
0
Enter maxneed for 3 resources 4
0
Enter no of available resources 0
4
Enter no of available resources 1
0
Enter no of available resources 2
0
Enter no of available resources 3
1
Enter no of available resources 4
1
Safe Sequence
P1 P2 P3 P0 
available
9 2 4 5 3 */
