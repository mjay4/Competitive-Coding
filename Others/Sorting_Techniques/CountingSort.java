package Sorting_Techniques;

import java.util.*;

public class CountingSort{

	public static void main(String args[]){
		Scanner sc= new Scanner(System.in);		
		int n=sc.nextInt();
		int range=sc.nextInt();
		int c[]= new int[range];
		for(int i=0;i<range;++i){
			c[i]=0;
		}
		int a[]= new int[n];
		int b[]= new int[n];
		for(int i=0; i<n; i++){
			a[i]=sc.nextInt();
		}
		
		for(int i=0; i<n; i++){
			c[a[i]]++;
		}
		for(int i=1; i<range;i++){
			c[i]+=c[i-1];
		}
		for(int i=(n-1);i>=0;i--){
			b[c[a[i]]-1]=a[i];
			c[a[i]]--;
		}
		
		for(int i=0; i<n; i++){
			System.out.println(b[i]);
		}
	}
}