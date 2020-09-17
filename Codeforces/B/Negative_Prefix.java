import java.io.*;
import java.util.*;

public class Negative_Prefix {
	
	public static void main(String[] args) {
		FastScanner sc=new FastScanner();
        int T=sc.nextInt();
        
		for (int tt=0; tt<T; tt++) {
            int n = sc.nextInt();
            int ar[] = sc.readArray(n);
            int lock[] = sc.readArray(n);
            int ans[] = new int[n];
            List<Integer> toSort = new ArrayList<>();
            for(int i =0;i<n;i++){
                if(lock[i] == 0)
                    toSort.add(ar[i]);
                else    
                    ans[i] = ar[i];
            }
            if(toSort==null || toSort.size()==0){
                printar(ar);
            }else{
                Collections.sort(toSort, Collections.reverseOrder());
                int count = 0;
                for (int i = 0; i < n; i++) {
                    if (lock[i] == 0)
                        ans[i] = toSort.get(count++);
                }
                printar(ans);
            }

		}
    }
    
    static void printar(int[] a) {
        for (int i : a)
            System.out.print(i + " ");
        System.out.println();
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
