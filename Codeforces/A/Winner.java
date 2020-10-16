import java.io.*;
import java.util.*;

public class Winner {

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        Map<String, Integer> map = new HashMap<>();
        int max = 0;
        List<Integer> scores = new ArrayList<>();
        List<String> names = new ArrayList<>();
        while (n-- > 0) {
            String s = sc.next();
            names.add(s);
            int val = sc.nextInt();
            scores.add(val);
            // System.out.println(s+" "+val);
            map.put(s, map.getOrDefault(s, 0) + val);
        }
        for (String s : map.keySet()) {
            if (map.get(s) > max) {
                max = map.get(s);
            }
        }

        Map<String, Integer> preCnt = new HashMap<>(map);
        map.clear();
        for (int i = 0; i < names.size(); i++) {
            String name = names.get(i);
            int score = scores.get(i);
            map.put(name, map.getOrDefault(name, 0) + score);
            if (map.get(name) >= max && preCnt.get(name) == max) {
                System.out.println(name);
                break;
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
