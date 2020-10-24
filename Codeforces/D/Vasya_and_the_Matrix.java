import java.io.*;
import java.util.*;

public class Vasya_and_the_Matrix {
    static long mod = (long) 1e9 + 7;

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int ar[] = sc.readArray(n);
        int br[] = sc.readArray(m);
        int xor = 0;
        for (int i : ar)
            xor ^= i;
        for (int i : br)
            xor ^= i;
        if (xor != 0)
            System.out.println("NO");
        else {
            System.out.println("YES");
            xor = ar[0];
            for (int i = 1; i < m; i++)
                xor ^= br[i];
            System.out.print(xor + " ");
            for (int i = 1; i < m; i++)
                System.out.print(br[i] + " ");
            System.out.println();
            for (int i = 1; i < n; i++) {
                System.out.print(ar[i] + " ");
                for (int j = 1; j < m; j++)
                    System.out.print("0" + " ");
                System.out.println();
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
