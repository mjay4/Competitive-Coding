import java.io.*;
import java.util.*;

public class GCD_Compression {
    // Not my code but liked the idea behind this.
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            List<Integer>[] l = new ArrayList[2];
            // Store all the indexed of the even elements at l[0] and odd at l[1].
            l[0] = new ArrayList<>();
            l[1] = new ArrayList<>();
            for (int i = 0; i < n * 2; i++) {
                int a = sc.nextInt();
                // Very intuitive way of adding the indexes at their respective places.
                l[a & 1].add(i);
            }
            // k makes sure we don't get more than n-1 elements and that is the final trick.
            int k = 0;
            for (int i = 0; i + 1 < l[0].size() && k < n - 1; i += 2, k++) {
                System.out.println((l[0].get(i) + 1) + " " + (l[0].get(i + 1) + 1));
            }
            for (int i = 0; i + 1 < l[1].size() && k < n - 1; i += 2, k++) {
                System.out.println((l[1].get(i) + 1) + " " + (l[1].get(i + 1) + 1));
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
