package Beginner_Contest_183;

import java.io.*;
import java.util.*;

public class Water_Heater {
    static int mod = (int) 1e6 + 7;

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        long n = sc.nextLong();
        long w = sc.nextLong();
        long water[][] = new long[(int) n][3];
        for (int i = 0; i < n; i++) {
            water[i] = sc.readArrayl(3);
        }
        long max = 0;
        long ans[] = new long[mod];
        for (int i = 0; i < n; i++) {
            // System.out.println(max+" "+water[i][1]);
            ans[(int) water[i][0]] += water[i][2];
            ans[(int) water[i][1]] -= water[i][2];
            max = Math.max(max, water[i][1]);

        }
        boolean flag = true;
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i] + ans[i - 1];

            // System.out.println(i+" "+ans[i]);
            if (ans[i] > w) {
                flag = false;
                break;
            }
        }
        if (ans[0] > w)
            flag = false;
        System.out.println((flag) ? "Yes" : "No");

    }

    static final Random random = new Random();

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
        }
        for (int i = 0; i < r; i++) {
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

        long[] readArrayl(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++)
                a[i] = nextLong();
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
