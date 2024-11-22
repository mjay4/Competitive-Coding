package practice;


import java.io.*;
import java.util.*;

/**
 * Segment Tree which returns the max of an Array for range in L to R. 
 */
public class MaxSegmentTree {

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        int q = sc.nextInt();
        int a[] = new int[n];
        for (int tt = 0; tt < n; tt++) {
            ar[tt] =  sc.nextInt();
        }
        buildSegmentTree(0, n-1);
        for (int qq=0; qq<q; qq++) {
        	int l = sc.nextInt()-1;
        	int r = sc.nextInt()-1;
        	
        	System.out.println(query(0,0,n-1,l,r));
        }
    }
    
    static int ar[] = new int[100005];
	static int seg[] = new int[400005];
    
    static void buildSegmentTree(int low, int high) {
    	build(0, low, high);
    }

    private static void build(int idx, int low, int high) {
		if (low == high) {
			seg[idx] = ar[low];
			return;
		}
		int mid = low + (high-low)/2;
		build(2*idx+1, low, mid);
		build(2*idx+2, mid+1, high);
		seg[idx] = Math.max(seg[2*idx+1], seg[2*idx+2]);
	}
    
    private static int query(int idx, int low, int high, int l, int r) {
    	if (low>=l && high<=r) return seg[idx];
    	
    	if (low>r || high <l) return Integer.MIN_VALUE;
    	
    	int mid = low + (high-low)/2;
    	
    	return Math.max(query(2*idx+1,low, mid, l,r), query(2*idx+2, mid+1, high, l, r));
    }

	static final Random random = new Random();

    static void sort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int val = random.nextInt(n);
            int cur = a[i];
            a[i] = a[val];
            a[val] = cur;
        }
        Arrays.sort(a);
    }

    static void sortl(long[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int val = random.nextInt(n);
            long cur = a[i];
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
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArray(int n) {
            int[] a = new int[n];
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
