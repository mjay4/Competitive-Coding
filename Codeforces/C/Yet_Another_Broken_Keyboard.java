import java.io.*;
import java.util.*;

public class Yet_Another_Broken_Keyboard {
	public static boolean[] isPrime;
	
	public static void main(String[] args) {
		FastScanner sc=new FastScanner();
		long n = sc.nextLong();
		long k = sc.nextLong();
		char ch[] = sc.next().toCharArray();
		Set<Character> canUse = new HashSet<>();
		for(int i = 0; i<k; i++) {
			canUse.add(sc.next().charAt(0));
		}
		int i = 0;
		long ans = 0;
		while(i<n) {
			int j = i;
			while(j<n && canUse.contains(ch[j])){
				j++;
			}
			long len = j*1l-(i*1l);
			ans+=(len*(len+1))/2; 
			i=j;
			i++;
		}
		
		System.out.println(ans);
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
