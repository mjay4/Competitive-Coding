import java.io.*;
import java.util.*;

public class Putting_Bricks {
    public static long mod = 1000000007;

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int ar[][] = new int[n][n];
            for (int i = 0; i < n; i++) {
                char ch[] = sc.next().toCharArray();
                for (int j = 0; j < n; j++)
                    ar[i][j] = ch[j] - '0';
            }

            if (ar[0][1] == ar[1][0]) {
                if (ar[n - 1][n - 2] == ar[n - 2][n - 1]) {
                    if (ar[0][1] == ar[n - 1][n - 2]) {
                        System.out.println(2);
                        System.out.println(n + " " + (n - 1));
                        System.out.println((n - 1) + " " + n);
                    } else {
                        System.out.println(0);
                    }
                } else {
                    if (ar[0][1] == ar[n - 1][n - 2]) {
                        System.out.println(1);
                        System.out.println(n + " " + (n - 1));
                    } else {
                        System.out.println(1);
                        System.out.println((n - 1) + " " + (n));
                    }
                }
            } else {
                if (ar[n - 1][n - 2] == ar[n - 2][n - 1]) {
                    if (ar[0][1] == ar[n - 1][n - 2]) {
                        System.out.println(1);
                        System.out.println(1 + " " + 2);
                    } else {
                        System.out.println(1);
                        System.out.println(2 + " " + 1);
                    }
                } else {

                    System.out.println(2);
                    if (ar[0][1] == 0)
                        System.out.println(1 + " " + 2);
                    else
                        System.out.println(2 + " " + 1);
                    if (ar[n - 1][n - 2] == 1)
                        System.out.println(n + " " + (n - 1));
                    else
                        System.out.println((n - 1) + " " + n);

                }
            }
        }
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
