import java.io.*;
import java.util.*;

public class Metal_Harvest {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int T = sc.nextInt();
        for (int tt = 1; tt <= T; tt++) {
            int count = 1;
            int n = sc.nextInt();
            int k = sc.nextInt();
            int ar[][] = new int[n][2];
            for (int i = 0; i < n; i++) {
                ar[i] = sc.readArray(2);
            }
            Arrays.sort(ar, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
            int i = 0;
            int start = ar[i][0];
            while (i < n) {
                if (start + k <= ar[i][0]) {
                    count++;
                    start = ar[i][0];
                }
                int low = start + k;
                int high = ar[i][1];
                if (low < high) {
                    int temp = (high - low + k - 1) / k;
                    count += temp;
                    start += temp * k;
                }

                i++;
            }
            System.out.println("Case #" + tt + ": " + count);
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
