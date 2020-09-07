import java.io.*;
import java.util.*;

public class C_Vacation {

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        int ar[][] = new int[n][3];
        for(int i = 0; i<n;i++){
            ar[i][0] = sc.nextInt();
            ar[i][1] = sc.nextInt();
            ar[i][2] = sc.nextInt();
        }
        for(int i =1; i<n;i++){
            ar[i][0]+= Math.max(ar[i-1][1],ar[i-1][2]);
            ar[i][1] += Math.max(ar[i - 1][0], ar[i - 1][2]);
            ar[i][2] += Math.max(ar[i - 1][1], ar[i - 1][0]);
        }
        int c = Math.max(ar[n-1][1],ar[n-1][2]);
        System.out.println(Math.max(ar[n-1][0],c));
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
