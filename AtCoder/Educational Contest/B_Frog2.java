import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_Frog2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
     	int n = Integer.parseInt(st.nextToken());
     	int k = Integer.parseInt(st.nextToken());
     	int ar[] = new int[n];
   		int dp[] = new int[n];
   		st = new StringTokenizer(br.readLine());
       	for(int i =0;i<n;i++) {
       		ar[i] = Integer.parseInt(st.nextToken());
       	}
       
       	dp[0] = 0;
       	for(int i =1;i<n; i++) {
       		dp[i] = Integer.MAX_VALUE;
       		for(int j = i-1; j>=Math.max(0, i-k); j--)
       			dp[i] = Math.min(dp[i] , Math.abs(ar[i] - ar[j]) + dp[j]);
       	}
       	
       	System.out.println(dp[n-1]);
     
       
	}
}