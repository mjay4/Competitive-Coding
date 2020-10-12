import java.io.*;
import java.util.*;

public class Vanya_and_Computer_game {
    static long mod = (long) 1e9 + 7;

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        List<String> ans = new ArrayList<>();
        int ar[] = sc.readArray(n);
        int countx = 0, county = 0;
        for (long i = 0; i < x + 1l + y; i++) {
            if (((countx + 1.0) / x) > ((county + 1.0) / y)) {
                ans.add("Vova");
                county++;
            } else if (((countx + 1.0) / x) < ((county + 1.0) / y)) {
                ans.add("Vanya");
                countx++;
            } else {
                ans.add("Both");
                ans.add("Both");
                countx++;
                county++;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(ans.get((int) ((ar[i] - 1) % (0l + x + y))));
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
