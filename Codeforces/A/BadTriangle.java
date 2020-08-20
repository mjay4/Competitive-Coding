import java.util.*;
import java.io.*;

public class BadTriangle{
	public static void main(String args[]) throws IOException{
     	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     	int t = Integer.parseInt(br.readLine());
      
      	while(t-->0) {
      		int n = Integer.parseInt(br.readLine());
      		
      		int ar[] = new int[n];
      		StringTokenizer s = new StringTokenizer(br.readLine());
      		int min = Integer.MAX_VALUE;
      		int idx = -1;
      		int idx2 = -1;
      		int smin = Integer.MAX_VALUE;
      		int max = -1;
      		int midx = -1;
      		for(int i =0;i<n;i++) {
      			ar[i] = Integer.parseInt(s.nextToken());
      			if(ar[i] < min) {
      				smin = min;
      				idx2 = idx;
      				idx = i+1;
      				min = ar[i];
      			}
      			else if(ar[i] <smin) {
      				idx2 = i+1;
      				smin = ar[i];
      			}
      			
      			if(ar[i] > max) {
      				max = ar[i];
      				midx = i+1;
      			}
      		}    
      		
      		if(min+smin > max || n<3) {
      			System.out.println("-1");
      		}else {
      			System.out.println(idx +" "+idx2+" "+midx);
      		}
      		
      	}
      	
	}
	 
	   
}
