import java.io.*;
import java.util.*;

public class Ice_Skating {

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        // Not my solution but the implementation was really good so I have take it.

        int n = sc.nextInt();
        
        Map<Integer, HashSet<int[]>> yMap = new HashMap<>();
        Map<Integer, HashSet<int[]>> xMap = new HashMap<>();
        // xMap -> stores all the pairs having x value.
        // yMap -> stores all the pairs having y value.

        Set<int[]> pair = new HashSet<>();

        while(n-->0){
            int[] ar = new int[2];
            ar[0] = sc.nextInt();
            ar[1] = sc.nextInt();
            xMap.computeIfAbsent(ar[0], k-> new HashSet<>());
            yMap.computeIfAbsent(ar[1], k-> new HashSet<>());
            /*
             * Difference between computeIfAbsent and putIfAbsent :

             * In compute if absent : 
                if (map.get("key") == null) { 
                    map.put("key",new ValueClass()); 
                }
              
             * In PutIfAbsent : 
                ValueClass value = new ValueClass(); 
                if (map.get("key") == null) { 
                    map.put("key",value); 
                } 
             
                ComputeIfAbsent is faster then putIfAbsent and it is more efficient because we are not creating new variables everytime we are calling.
            */

            xMap.get(ar[0]).add(ar);
            yMap.get(ar[1]).add(ar);

            pair.add(ar);
        }

        int ans = -1;
        HashSet<int[]> visited = new HashSet<>();
        // Stores the already computed pairs.

        for(int[] ar: pair){
            if(!visited.contains(ar)){
                ans++;
                visitAll(ar, visited,xMap,yMap);
            }
        }
        out.println(ans);
        out.close();
    }

    // visit all -> a dfs funcition to visit all the values having same x and y values.
    static void visitAll(int[] ar, HashSet<int[]> visited, Map<Integer, HashSet<int[]>> xMap, Map<Integer, HashSet<int[]>> yMap){

        for(int[] pair : xMap.get(ar[0])){
            if(!visited.contains(pair)){
                visited.add(pair);
                visitAll(pair, visited, xMap, yMap);
            }
        }

        for (int[] pair : yMap.get(ar[1])) {
            if (!visited.contains(pair)) {
                visited.add(pair);
                visitAll(pair, visited, xMap, yMap);
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
