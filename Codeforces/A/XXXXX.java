import java.io.*;
import java.util.*;

public class XXXXX {
	 
	  public static void main(String[] args) {
	       FastScanner sc = new FastScanner();
	       int t = sc.nextInt();
	       while(t-->0) {
	       int n = sc.nextInt();
	       int x = sc.nextInt();
	       long prefix[] = new long[n+1];
	       int ar[] = sc.readArray(n);
	       for(int i =1; i<=n; i++)
	    	   prefix[i] = prefix[i-1]+ar[i-1];
	       int ans = -1;
	       
	       int lastIdx = 0;
	       for(int i=0; i<n; i++) {
	    	   if(ar[i]%x != 0)
	    		   lastIdx = i;
	       }
	       
	       for(int i = 0; i<n; i++) {
	    	   long front = prefix[n] - prefix[i];
	    	   if(front%x != 0)
	    		   ans = Math.max(ans , n-i);
	    	   long back = prefix[lastIdx] - prefix[i];
	    	   if(back%x != 0)
	    		   ans = Math.max(ans, lastIdx-i);
	       }
	       
	       System.out.println(ans);
	       }
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
