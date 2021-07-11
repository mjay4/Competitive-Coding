import java.io.*;
import java.util.*;

public class Taxi {
    public static boolean[] isPrime;

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        //int T=sc.nextInt();
        int T = 1;
        for (int tt = 0; tt < T; tt++) {
            int n = sc.nextInt();
            int ar[] = sc.readArray(n);
            sort(ar);
            int ans = 0;
            int count;
            for (int i = ar.length - 1, j = 0; j <= i;) {
                ans++;
                count = 4;
                while (i >= j && count - ar[i] >= 0) {
                    count-=ar[i];
                    i--;
                }
                while (i >= j && count - ar[j] >= 0) {
                    count-=ar[j];
                    j++;
                }
            }
            System.out.println(ans);
        }
    }

    public static long npr(int n, int r) {
        long ans = 1;
        for (int i = 0; i < r; i++) {
            ans *= (n - i);
        }
        return ans;
    }

    public static double ncr(int n, int r) {
        double ans = 1;
        for (int i = 0; i < r; i++) {
            ans *= (n - i);
        }
        for (int i = 0; i < r; i++) {
            ans /= (i + 1);
        }
        return ans;
    }

    public static void fillPrime() {
        int n = 1000007;
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
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
            for (int i = 0; i < n; i++) a[i] = nextInt();
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
