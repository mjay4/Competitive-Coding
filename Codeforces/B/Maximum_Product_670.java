import java.io.*;
import java.util.*;

public class Maximum_Product_670 {

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int T = sc.nextInt();
        for (int tt = 0; tt < T; tt++) {
            int n = sc.nextInt();
            int ar[] = sc.readArray(n);
            sort(ar);
            long ans = Long.MIN_VALUE;
            long temp = 1L * ar[0] * ar[1] * ar[n - 1] * ar[n - 2] * ar[n - 3] * 1L;
            ans = Math.max(ans, temp);
            temp = 1L * ar[n - 1] * ar[n - 2] * ar[n - 3] * ar[n - 4] * ar[n - 5] * 1L;
            ans = Math.max(ans, temp);
            temp = 1L * ar[n - 1] * ar[2] * ar[3] * ar[1] * ar[0] * 1L;
            ans = Math.max(ans, temp);
            System.out.println(ans);
        }
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
