import java.io.*;
import java.util.*;

public class Helpful_Maths {
    static long mod = (long) 1e7 + 7;

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = 1;
        // t = sc.nextInt();
        while (t-- > 0) {
            char ch[] = sc.next().toCharArray();
            int ott[] = new int[3];
            for (int i = 0; i < ch.length; i += 2) {
                if (ch[i] == '1')
                    ott[0]++;
                else if (ch[i] == '2')
                    ott[1]++;
                else
                    ott[2]++;
            }
            for (int i = 0; i < ch.length; i += 2) {
                if (ott[0]-- > 0) {
                    ch[i] = '1';
                } else if (ott[1]-- > 0) {
                    ch[i] = '2';
                } else {
                    ch[i] = '3';
                }
            }
            for (char c : ch) {
                System.out.print(c);
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
