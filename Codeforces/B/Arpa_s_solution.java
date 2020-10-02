import java.io.*;
import java.util.*;

public class Arpa_s_solution {
	
	  public static void main(String[] args) {
	        FastScanner sc = new FastScanner();
	        int n = sc.nextInt();
	        int x = sc.nextInt();
	        int ar[] = sc.readArray(n);
	        int count[] = new int[1000000];
	        for(int i :ar) {
	        	count[i]++;
	        }
	        // Because a^b = c => a^c = b;
	        long ans = 0;
	        for(int i : ar) {
	        	ans+= count[x^i];
	        	if(i == (x^i))
	        		ans--;
	        }
	        
	        System.out.println(ans/2);
	  }
	  public static int fact(int n) {
		  int ans =1;
		  for(int i=2; i<=n; i++)
			  ans*=i;
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
