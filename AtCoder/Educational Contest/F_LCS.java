import java.io.*;
import java.util.*;

public class F_LCS {
	
	public static void main(String[] args) {
		FastScanner sc=new FastScanner();

            char[] s = sc.next().toCharArray();
            StringBuilder sb = new StringBuilder();
            char[] t = sc.next().toCharArray();
            int dp[][] = new int[s.length + 1][t.length + 1];
            for(int i =1; i<=s.length; i++){
                for(int j =1; j<=t.length; j++){
                    if(s[i-1]==t[j-1]){
                        dp[i][j] = dp[i-1][j-1]+1;
                    }else
                        dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]); 
                }
            }
            // Start from last and backtrack to get the correct output.
            int i = s.length;
            int j = t.length;
            while(i>0 && j>0){
                if(dp[i-1][j] == dp[i][j])
                    i--;
                else if(dp[i][j-1] == dp[i][j])
                    j--;
                else{
                    sb.insert(0, s[i-1]);
                    i--;
                    j--;
                }
            }
        
            System.out.println(sb.toString());
    }
	static final Random random = new Random();
	
	static void sort(int[] a) {
		int n = a.length;
		for(int i =0; i<n; i++) {
			int val = random.nextInt(n);
			int cur = a[i];
			a[i] = a[val];
			a[val] = cur;
		}
		Arrays.sort(a);
	}
	
	static void sortl(long[] a) {
		int n = a.length;
		for(int i =0; i<n; i++) {
			int val = random.nextInt(n);
			long cur = a[i];
			a[i] = a[val];
			a[val] = cur;
		}
		Arrays.sort(a);
	}
	
	static class FastScanner {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer("");
		String next() {
			while (st == null  || !st.hasMoreTokens()) {
				try {
					st=new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		String nextLine() { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
		} 
		int nextInt() {
			return Integer.parseInt(next());
		}
		int[] readArray(int n) {
			int[] a=new int[n];
			for (int i=0; i<n; i++) a[i]=nextInt();
			return a;
		}
		long nextLong() {
			return Long.parseLong(next());
		}
		double nextDouble() { 
            return Double.parseDouble(next()); 
        } 
	}

}
