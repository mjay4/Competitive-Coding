import java.io.*;
import java.util.*;

public class Subset_Mex {

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int T = sc.nextInt();
        for (int tt = 0; tt < T; tt++) {
            int n = sc.nextInt();
            int ar[] = new int[106];
            for (int i = 0; i < n; i++) {
                int val = sc.nextInt();
                ar[val]++;
            }
            int ans = 0;

            int count = 0;
            if (ar[0] == 0) {
                System.out.println(0);
            } else {
                for (int i = 0; i < 105; i++) {
                    if (count == 2)
                        break;
                    if (ar[i] == 0) {
                        ans += i;
                        if (count == 0)
                            ans += i;
                        break;
                    }

                    if (ar[i] == 1 && count == 1) {
                        continue;
                    }
                    if (ar[i] == 1) {
                        count++;
                        ans += i;
                    }
                }
                System.out.println(ans);
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
