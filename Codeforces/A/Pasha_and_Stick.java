import java.io.*;
import java.util.*;

public class Pasha_and_Stick {
	 
	  public static void main(String[] args) {
	       FastScanner sc = new FastScanner();
	       int t = sc.nextInt();
	       long ans = 0;
	       if(t%2 == 1 || t<6)
	    	   ans = 0;
	       else {
	    	   t/=2;
	       if(t==3)
	    	   ans = 1;
	       else
	    	   ans=((t-3)/2)+1;
	       }
	       System.out.println(ans);
	  }
	  
	  public static long check(int a, int b) {
		  int bit = 0;
		  long ans = 0;
		  while(a != 0 || b != 0) {
			  if((a%2 == 1) && (b%2 == 1))
				  ans+=(1<<bit);
			  a>>=1;
			  b>>=1;
			  bit+=1; 
		  }
		  return ans;
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
