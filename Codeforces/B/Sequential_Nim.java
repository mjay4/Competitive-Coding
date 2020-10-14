import java.io.*;
import java.util.*;

public class Sequential_Nim {
	public static long mod = 1000000007;
	
	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        while(t-->0) {
        	boolean flag = true;
        	int n = sc.nextInt();
        	int ar[] = sc.readArray(n);
        	int count = 0;
        	for(int i = 0; i<n ;i++)
        		if(ar[i] == 1)
        			count++;
        	for(int i =0; i<n-1; i++) {
        		if(ar[i] != 1 && (count%2 == 1 || count == 0)) {
        			break;
        		}else {
        			if(ar[i] != 1) {
        				break;
        			}
        			if(ar[i]==1) {
            			flag=!flag;
            			if(ar[i]==1)
            				count--;
            		}
        		}
        		//System.out.println(flag);
        	}
        	System.out.println(flag ? "First" : "Second");
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
