import java.io.*;
import java.util.*;

public class Cut_Ribbon {
	 
	  public static void main(String[] args) {
	       FastScanner sc = new FastScanner();
	       int n = sc.nextInt();
	       int a = sc.nextInt();
	       int b = sc.nextInt();
	       int c = sc.nextInt();
	       int dp[] = new int[n+1];
	       Arrays.fill(dp, Integer.MIN_VALUE);
	       dp[0] = 0;
	       for(int i = 0 ; i<=n; i++) {
	    	   if(i>=a)
	    		   dp[i] = Math.max(dp[i], dp[i-a]+1);
	    	   if(i>=b)
	    		   dp[i] = Math.max(dp[i], dp[i-b]+1);
	    	   if(i>=c)
	    		   dp[i] = Math.max(dp[i], dp[i-c]+1);
	       }
	      System.out.println(dp[n]);
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
