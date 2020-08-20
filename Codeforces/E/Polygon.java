import java.util.*;

public class Polygon{
	public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int ar[][] = new int[n][n];
            String s[] = new String[n];
            for(int i=0;i<n;i++) {
            	s[i] = sc.next();
            	for(int j=0;j<n;j++)
            		ar[i][j] = s[i].charAt(j) - '0';
            }
            int flag = 1;
            for(int i=0;i<n-1;i++) {
            	if(flag==0) {
            		break;
            	}
            	for(int j=0;j<n-1;j++) {
            		if(ar[i][j] == 0)
            			continue;
            		else {			
            			if(ar[i+1][j] == 0  && ar[i][j+1] == 0) {
            				flag =0;
            				break;
            			}
            		}
            	}
            }
            if(flag ==0 )
            	System.out.println("NO");
            else 
            	System.out.println("YES");
            
            
        }
    }
}