import java.io.*;
import java.util.*;

public class C {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt(); 
        String s = sc.nextLine();
        int ans = 1;
        
        List<Integer> list = new ArrayList<>();
        
        for (int i =0; i<n; i++) {
            if (s.charAt(i) == '/') {
                list.add(i);
            }
        }
        
        for (int i=0; i<list.size(); i++) {
            int val = list.get(i);
            int count = 1;
            for (int j = 1; val - j >= 0 && val + j < n; j++) {
                if (s.charAt(val-j) != '1') break;          
                if (s.charAt(val+j) != '2') break;
                
                count +=2;
            }
            ans = Math.max(ans, count);
        }
        System.out.print(ans);
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

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }
    }

}
