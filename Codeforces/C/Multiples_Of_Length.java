import java.io.*;
import java.util.*;

public class Multiples_Of_Length {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        int ar[] = sc.readArray(n);
        if (n == 1) {
            for (int i = 0; i < 2; i++) {
                System.out.println("1 1\n0");
            }
            System.out.println("1 1\n" + (-ar[0]));
        } else {
            System.out.println("1 1");
            System.out.println(-ar[0]);
            ar[0] = 0;
            System.out.println("1 " + n);
            for (int i = 0; i < n; i++) {
                System.out.print(-1l * ar[i] * n + " ");
            }
            System.out.println();
            System.out.println("2 " + n);
            for (int i = 1; i < n; i++) {

                System.out.print(1l * ar[i] * (n - 1) + " ");
            }

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
