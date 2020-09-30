import java.io.*;
import java.util.*;

public class Number_Game {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            String win = "Ashishgup", lose = "FastestFinger";
            if (n == 1) {
                System.out.println(lose);
            } else if (n == 2 || n % 2 == 1) {
                System.out.println(win);
            } else {
                // power of two = lose || prime*2 -> lose
                // To see the power of 2 = Integer.bitCount(n) returns the number of set bit.
                if (Integer.bitCount(n) == 1 || isprime(n / 2)) {
                    System.out.println(lose);
                } else {
                    System.out.println(win);
                }
            }
        }
    }

    static boolean isprime(int n) {
        for (int i = 2; i * i <= n; i++)
            if (n % i == 0)
                return false;
        return true;
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
