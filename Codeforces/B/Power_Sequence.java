import java.io.*;
import java.util.*;

public class Power_Sequence {   
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        long ar[] = new long[n];
        for (int i = 0; i < n; i++) {
            ar[i] = sc.nextLong();
        }
        long ans = Long.MAX_VALUE;
        sortl(ar);

        long big = (long) 1e15;
        long c = 1;
        while (true) {
            long val = 0, pow = 1;
            boolean flag = false;
            // Using Math.pow is really bad idea.
            // It will increase the time complexity a lot.
            for (int i = 0; i < n; i++, pow *= c) {
                if (pow >= big) {
                    flag = true;
                    break;
                }
                val += Math.abs(pow - ar[i]);
            }
            if (flag)
                break;
            ans = Math.min(ans, val);
            c++;
            // c will never be a very large value, this is the trick to solve this question.
        }

        // for(int j = 1; j<=1000000; j++) {
        // double ans2 = 0;
        //
        // for(int i = 0; i<n; i++) {
        //
        // double val = Math.pow(j,i);
        // ans2+= Math.abs(val-ar[i]);
        //
        // }
        // ans = Math.min(ans,(long)ans2);
        // }
        System.out.println(ans);
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
