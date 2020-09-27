import java.io.*;
import java.util.*;

public class ATM_Queue {
	static long mod = (long)1e9+7;
	public static void main(String[] args) {
		FastScanner sc=new FastScanner();
		int T=sc.nextInt();
		for (int tt=1; tt<=T; tt++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int j = 0;
			long[] ans = new long[n];
			PriorityQueue<int[]> cur = new PriorityQueue<>((a,b)-> a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]);
			for(int i = 1; i<=n; i++) {
					int val = sc.nextInt();
					int ar[] = new int[2];
					ar[0] = ((val-1)/k);
					ar[1] = i;
					cur.offer(ar);
			}		
			while(!cur.isEmpty()) {
				int val[] = cur.poll();
				ans[j++] = val[1];
			}
			System.out.print("Case #"+tt+": ");
			for(long i : ans) {
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}
	
	/* Alternative solution : Space complexity better than previous in best case.
	
	public static void main(String[] args) {
		FastScanner sc=new FastScanner();
		int T=sc.nextInt();
		for (int tt=1; tt<=T; tt++) {
			int n = sc.nextInt();
			long k = sc.nextLong();
			int j = 0;
			long[] ans = new long[n];
			PriorityQueue<int[]> cur = new PriorityQueue<>((a,b)-> a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]);
			for(int i = 1; i<=n; i++) {
				long val = sc.nextLong();
				if(val<= k) {
					ans[j++] = i;
				}else {
					int ar[] = new int[2];
					ar[0] = (int) ((val-1)/k);
					ar[1] = i;
					cur.offer(ar);
				}
			}
			
			while(!cur.isEmpty()) {
				int val[] = cur.poll();
				ans[j++] = val[1];
			}
			System.out.print("Case #"+tt+": ");
			for(long i : ans) {
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}
	*/
	
	/* Brute force : 
	 
	 public static void main(String[] args) {
		FastScanner sc=new FastScanner();
		int T=sc.nextInt();
		for (int tt=1; tt<=T; tt++) {
			int n = sc.nextInt();
			long k = sc.nextLong();
			Queue<Long[]> cur = new LinkedList<>();
			for(int i = 1; i<=n; i++) {
				long val = sc.nextLong();
				Long[] ar = new Long[2];
				ar[0] = val;
				ar[1] = (long)i;
				cur.offer(ar);
			}
			int j = 0;
			long[] ans = new long[n];
			while(!cur.isEmpty()) {
				Long val[] = cur.poll();
				val[0]-=k;
				if(val[0]>0) {
					cur.offer(val);
				}else {
					ans[j++] = val[1]; 
				}
			}
			System.out.print("Case #"+tt+": ");
			for(long i : ans) {
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}
	 
	 */
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
