import java.io.*;
import java.util.*;

public class Array_Restoration {

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int T = sc.nextInt();
        for (int tt = 0; tt < T; tt++) {
            int n = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
             
            int min = Integer.MAX_VALUE;
            int ar[] = null;

            for(int i = 1; i<=50 ;i++){
                for(int j = 1; j<=50; j++){
                    int a[] = gen(n,i,j);
                    boolean x_flag = false;
                    boolean y_flag = false;
                    for(int k :a){
                        if(k==x)
                            x_flag = true;
                        if(k==y)
                            y_flag = true;
                    }


                    if(x_flag && y_flag && a[n-1] <min){
                        min = a[n-1];
                        ar=a;
                    }
                }
            }

            for (int i : ar)
                System.out.print(i+" ");
            System.out.println();
        }
    }

    public static int[] gen(int size, int start, int diff){
        int ar[] = new int[size];
        ar[0] = start;
        for(int i =1; i<size;i++){
            ar[i] = ar[i-1] + diff;
        }
        return ar;
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
