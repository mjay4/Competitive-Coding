import java.io.*;
import java.util.*;

public class Vanya_and_Exams {

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        long max = sc.nextLong();
        long avg = sc.nextLong();
        int ar[][] = new int[n][2];
        long marks = 0;
        for (int i = 0; i < n; i++) {
            ar[i] = sc.readArray(2);
            marks += ar[i][0];
        }
        Arrays.sort(ar, (a, b) -> (a[1] - b[1]));
        long req = avg * n - marks;
        if (req <= 0) {
            System.out.println(0);
        } else {
            long count = 0;
            for (int i = 0; i < n; i++) {
                long dif = max - ar[i][0];
                if (dif < req) {
                    req -= dif;
                    count += dif * ar[i][1];
                } else {
                    count += req * ar[i][1];
                    break;
                }
            }
            System.out.println(count);
        }
    }

    static boolean isprime(int n) {
        for (int i = 2; i * i <= n; i++)
            if (n % i == 0)
                return false;
        return true;
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
