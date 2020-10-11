import java.io.*;
import java.util.*;

public class Laptop {
	
	public static void main(String[] args) {
		FastScanner sc=new FastScanner();
		int n = sc.nextInt();
        int ar[][] = new int[n][2];
        for(int i = 0; i<n; i++){
            ar[i] = sc.readArray(2);
        }
        Arrays.sort(ar, (a,b) -> a[0]-b[0]);
        int cur = ar[0][1];
        boolean flag = false;
        for(int i = 1; i<n; i++){
            if(ar[i][1] < cur){
                flag = true;
                break;
            }
            cur = ar[i][1];
        }
        System.out.println((flag)?"Happy Alex" : "Poor Alex");
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
