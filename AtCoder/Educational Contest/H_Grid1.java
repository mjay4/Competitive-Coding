import java.io.*;
import java.util.*;

public class H_Grid1 {
    static long mod = (long)1e9+7;
    public static void main(String[] args) {

        FastScanner sc = new FastScanner();
        int h = sc.nextInt();
        int w = sc.nextInt();
        long[][] dp = new long[h+1][w+1];
        char ch[][] = new char[h][w];
        for(int i = 0; i<h;i++){
            ch[i] = sc.next().toCharArray();
        }

        for(int i = 0; i<h; i++)
            if(ch[i][0]=='#')
                break;
            else
                dp[i][0] = 1;

        for (int i = 0; i < w; i++)
            if (ch[0][i] == '#')
                break;
            else
                dp[0][i] = 1;

        for(int i = 1;i<h;i++){
            for(int j = 1; j<w;j++){
                if(ch[i][j]=='#')
                    dp[i][j]=0;
                else    
                    dp[i][j] = dp[i-1][j]+dp[i][j-1];
                dp[i][j]%=mod;
            }
        }
        System.out.println(dp[h-1][w-1]);
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
