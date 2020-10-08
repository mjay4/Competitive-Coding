import java.io.*;
import java.util.*;

public class Snow_Footprints {

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        char ch[] = sc.next().toCharArray();
        int s = 0, e = 0;
        int l = 0;
        int r = 0;
        for (char c : ch) {
            if (c == 'L')
                l++;
            if (c == 'R')
                r++;
        }
        if (r == 0 && l > 1) {
            for (int i = 1; i < n; i++) {
                if (ch[i] == 'L' && e == 0) {
                    e = i;
                } else if (ch[i] == 'L') {
                    s = i + 1;
                }
            }
        } else if (r == 0) {
            for (int i = 1; i < n; i++) {
                if (ch[i] == 'L') {
                    e = i;
                    s = i + 1;
                }
            }
        } else if (l == 0 && r > 1) {
            for (int i = 1; i < n; i++) {
                if (ch[i] == 'R' && s == 0) {
                    s = i + 1;
                } else if (ch[i] == 'R') {
                    e = i + 2;
                }
            }
        } else if (l == 0) {
            for (int i = 1; i < n; i++) {
                if (ch[i] == 'R') {
                    s = i + 1;
                    e = i + 2;
                }
            }
        } else {
            for (int i = 1; i < n; i++) {
                if (ch[i] == 'R' && s == 0) {
                    s = i + 1;
                } else if (ch[i] == 'L' && e == 0) {
                    e = i;
                }
            }
        }
        System.out.println(s + " " + e);
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
