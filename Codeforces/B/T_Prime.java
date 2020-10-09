import java.io.*;
import java.util.*;

public class T_Prime {
    public static boolean cache[];

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int T = sc.nextInt();
        List<Long> ar = new ArrayList<>();
        for (int i = 0; i < T; i++) {
            ar.add(sc.nextLong());
        }
        cache = new boolean[1000009];
        Arrays.fill(cache, true);
        cache[1] = false;
        fill();
        for (int i = 0; i < T; i++) {
            if (!Perfectsq(ar.get(i))) {
                System.out.println("NO");
            } else if (cache[(int) Math.sqrt(ar.get(i))]) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

    }

    public static boolean Perfectsq(Long val) {
        double d = Math.sqrt(val);
        return (d - ((int) Math.sqrt(val)) == 0);
    }

    public static void fill() {
        for (int i = 2; i * i < 1000009; i++) {
            for (int j = i + i; j < 1000009; j += i) {
                cache[j] = false;
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
