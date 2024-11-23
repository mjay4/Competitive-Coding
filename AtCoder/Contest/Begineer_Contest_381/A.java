import java.io.*;
import java.util.*;

public class A {
	public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt(); 
        String s = sc.nextLine();
        
        if (n%2 == 0) {
        	System.out.println("No");
        } else {
        	boolean flag = true;
        	for(int i =0; i<n; i++) {
        		if (i < n/2) {
        			if (s.charAt(i) != '1') {
        				flag = false;
        				break;
        			}
        		} else if (i == n/2) {
        			if (s.charAt(i)!= '/') {
        				flag = false;
        				break;
        			}
        		} else {
        			if (s.charAt(i)!= '2') {
        				flag = false;
        				break;
        			}
        		}
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
