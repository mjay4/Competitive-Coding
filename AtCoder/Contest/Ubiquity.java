import java.io.*;
import java.util.*;

public class Ubiquity {
	static long mod = (long)1e9+7;
	public static void main(String[] args) {
		FastScanner sc=new FastScanner();
        int n = sc.nextInt();
        // ans should be 10^n - 9^n - 9^n + 8^n;
        // Because the no of subsequence we can form is : the whole set - when 9 is not present, when  is not present and then adding the intersection.
        long ans = (pow(n,10)%mod + mod)%mod - (2*pow(n,9)%mod + mod)%mod + (pow(n,8)%mod + mod)%mod;
        System.out.println((ans%mod + mod)%mod);
    }
    
    public static long pow(int n,int val) {
        long ans = 1;
        for (int i = 0; i < n; i++) {
            ans *= val;
            ans %= mod;
        }
        return ans%mod;
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
