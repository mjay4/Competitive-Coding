import java.io.*;
import java.util.*;

public class Even_Array {

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int ar[] = sc.readArray(n);
            int odd = 0;
            int even = 0;
            for (int i = 0; i < n; i++) {
                if (ar[i] % 2 == 0) {
                    even++;
                } else if (ar[i] % 2 != 0) {
                    odd++;
                }
            }
            int ans = 0;
            if (even == odd || even == (odd + 1)) {
                for (int i = 0; i < n; i += 2) {
                    if (ar[i] % 2 != 0) {
                        ans++;
                    }
                }
                System.out.println(ans);
            } else {
                System.out.println(-1);
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
