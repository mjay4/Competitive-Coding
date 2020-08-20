import java.util.*;
public class Alchemy{
 	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
	        int T = sc.nextInt();
	        for(int t=1;t<=T;t++){

	            System.out.println("Case #"+t+":");
	            int n = sc.nextInt();
                    sc.nextLine();
                    String s= sc.nextLine();
                    int a = 0;
                    int b = 0;
            	    for(char c: s.toCharArray()) {
            		if(c=='A') {
            		    if(b>1)
            			b--;
            		    else
            			a++;          		
            		}else {
            		    if(a>1)
            			a--;
            		     else 
            		 	b++;
            		}
            	    }
            	    if(a>2 || b>2)
            	  	System.out.println("N");
            	    else
            		System.out.println("Y");
	          
	        }
	  } 
}