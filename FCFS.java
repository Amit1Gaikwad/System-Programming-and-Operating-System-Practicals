import java.util.*;
public class FCFS
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of processes:");
        int n = sc.nextInt();
        int pid[]=new int[n];
        int at[]=new int[n];
        int bt[]=new int[n];
        int ct[]=new int[n];
        int ta[]=new int[n];
        int wt[]=new int[n];
        int temp;
        float avg_wt=0,avg_ta=0;
        for(int i = 0; i < n; i++) {
            System.out.println("Enter process " + (i + 1) + " arrival time: ");
            at[i] = sc.nextInt();
            System.out.println("Enter process " + (i + 1) + " brust time: ");
            bt[i] = sc.nextInt();
            pid[i]=i+1;
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n-(i+1);j++)
            {
                if(at[j]>at[j+1])
                {
                    temp=at[j];
                    at[j]=at[j+1];
                    at[j+1]=temp;

                    temp=bt[j];
                    bt[j]=bt[j+1];
                    bt[j+1]=temp;

                    temp=pid[j];
                    pid[j]=pid[j+1];
                    pid[j+1]=temp;
                }
            }
        }
        for(int i=0;i<n;i++)
        {
            if(i==0)
            {
                ct[i]=at[i]+bt[i];
            }
            else
            {
                if(at[i]>ct[i-1])
                {
                    ct[i]=at[i]+bt[i];
                }
                else {
                    ct[i]=ct[i-1]+bt[i];
                }
            }
            ta[i]=ct[i]-at[i];
            wt[i]=ta[i]-bt[i];
            avg_wt+=wt[i];
            avg_ta+=ta[i];
        }
        System.out.println("\nPID  Arrival Time  Burst Time  Completion Time  TurnAround Time  Waiting Time");
        for(int i=0;i<n;i++)
        {
            System.out.println(pid[i]+"    \t    "+at[i]+"    \t    "+bt[i]+"    \t    "+ct[i]+"     \t      "+ta[i]+"     \t      "+wt[i]);
        }
        sc.close();
        System.out.println("\nAverage waiting time: "+(avg_wt/n));
        System.out.println("Average turnaround time: "+(avg_ta/n));
    }
    
    
  /*output 
  amit@amit-Lenovo-IdeaPad-S145-15IWL:~/Documents/TE-ENGG-PR/SEM-V-Practicals/SPOS_PR$ javac FCFS.java
amit@amit-Lenovo-IdeaPad-S145-15IWL:~/Documents/TE-ENGG-PR/SEM-V-Practicals/SPOS_PR$ java FCFS
Enter the number of processes:
4
Enter process 1 arrival time: 
0
Enter process 1 brust time: 
2
Enter process 2 arrival time: 
3
Enter process 2 brust time: 
4
Enter process 3 arrival time: 
5
Enter process 3 brust time: 
6
Enter process 4 arrival time: 
7
Enter process 4 brust time: 
8

PID  Arrival Time  Burst Time  Completion Time  TurnAround Time  Waiting Time
1    	    0    	    2    	    2     	      2     	      0
2    	    3    	    4    	    7     	      4     	      0
3    	    5    	    6    	    13     	      8     	      2
4    	    7    	    8    	    21     	      14     	      6

Average waiting time: 2.0
amit@amit-Lenovo-IdeaPad-S145-15IWL:~/Documents/TE-ENGG-PR/SEM-V-Practicals/SPOS_PR$ */
}
