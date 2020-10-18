import java.io.*;
import java.util.*;

public class Random_Teams {
    public static long mod = 1000000007;

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        long n = sc.nextInt();
        long t = sc.nextInt();
        long max = max(n - t);
        long min = min(n, t);
        System.out.println(min + " " + max);
    }

    public static long max(long n) {
        if (n % 2 == 0) {
            return (n / 2) * (n + 1);
        }
        return n * ((n + 1) / 2);
    }

    public static long min(long n, long t) {
        long div = t * max((n / t) - 1);
        long rem = (n % t) * ((n / t));
        return div + rem;
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
