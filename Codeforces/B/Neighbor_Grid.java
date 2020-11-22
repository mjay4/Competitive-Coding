import java.io.*;
import java.util.*;

public class Neighbor_Grid {

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int ar[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                ar[i] = sc.readArray(m);
            }
            boolean possible = true;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int count = 0;
                    if (i > 0)
                        count++;
                    if (i < n - 1)
                        count++;
                    if (j > 0)
                        count++;
                    if (j < m - 1)
                        count++;

                    if (count < ar[i][j])
                        possible = false;
                    if (!possible)
                        break;
                }
            }
            if (possible) {
                System.out.println("Yes");
                for (int i = 1; i < n - 1; i++) {
                    for (int j = 1; j < m - 1; j++) {
                        ar[i][j] = 4;
                    }
                }
                ar[0][0] = ar[n - 1][0] = ar[0][m - 1] = ar[n - 1][m - 1] = 2;
                for (int i = 1; i < n - 1; i++) {
                    ar[i][0] = 3;
                    ar[i][m - 1] = 3;
                }
                for (int i = 1; i < m - 1; i++) {
                    ar[0][i] = 3;
                    ar[n - 1][i] = 3;
                }

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        System.out.print(ar[i][j] + " ");
                    }
                    System.out.println();
                }
            } else {
                System.out.println("NO");
            }
        }
    }

    // Till 1e7+7 is feasible to use prime();
    static boolean[] prime(int n) {
        boolean isPrime[] = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i])
                for (int j = i + i; j <= n; j += i) {
                    isPrime[j] = false;
                }
        }
        return isPrime;
    }

    public static int rev(int cur) {
        int val = 0;
        while (cur > 0) {
            val *= 10;
            val += cur % 10;
            cur /= 10;
        }
        return val;
    }

    public static long minMax(long cur) {
        long min = 10;
        long max = 0;
        while (cur > 0) {
            long rem = cur % 10;
            min = Math.min(rem, min);
            max = Math.max(max, rem);
            cur /= 10;
        }
        return min * max;
    }

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
            ans /= (i + 1);
        }
        return ans;
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

        long[] readArrayl(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++)
                a[i] = nextLong();
            return a;
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
