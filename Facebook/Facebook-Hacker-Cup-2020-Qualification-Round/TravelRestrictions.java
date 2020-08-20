
import java.util.*;
import java.io.*;

public class TravelRestrictions{

	 public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
	        int T = sc.nextInt();
	        for(int t=0;t<T;t++){
	            int n = sc.nextInt();
	            sc.nextLine();
	            String in= sc.nextLine();
	            String out = sc.nextLine();
	            int i =0;
	            while(i<n) {
	            	StringBuilder ans = new StringBuilder();
	            	if(i==0) {
	            		ans.append("Y");
	            		
	            		int val=i;
	            		while(out.charAt(val)=='Y' && val<n-1 &&in.charAt(val+1)=='Y') {
	            			ans.append("Y");
	            			val++;
	            		}
	            			
	            		while(++val<n)
	            			ans.append("N");
	            	}
	            	else {
	            		if(i==n-1) {
	            			int val= i;
		            		while(val>0 && out.charAt(val) == 'Y' && in.charAt(val-1) == 'Y') {
		            			ans.insert(0, 'Y');
		            			val--;
		            		}
		
		            		while(val-->0)
		            			ans.insert(0, 'N');
		            		
		            		ans.append("Y");
	            			
	            		}else {
	            			
	            			int val= i;
	            			while(val>0 && out.charAt(val) == 'Y' && in.charAt(val-1) == 'Y') {
	            				ans.insert(0, 'Y');
	            				val--;
	            			}
	            			while(val-->0)
	            				ans.insert(0, 'N');
	            		
	            			ans.append("Y");
	            			val=i;
	            			while(out.charAt(val)=='Y' && val<n-1 &&in.charAt(val+1)=='Y') {
	            				ans.append("Y");
	            				val++;
	            			}
	            			
	            			while(++val<n)
	            				ans.append("N");
	            			}
	            		
	            		}
	            	
	            		System.out.println(ans.toString());
	            		i++;
	            	}
	        }
	  } 	
}