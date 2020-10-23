import java.io.*;
import java.util.*;

public class Dreamoon_and_wifi {
	public static boolean[] isPrime;
	public static double ans;
	public static int ques;
	
	public static void main(String[] args) {
		FastScanner sc=new FastScanner();
		char correct[] = sc.next().toCharArray();
		char variable[] = sc.next().toCharArray();
		int loc = 0;
		ques = 0;
		ans =0;
		for(char ch : correct) {
			if(ch=='+')
				loc++;
			else
				loc--;
		}
		for(char ch : variable) {
			if(ch=='?')
				ques++;
		}
		calculate(variable,0,0,loc);
		System.out.println(ans/(1<<ques));
	}
	
	public static void calculate(char[] c, int idx, int sum, int total) {
		if(c.length == idx && total == sum)
			ans++;
		else {
			if(c.length == idx)
				return;
			if(c[idx] == '+') {
				sum++;
				calculate(c,idx+1,sum,total);
			}else if(c[idx] == '-') {
				sum--;
				calculate(c,idx+1,sum,total);
			}else {
				calculate(c,idx+1,sum+1,total);
				calculate(c,idx+1,sum-1,total);
			}
		}
	}
	
	public static void fillPrime() {
		int n = 1000007;
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;
		for(int i = 2; i*i<n; i++) {
			if(isPrime[i]) {
				for(int j = i*i; j<n; j+=i) {
					isPrime[j] = false;
				}
			}
		}
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
