import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A_Frog1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     	int t = Integer.parseInt(br.readLine());
     	//while(t-->0) {
     	int ar[] = new int[t];
   		int dp[] = new int[t];
   		StringTokenizer st = new StringTokenizer(br.readLine());
       	for(int i =0;i<t;i++) {
       		ar[i] = Integer.parseInt(st.nextToken());
       	}
     	
       	if(t==1)
       		System.out.println(ar[0]);
       	else {
       		dp[0] = 0;
       		for(int i =1;i<t; i++) {
       			dp[i] = Math.min(i>1 ? dp[i-2] + Math.abs(ar[i] - ar[i-2]) : Integer.MAX_VALUE, dp[i-1]+Math.abs(ar[i]-ar[i-1]));
       		}
       		System.out.println(dp[t-1]);
       	}
	}

}
