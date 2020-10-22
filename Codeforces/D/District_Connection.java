import java.io.*;
import java.util.*;

public class District_Connection {
    static long mod = (long) 1e9 + 7;

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int ar[] = sc.readArray(n);
            Set<Integer> set = new HashSet<>();
            for (int i : ar)
                set.add(i);
            if (set.size() == 1)
                System.out.println("NO");
            else {
                int from = 0;
                List<Integer> notVisited = new ArrayList<>();
                System.out.println("YES");
                for (int i = 1; i < n; i++) {
                    if (ar[0] != ar[i]) {
                        System.out.println("1 " + (i + 1));
                        from = i + 1;
                    } else {
                        notVisited.add(i + 1);
                    }
                }
                for (int visit : notVisited) {
                    System.out.println(from + " " + visit);
                }
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
