import java.io.*;
import java.util.*;

public class G_Longest_Path {

    public static void main(final String[] args) {
        final FastScanner sc = new FastScanner();
        final int n = sc.nextInt();
        final int m = sc.nextInt();
        final HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i <= n; i++)
            map.put(i,new ArrayList<>());
        for (int i = 0; i < m; i++) {
            final int key = sc.nextInt();
            List<Integer> temp = new ArrayList<>();
            temp = map.get(key);
            temp.add(sc.nextInt());
            map.put(key, temp);
        }
        // for(Map.Entry<Integer,List<Integer>> entry : map.entrySet()){
        //     System.out.println(entry.getKey() +" " + entry.getValue());
        // }
        final int val[] = new int[n + 1];
        Arrays.fill(val, -1);
        int max = 0;
        // Do the bfs and calculate.
        // Use val to not compute bfs for same node again and again.
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, dfs(i, val, map, 0));
        }
        // for(int i : val){
        //     System.out.print(i+" ");
        // }
        // System.out.println();
        System.out.println(max);
    }

    public static int dfs(int key,int[] val, HashMap<Integer, List<Integer>> map, int sum){
        if(val[key]!=-1)
            return sum+val[key];
        int ans = 0;
        List<Integer> reachable = map.get(key);
        if(reachable == null || reachable.size()== 0){
            return val[key] = 0;
        }for(int i : reachable){
            ans= Math.max(ans,dfs(i,val,map,sum)+1);
        }
        return val[key] = ans+sum;
    }

    static final Random random = new Random();

    static void sort(final int[] a) {
        final int n = a.length;
        for (int i = 0; i < n; i++) {
            final int val = random.nextInt(n);
            final int cur = a[i];
            a[i] = a[val];
            a[val] = cur;
        }
        Arrays.sort(a);
    }

    static void sortl(final long[] a) {
        final int n = a.length;
        for (int i = 0; i < n; i++) {
            final int val = random.nextInt(n);
            final long cur = a[i];
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
                } catch (final IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (final IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArray(final int n) {
            final int[] a = new int[n];
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
