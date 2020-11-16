package Beginner_Contest_183;

import java.io.*;
import java.util.*;

public class Queen_on_Grid {
    private static long mod = (long) 1e9 + 7;

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int h = sc.nextInt();
        int w = sc.nextInt();
        char grid[][] = new char[h][w];
        for (int i = 0; i < h; i++) {
            grid[i] = sc.next().toCharArray();
        }
        long dp[][] = new long[h + 1][w + 1];
        int[][] hor = new int[h + 1][w + 1];
        int[][] ver = new int[h + 1][w + 1];
        int[][] diag = new int[h + 1][w + 1];
        dp[1][1] = 1;
        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= w; j++) {
                if (grid[i - 1][j - 1] == '.') {
                    dp[i][j] = ver[i - 1][j] + dp[i][j] + hor[i][j - 1] + diag[i - 1][j - 1];
                    dp[i][j] %= mod;
                    ver[i][j] += dp[i][j] + ver[i - 1][j];
                    ver[i][j] %= mod;
                    hor[i][j] += dp[i][j] + hor[i][j - 1];
                    hor[i][j] %= mod;
                    diag[i][j] += dp[i][j] + diag[i - 1][j - 1];
                    diag[i][j] %= mod;
                }
            }
        }

        System.out.println(dp[h][w]);
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
