import java.io.*;
import java.util.*;

public class Count_Triangles {
    public static long mod = (long) 1e9 + 7;;

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        long ans = 0;

        for (int z = c, lo = a, hi = b; z <= d << 1; z++) {
            if (lo + hi > z)
                continue;
            while (hi < c && hi + lo < z)
                hi += 1;
            while (lo < b && hi + lo < z)
                lo += 1;

            if (lo + hi == z)
                ans += 1L * Math.min(b - lo + 1, hi - b + 1) * (Math.min(d + 1, z) - c);
        }

        System.out.println(ans);

    }

    public static long fact(long n) {
        long ans = 1;
        for (long i = 1; i <= n; i++) {
            ans *= i;
            ans %= mod;
        }
        return (long) ans;
    }

    static final Random random = new Random();

    public static long npr(long n, long r) {
        long ans = 1;
        for (int i = 0; i < r; i++) {
            ans *= (n - i);
            ans %= mod;
        }
        return ans;
    }

    public static long ncr(long n, long r) {
        long ans = 1;
        for (int i = 0; i < r; i++) {
            ans *= (n - i);
            ans /= (i + 1);
            ans %= mod;
        }
        return (long) ans % mod;
    }

    public static double ncrd(int n, int r) {
        double ans = 1;
        for (int i = 0; i < r; i++) {
            ans *= (n - i);
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

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }
    }

}
