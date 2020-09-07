import java.io.*;
import java.util.*;

public class Balanced_BitString {

    public static void main(String[] args) {
		FastScanner sc=new FastScanner();
		int T=sc.nextInt();
		for (int tt=0; tt<T; tt++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			char[] ch = sc.next().toCharArray();
			int one =0;
			int zero = 0;
			boolean flag = true;
            /* Slide the window of k variable and observe that
            after every k element, since the number of 1's and 0's are same, 
            we have to make sure that we add and remove the same element.
            */
			for(int i =0;i<k; i++) {
                HashSet<Character> set = new HashSet<>();
                
                for(int j = i; j<n; j+=k){
                    set.add(ch[j]);
                }
                // set cann't have one and zero both.
                if(set.contains('0') && set.contains('1')){
                    flag = false;
                    break;
                }
                if(ch[i] =='0'){
                    zero++;
                }else if(ch[i]=='1'){
                    one++;
                }else{
                    if(set.contains('0')){
                        ch[i] = '0';
                        zero++;
                    }else if(set.contains('1')){
                        ch[i] = '1';
                        one++;
                    }
                }
            }
            
            if(!flag || zero > k/2 || one > k/2){
                System.out.println("NO");
            }else{	    		
                System.out.println("YES");
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
