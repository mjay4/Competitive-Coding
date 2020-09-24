import java.io.*;
import java.util.*;

public class Princess_And_Princes {

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int T = sc.nextInt();
        while(T-->0){
            int n = sc.nextInt();
            /* Non-optimal solution.

            HashSet<Integer> set = new HashSet<>();
            int ar[] = new int[n];
            for(int i = 0; i<n; i++){
                int count = sc.nextInt();
                int min = Integer.MAX_VALUE;
                while(count-->0){
                    int val = sc.nextInt();
                    if(set.contains(val))
                        continue;
                    min = Math.min(min,val);
                }
                if(min == Integer.MAX_VALUE){
                    ar[i] = -1;
                }else{
                    set.add(min);
                    ar[i] = min;
                }
            }
            int available=0;

            for(int i =1; i<=n; i++){
                if(!set.contains(i)){
                    available = i;
                    break;
                }
            }
            if(available==0){
                System.out.println("OPTIMAL");
            }else{
                System.out.println("IMPROVE");
                for(int i=0; i<ar.length; i++){
                    if(ar[i]==-1){
                        System.out.println(i+1+" "+available);
                        break;
                    }
                }
            }
            */


            // Optimal solution

            HashSet<Integer> set = new HashSet<>();
            int q = -1;
            for (int i = 1; i <= n; i++) {
                int k = sc.nextInt();
                boolean flag = false;
               while(k-->0) {
                    int temp = sc.nextInt();

                    if (!set.contains(temp) && !flag) {
                        flag = true;
                        set.add(temp);
                    }
                }
                if (!flag && q == -1) {
                    q = i;
                }
            }
            if(q == -1){
                System.out.println("OPTIMAL");
            }else{
                System.out.println("IMPROVE");
                int king = 1;
                while(king<=n){
                    if(!set.contains(king))
                        break;
                    king++;
                }
                System.out.println(q + " " + king);
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
