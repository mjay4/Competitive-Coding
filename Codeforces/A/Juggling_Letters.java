import java.io.*;
import java.util.*;

public class Juggling_Letters {
    public static void main(final String[] args) {
        final FastScanner sc = new FastScanner();
        final int T = sc.nextInt();
        for (int tt = 0; tt < T; tt++) {
            final int n = sc.nextInt();
            final int alpha[] = new int[26];
            final String ar[] = new String[n];
            for (int i = 0; i < n; i++) {
                ar[i] = sc.next();
                final char ch[] = ar[i].toCharArray();
                for (int j = 0; j < ch.length; j++) {
                    alpha[ch[j] - 'a']++;
                }
            }
            boolean flag = true;
            for (int i = 0; i < 26; i++) {
                if (alpha[i] % n != 0)
                    flag = false;
            }
            System.out.println(flag ? "YES" : "NO");

        }
    }

    static final Random random = new Random();

    static void sort(final int[] a) {
        final int n = a.length;
        for (int i = 0; i < n; i++) {
            final int val = random.nextInt(n);
            final int cur = a[i];
            a[i] = a[val];
            a[val] = cur;
        }
        Arrays.sort(a);
    }

    static void sortl(final long[] a) {
        final int n = a.length;
        for (int i = 0; i < n; i++) {
            final int val = random.nextInt(n);
            final long cur = a[i];
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
                } catch (final IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (final IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArray(final int n) {
            final int[] a = new int[n];
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
