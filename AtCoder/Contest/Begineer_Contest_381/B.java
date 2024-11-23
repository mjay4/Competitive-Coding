import java.io.*;
import java.util.*;

public class B {
	public static void main(String[] args) {
        FastScanner sc = new FastScanner();  
        String s = sc.nextLine();
        int n = s.length();
        
        if (n%2 != 0) {
        	System.out.println("No");
        } else {
        	boolean flag = true;
        	Set<Character> set = new HashSet<>();
        	
        	for(int i =0; i<n-1; i+=2) {
        		if (s.charAt(i) != s.charAt(i+1) || set.contains(s.charAt(i))) {
        			flag = false;
        		}
        		set.add(s.charAt(i));
        	}
        	String ans = flag?"Yes":"No";
            System.out.print(ans);
        }      
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
