import java.util.*;

public class Gifts_Fixed{
	public static void main(String args[]){
     	Scanner sc = new Scanner(System.in);
      	int t = sc.nextInt();
      	while(t-->0) {
      		int n = sc.nextInt();
      		int ar[] = new int[n];
      		int br[] = new int[n];
      		int a = Integer.MAX_VALUE;
      		int b = Integer.MAX_VALUE;
      		for(int i = 0;i<n;i++) {
      			ar[i] = sc.nextInt();
      			a = Math.min(a, ar[i]);
      		}
      		for(int i = 0;i<n;i++) {
      			br[i] = sc.nextInt();
      			b = Math.min(b, br[i]);
      		}
      		long count = 0;
      		for(int i = 0;i<n;i++) {
      			int m1 = ar[i]-a;
      			int m2 = br[i]-b;
      			count+= m1>m2 ? m1 : m2;
      		}
      		System.out.println(count);
      	}
      	
	}
}
