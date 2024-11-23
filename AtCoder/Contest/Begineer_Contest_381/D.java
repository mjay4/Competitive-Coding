import java.io.*;
import java.util.*;

public class D {
	public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt(); 
        int ar[] = sc.readArray(n);
        int ans = 0;
        
        Set<Integer> set = new HashSet<>();
        int start = 0;
        
        for (int end =0; end<n-1;) {
        	int prev = ar[end];
        	int cur = ar[end+1];
        	
//        	System.out.println(cur + " " + prev);
        	if (cur == prev && !set.contains(cur)) {
//        		System.out.println(cur + " sss : ");
        		set.add(cur);
        		end +=2;
        		ans = Math.max(ans, end-start);
        	} else if(cur == prev && set.contains(cur)) {
        		while (set.contains(cur)) {
        			set.remove(ar[start]);
        			start +=2;
        		}
        		set.add(cur);
        		end +=2;
        		ans = Math.max(ans, end-start);
        	} else {
        		end+=2;
        		set = new HashSet<>();
        		start = end;
        	}
        }
        
        start = 1;
        set = new HashSet<>();
        
        for (int end =1; end<n-1;) {
        	int prev = ar[end];
        	int cur = ar[end+1];
        	
        	if (cur == prev && !set.contains(cur)) {
        		set.add(cur);
        		end +=2;
        		ans = Math.max(ans, end-start);
        	} else if(cur == prev && set.contains(cur)) {
        		while (set.contains(cur)) {
        			set.remove(ar[start]);
        			start +=2;
        		}
        		set.add(cur);
        		end +=2;
        		ans = Math.max(ans, end-start);
        	} else {
        		end+=2;
        		set = new HashSet<>();
        		start = end;
        	}
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
        
        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
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
