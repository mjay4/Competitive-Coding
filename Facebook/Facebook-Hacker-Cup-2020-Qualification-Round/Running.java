import java.util.*;
import java.io.*;

public class Running{
	 private static Scanner sc;
	 public static void main(String args[]){
		try{
	            File file = new File("input.txt");
	            sc = new Scanner(file);

	            for(int T=sc.nextInt(),t=1;t<=T;t++){
	                int N = sc.nextInt();
	                int M = sc.nextInt();

	                int[] nums = new int[N];

	                for(int i=0;i<N;i++){
	                    nums[i] = sc.nextInt();
	                }

	                System.out.println("Case #"+t+": "+min(nums,M,N));
	            }
	        }catch(IOException e){
	            System.out.println(e.getMessage());
	        }
	 }
	 
	 public static long min(int ar[], int cap , int n) {
		//long ans = Long.MAX_VALUE;
         
		if(cap>=n-1)
         		return 0;

         	for(int i =1;i<n-1;i++) {
         		int count =0;
         		if(ar[i]==0) {
         			count=1;
         			while(i+1<n && ar[i]==ar[i+1]) {
         				count++;
         				i++;
         			}
         		}
         		if(count>=cap)
         			return -1;
         	}
         	
         	for(int i =0;i<n;i++) {
         		if(ar[i] == 0)
         			ar[i] = Integer.MAX_VALUE;
         		if(i==n-1 || i==0)
         			ar[i] = 0;
         	}
         	
         	//ans = cal(ar,0,n,0,cap);
         	long min = Long.MAX_VALUE;
         	PriorityQueue<Long> pq = new PriorityQueue<>();
         	long dp[] = new long[n];
         	for(int i =0;i<cap;i++) {
         		dp[i] = ar[i];
         		pq.add(dp[i]);
         	}
         	for(int i =cap;i<n;i++) {
         		min = pq.peek();
         		dp[i] = min+ar[i];
         		if(dp[i-cap]==min) {
         			pq.poll();
         		}else {
         			pq.remove(dp[i-cap]);
         		}
         		pq.add(dp[i]);
         	}

        	return dp[n-1];
	 }
}