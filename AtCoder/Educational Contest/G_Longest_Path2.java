import java.io.*;
import java.util.*;

public class G_Longest_Path2 {
    static List<Integer>[] ar;
    public static void main(final String[] args) {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        int m = sc.nextInt();
        ar = new ArrayList[n];
        for (int i = 0; i < n; i++)
            ar[i] = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int key = sc.nextInt();
            int val = sc.nextInt();
            ar[key - 1].add(val-1);
        }

        int val[] = new int[n];
        Arrays.fill(val, -1);
        int max = 0;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, dfs(i, val, ar, 0));
        }
        System.out.println(max);
    }

    public static int dfs(int key,int[] val,List<Integer>[] ar,int sum) {
        if (val[key] != -1)
            return sum + val[key];
        int ans = 0;

        if (ar[key] == null || ar[key].size() == 0) {
            return val[key] = 0;
        }
        for (int i : ar[key]) {
            ans= Math.max(ans,dfs(i,val,ar,sum)+1);
        }
        return val[key] = ans+sum;
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
