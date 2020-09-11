import java.io.*;
import java.util.*;

public class String_Task {
	
	public static void main(String[] args) {
		FastScanner sc=new FastScanner();
		HashSet<Character> set = new HashSet<Character>();
		set.add('A');
		set.add('O');
		set.add('Y');
		set.add('E');
		set.add('U');
		set.add('I');
		set.add('a');
		set.add('o');
		set.add('y');
		set.add('e');
		set.add('u');
		set.add('i');
		String s = sc.next();
		StringBuilder sb = new StringBuilder();
		for(char c : s.toCharArray()) {
			if(set.contains(c))
				continue;
			else {
				if(c-'a'<0) {
					sb.append(".");
					sb.append((char)(c+32));
				}else {
					sb.append(".");
					sb.append(c);
				}
			}
		}
		System.out.println(sb.toString());
	}
	
	static final Random random = new Random();
	
	static void sort(int[] a) {
		int n = a.length;
		for(int i =0; i<n; i++) {
			int val = random.nextInt(n);
			int cur = a[i];
			a[i] = a[val];
			a[val] = cur;
		}
		Arrays.sort(a);
	}
	
	static void sortl(long[] a) {
		int n = a.length;
		for(int i =0; i<n; i++) {
			int val = random.nextInt(n);
			long cur = a[i];
			a[i] = a[val];
			a[val] = cur;
		}
		Arrays.sort(a);
	}
	
	static class FastScanner {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer("");
		String next() {
			while (st == null  || !st.hasMoreTokens()) {
				try {
					st=new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		String nextLine() { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
		} 
		int nextInt() {
			return Integer.parseInt(next());
		}
		int[] readArray(int n) {
			int[] a=new int[n];
			for (int i=0; i<n; i++) a[i]=nextInt();
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
