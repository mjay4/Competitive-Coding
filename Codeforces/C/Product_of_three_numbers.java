import java.io.*;
import java.util.*;

public class Product_of_three_numbers {
    public static boolean[] isPrime;

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        isPrime = new boolean[1000007];
        fillPrime();
        while (t-- > 0) {
            int n = sc.nextInt();
            if (n < 1000007 && isPrime[n]) {
                System.out.println("NO");
            } else {
                int ar[] = new int[3];
                int i = 0;
                int cur = 2;
                while (i < 2 && cur * cur <= n) {
                    if (n % cur == 0) {
                        // System.out.println(ar[i]);
                        ar[i++] = cur;

                        n /= cur;
                        // System.out.println(n+" "+ar[i-1]);
                    }
                    cur++;
                }
                if (i == 2) {
                    ar[2] = n;
                }
                // System.out.println();
                if (i == 2 && ar[2] > 1 && ar[2] != ar[1] && ar[2] != ar[0]) {
                    System.out.println("YES");
                    for (int val : ar) {
                        System.out.print(val + " ");
                    }
                    System.out.println();
                } else {
                    System.out.println("NO");
                }
            }
        }
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
