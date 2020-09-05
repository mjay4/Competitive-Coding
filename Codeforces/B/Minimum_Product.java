import java.io.*;
import java.util.*;

public class Minimum_Product {
    public static void main(final String[] args) {
        final FastScanner sc = new FastScanner();
        final int T = sc.nextInt();
        for (int tt = 0; tt < T; tt++) {
            final int a = sc.nextInt();
            final int b = sc.nextInt();
            final int x = sc.nextInt();
            final int y = sc.nextInt();
            final int n = sc.nextInt();
            System.out.println(Math.min(func(a,x,b,y,n), func(b,y,a,x,n)));
        }
    }
    public static long func(int a, final int x, int b, final int y, int n) {
        final int diff = Math.min(n, a - x);
        n -= diff;
        a -= diff;
        b = Math.max(y, b-n);

        return 1l*a*b;
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
