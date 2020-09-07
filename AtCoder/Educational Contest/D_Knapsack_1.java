import java.io.*;
import java.util.*;

public class D_Knapsack_1 {

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        int W = sc.nextInt();
        int v[] = new int[n];
        int w[] = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }
        long dp[][] = new long[n + 1][W + 1];
        for (long i[] : dp) {
            Arrays.fill(i, -1);
        }
    
        long ans = knapsack(n, v, w, W,dp);
    
        System.out.println(ans);
    }

    private static long knapsack(int n, int[] v, int[] w, int w2, long[][] dp) {
        if (w2 == 0 || n==0)
            return 0;
        if(dp[n][w2] != -1)
            return dp[n][w2];    
        if (w[n-1] <= w2)
            return dp[n][w2] = Math.max(v[n-1] + knapsack(n-1, v, w, w2-w[n-1], dp), knapsack(n-1, v, w, w2, dp));

        return dp[n][w2] = knapsack(n-1, v, w, w2,dp);
    }

    private static long knapsack_brute(int i, long sum, int[] v, int[] w, int w2) {
        if (w2 < 0)
            return 0;
        if (i == v.length || w2 == 0)
            return sum;

        return Math.max(knapsack_brute(i + 1, sum + v[i], v, w, w2 - w[i]), knapsack_brute(i + 1, sum, v, w, w2));
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
