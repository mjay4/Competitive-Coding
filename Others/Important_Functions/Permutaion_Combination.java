import java.util.Scanner;

public class Permutaion_Combination {
	public static void main(String args[]) {
		/* This program is used to create different 
		permutation and combinations .
		
		We know that nPr = n! / (n-r)! 
						 = n * n-1 * n-2 * .... (r terms)
						
					 nCr = n! / ((n-r) ! * r!);
					     = n * n-1 * n-2 * ..... ( r terms)/ r* r-1 *r-2 ..... (r terms)		
		*/
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int r = sc.nextInt();
		
		long permutaion = calc_npr(n,r);
		double combination = calc_ncr(n,r);
		System.out.println(permutaion + " " + combination);
	}
	public static long calc_npr(int n, int r) {
		long ans = 1;
		for(int i= 0 ;i<r; i++) {
			ans*= (n-i);
		}
		return ans;
	}
	public static double calc_ncr(int n, int r) {
		double ans = 1;
		for(int i= 0 ;i<r; i++) {
			ans*= (n-i);
		}
		for(int i= 0 ;i<r; i++) {
			ans/=(i+1);
		}
		return ans;
	}
}
