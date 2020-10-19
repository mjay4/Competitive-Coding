import java.io.*;
import java.util.*;

public class Rotation_Matching {
    public static boolean[] isPrime;

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        int ar[] = sc.readArray(n);
        int br[] = sc.readArray(n);
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i<n; i++){
            if(i==0){
                map.put(ar[i],n);
            }else{
                map.put(ar[i],i);
            }
        }
        Map<Integer,Integer> count = new HashMap<>();
        for(int i =0; i<n; i++){
            int key = map.get(br[i])-i;
            if(key>0)
            count.put(key, count.getOrDefault(key, 0)+1);
            else
            count.put(key+n, count.getOrDefault(key+n, 0) + 1);
        }
        int max = 0;
        for(int i : count.values()){
           // System.out.println(i);
            max = Math.max(max, i);
        }
        System.out.println(max);
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
