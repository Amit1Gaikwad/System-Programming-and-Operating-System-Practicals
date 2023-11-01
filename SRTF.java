//preemptive SJF (Shortest remaining time first) Scheduling Algorithm 
import java.util.*;
public class SRTF {
public static void main (String args[])
{
Scanner sc=new Scanner(System.in);
System.out.println ("enter no of process:");
int n= sc.nextInt();
int pid[] = new int[n]; // it takes pid of process
int at[] = new int[n]; // at means arrival time
int bt[] = new int[n]; // bt means burst time
int ct[] = new int[n]; // ct means complete time
int ta[] = new int[n];// ta means turn around time
int wt[] = new int[n];  // wt means waiting time
int f[] = new int[n];  // f means it is flag it checks process is completed or not
int k[]= new int[n];   // it is also stores brust time
    int i, st=0, tot=0;

    float avgwt=0, avgta=0;
 
    for (i=0;i<n;i++)
    {
     pid[i]= i+1;
     System.out.println ("enter process " +(i+1)+ " arrival time:");
     at[i]= sc.nextInt();
     System.out.println("enter process " +(i+1)+ " burst time:");
     bt[i]= sc.nextInt();
     k[i]= bt[i];
     f[i]= 0;
    }
   
   /* output
   amit@amit-Lenovo-IdeaPad-S145-15IWL:~/Documents/TE-ENGG-PR/SEM-V-Practicals/SPOS_PR$ javac SRTF.java
amit@amit-Lenovo-IdeaPad-S145-15IWL:~/Documents/TE-ENGG-PR/SEM-V-Practicals/SPOS_PR$ java SRTF
enter no of process:
3
enter process 1 arrival time:
0
enter process 1 burst time:
2
enter process 2 arrival time:
2
enter process 2 burst time:
3
enter process 3 arrival time:
4
enter process 3 burst time:
6
pid  arrival  burst  complete turn waiting
1	0	2	2	2	0
2	2	3	5	3	0
3	4	6	11	7	1

average tat is 4.0 */
    
    while(true){
     int min=99,c=n;
     if (tot==n)
     break;
    
     for ( i=0;i<n;i++)
     {
     if ((at[i]<=st) && (f[i]==0) && (bt[i]<min))
     {
     min=bt[i];
     c=i;
     }
     }
    
     if (c==n)
     st++;
     else
     {
     bt[c]--;
     st++;
     if (bt[c]==0)
     {
     ct[c]= st;
     f[c]=1;
     tot++;
     }
     }
    }
    
    for(i=0;i<n;i++)
    {
     ta[i] = ct[i] - at[i];
     wt[i] = ta[i] - k[i];
     avgwt+= wt[i];
     avgta+= ta[i];
    }
    
    System.out.println("pid  arrival  burst  complete turn waiting");
    for(i=0;i<n;i++)
    {
     System.out.println(pid[i] +"\t"+ at[i]+"\t"+ k[i] +"\t"+ ct[i] +"\t"+ ta[i] +"\t"+ wt[i]);
    }
    
    System.out.println("\naverage tat is "+ (float)(avgta/n));
    System.out.println("average wt is "+ (float)(avgwt/n));
    sc.close();
}
}
	 
