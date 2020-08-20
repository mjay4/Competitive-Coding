import java.util.*;
import java.io.*;
 
public class ThreeStrings{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			char a[] = sc.next().toCharArray();
			char b[] = sc.next().toCharArray();
			char[] c = sc.next().toCharArray();
			boolean flag = true;
			for(int i =0;i<a.length;i++) {
				
				if(b[i] == c[i])
					continue;
				if(a[i] == c[i])
					continue;
				else {
					flag = false;
					break;
				}
					
			}
			if(flag)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
      	
	}
}