import java.util.*;

public class Remove_Smallest{
	public static void main(String args[]){
     	Scanner sc = new Scanner(System.in);
      	int t = sc.nextInt();
      	while(t-->0) {
      		int n = sc.nextInt();
      		int ar[] = new int[n];
      		for(int i = 0;i<n;i++)
      		{
      			ar[i] = sc.nextInt();
      		}
      		Arrays.parallelSort(ar);
      		boolean flag = false;
      		for(int i =0;i<n-1;i++) {
      			if(ar[i+1] - ar[i] > 1)
      				flag = true;
      		}
      		if(flag)
      			System.out.println("NO");
      		else
      			System.out.println("YES");
      	}
      	
	}
}
