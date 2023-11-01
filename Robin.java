import java.util.*;
public class Robin
{
public static void main(String args[])
{
int n,i,qt,count=0,temp,sq=0,bt[],wt[],tat[],rem_bt[];
float awt=0,atat=0;
bt=new int[10];
wt=new int[10];
tat=new int[10];
rem_bt=new int[10];
Scanner sc=new Scanner(System.in);
System.out.print("Enter the number of process= ");
n=sc.nextInt();
System.out.print("\nEnter the burst time of the process: ");
for(i=0;i<n;i++)
{
System.out.print("Process"+i+"=");
bt[i]=sc.nextInt();
rem_bt[i]=bt[i];
}
System.out.print("Enter the quantum time: ");
qt=sc.nextInt();
while(true)
{
for(i=0,count=0;i<n;i++)
{
temp=qt;
if(rem_bt[i]==0)
{
count++;
continue;
}
if(rem_bt[i]>qt)
{
rem_bt[i]=rem_bt[i]-qt;
}
else 
if(rem_bt[i]>=0)
{
temp=rem_bt[i];
rem_bt[i]=0;		
}
sq=sq+temp;
tat[i]=sq;
}
if(n==count)
break;
}
System.out.print("\nProcess\tBurstTime\tTurnaroundTime\tWaitingTime\n");
System.out.print("------------------------------------");
for(i=0;i<n;i++)
{
wt[i]=tat[i]-bt[i];
awt=awt+wt[i];
atat=atat+tat[i];
System.out.print("\n"+(i+1)+"\t"+bt[i]+"\t"+tat[i]+"\t"+ wt[i] +"\n");
}
awt=awt/n;
atat=atat/n;
System.out.println("\nAverage waiting time= "+awt);
System.out.println("\nAverage turnaround time= "+atat);
}
}

/*output
mit@amit-Lenovo-IdeaPad-S145-15IWL:~/Documents/TE-ENGG-PR/SEM-V-Practicaamit@amit@amit-Lenovo-IdeaPad-S145-15IWL:~/Documents/TE-ENGG-PR/SEM-V-Practicals/SPO
S_PR$ javac Robin.java
amit@amit-Lenovo-IdeaPad-S145-15IWL:~/Documents/TE-ENGG-PR/SEM-V-Practicals/SPOS_PR$ java Robin
Enter the number of process= 3

Enter the burst time of the process: Process0=1
Process1=2
Process2=3
Enter the quantum time: 5

Process	BurstTime	TurnaroundTime	WaitingTime
------------------------------------
1	1	1	0

2	2	3	1

3	3	6	3

Average waiting time= 1.3333334

*/
