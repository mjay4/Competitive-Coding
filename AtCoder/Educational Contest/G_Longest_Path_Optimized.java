import java.io.*;
import java.util.*;

public class G_Longest_Path_Optimized {
    static List<Integer> [] al;
	static long [] dp;
	static long dfs(int u){
		if(dp[u]>0)return dp[u];
		long dist=1;
		for(int v : al[u]){
			  dist=Math.max(dist,1+dfs(v));
		}
		return dp[u]=dist;
	}
	public static void main( String [] args) throws IOException{
		FastScanner sc=new FastScanner();
		int n=sc.nextInt();
		int m=sc.nextInt();
		al=new ArrayList[n];
		for(int i=0;i<n;i++)al[i]=new ArrayList<>();
		dp=new long[n];
		for(int i=0;i<m;i++){
			int u=sc.nextInt()-1;
			int v=sc.nextInt()-1;
			al[u].add(v);
		}
		long max=0;
		for(int i=0;i<n;i++){
			max=Math.max(max,dfs(i));
		}
		System.out.println(max-1);
		
 
    }
    
    static final Random random = new Random();

    static void sort(final int[] a) {
        final int n = a.length;
        for (int i = 0; i < n; i++) {
            final int val = random.nextInt(n);
            final int cur = a[i];
            a[i] = a[val];
            a[val] = cur;
        }
        Arrays.sort(a);
    }

    static void sortl(final long[] a) {
        final int n = a.length;
        for (int i = 0; i < n; i++) {
            final int val = random.nextInt(n);
            final long cur = a[i];
            a[i] = a[val];
            a[val] = cur;
        }
        Arrays.sort(a);
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (final IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (final IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArray(final int n) {
            final int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
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
