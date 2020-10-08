import java.io.*;
import java.util.*;

public class Sail {
	
	public static void main(String[] args) {
		FastScanner sc=new FastScanner();
		int n = sc.nextInt();
		long x = sc.nextLong();
		long y = sc.nextLong();
		long xe = sc.nextLong();
		long ye = sc.nextLong();
		long ew = xe-x;
		long ns = ye-y;
		boolean flag = false;
		long ans = 0;
		long ans2=0;
		char[] ch = sc.next().toCharArray();
		if(ew>0) {
			int i = 0;
			for(char c : ch) {
				if(c=='E')
					ew--;
				if(ew==0) {
					ans = i+1;
					break;
				}
				i++;
			}
			if(ew > 0) {
				flag = true;
			}
		}else if(ew < 0){
			int i = 0;
			for(char c : ch) {
				if(c=='W')
					ew++;
				if(ew==0) {
					ans = i+1;
					break;
				}
				i++;
			}
			if(ew < 0) {
				flag = true;
			}
		}
		
		if(ns > 0) {
			int i = 0;
			for(char c : ch) {
				if(c=='N')
					ns--;
				if(ns==0) {
					ans2 = i+1;
					break;
				}
				i++;
			}
			if(ns > 0) {
				flag = true;
			}
		}else if(ns < 0 ){
			int i = 0;
			for(char c : ch) {
				if(c=='S')
					ns++;
				if(ns==0) {
					ans2 = i+1;
					break;
				}
				i++;
			}
			if(ns < 0) {
				flag = true;
			}
		}
		
		System.out.println(flag ? -1 : Math.max(ans, ans2));
		
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
