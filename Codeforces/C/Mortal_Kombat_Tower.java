import java.io.*;
import java.util.*;

public class Mortal_Kombat_Tower {
	static int dp[][];
	static int ar[];
	public static void main(String[] args) {
		FastScanner sc=new FastScanner();
		int T=sc.nextInt();
		for (int tt=0; tt<T; tt++) {
			int n = sc.nextInt();
			ar = sc.readArray(n);
			dp = new int[2][n+1];
			for(int i[] : dp){
				Arrays.fill(i,-1);
			}		
			System.out.println(check(0,0));
		}
	}
	public static int check(int pos, int turn){
		if(pos == ar.length) 
			return 0;
		if(dp[turn][pos] !=-1)
			return dp[turn][pos];
		if(turn == 0){
			int min = check(pos+1,1)+ar[pos];
			if(pos!=ar.length-1){
				min = Math.min(min, check(pos+2,1)+ar[pos+1]+ar[pos]);
			}
			return dp[turn][pos] = min;
		}
		int min = check(pos+1,0);
		if (pos != ar.length - 1) {
			min = Math.min(min, check(pos + 2, 0));
		}
		return dp[turn][pos] = min;
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
