package Beginner_Contest_183;

import java.io.*;
import java.util.*;

public class Travel {
    public static long mod = 1000000007;
    static long[][] dist;
    public static long k;
    public static int count;

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        k = sc.nextLong();
        dist = new long[n][n];
        for (int i = 0; i < n; i++) {
            dist[i] = sc.readArrayl(n);
        }
        count = 0;
        for (int i = 1; i < n; i++) {
            boolean[] visited = new boolean[n];
            visited[0] = true;
            visited[i] = true;
            calc(i, 2, dist[0][i], visited, n);
        }
        System.out.println(count);
    }

    public static void calc(int cur, int num, long sum, boolean[] visited, int n) {
        if (num == n) {
            // System.out.println(num);
            if (sum + dist[cur][0] == k)
                count++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                calc(i, num + 1, sum + dist[cur][i], visited, n);
                visited[i] = false;
            }
        }
        return;
    }

    static boolean[] SeiveOfEratoSthenes(int n) {
        boolean isPrime[] = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i])
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
        }
        return isPrime;
    }

    static final Random random = new Random();

    public static long npr(int n, int r) {
        long ans = 1;
        for (int i = 0; i < r; i++) {
            ans *= (n - i);
        }
        return ans;
    }

    public static double ncr(int n, int r) {
        double ans = 1;
        for (int i = 0; i < r; i++) {
            ans *= (n - i);
        }
        for (int i = 0; i < r; i++) {
            ans /= (i + 1);
        }
        return ans;
    }

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

        long[] readArrayl(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++)
                a[i] = nextLong();
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
