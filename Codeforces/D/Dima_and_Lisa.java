import java.io.*;
import java.util.*;

public class Dima_and_Lisa {

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        int max = n;

        while(true){
            boolean isPrime = true;

            for(int i = 2; i*i<=max; i++){
                if(max%i == 0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime)
                break;
            else
                max--;
        }

        int left = n - max;
        if(left == 0){
            System.out.println(1);
            System.out.println(max);
        }else if(left ==2){
            System.out.println(2);
            System.out.println(2+" "+max);
        }else{
            for(int i = 2; i<=left; i++){
                if(prime(i) && prime(left-i)){
                    System.out.println(3);
                    System.out.println(i+" "+max+" "+(left-i));
                    break;
                }
            }
        }
    }

    static boolean prime(int n){
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
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
