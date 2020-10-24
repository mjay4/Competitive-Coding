import java.io.*;
import java.util.*;

public class Flipping_Game {
	static long mod = (long)1e9+7;
	public static void main(String[] args) {
		FastScanner sc=new FastScanner();
		int n = sc.nextInt();
		int ar[] = sc.readArray(n);
		int one = 0;
		int globalSum = 0;
		int currentSum = 0;
		int dp[] = new int[n];
		
		for(int i=0; i<n; i++) {
			if(ar[i]==1) {
				one++;
				dp[i]=-1;
			}else
				dp[i]=1;
		}
		globalSum+= dp[0];
		currentSum+= dp[0];
		
		for(int i =1; i<n; i++) {
			if(currentSum<=0)
				currentSum = dp[i];
			else
				currentSum+=dp[i];
			globalSum = Math.max(currentSum, globalSum);	
		}
		System.out.println(one+globalSum);

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
