
import java.util.*;
import java.io.*;

public class SubstringRemovalGame{
	public static void main(String args[]) throws IOException{
     	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      	int t = Integer.parseInt(br.readLine());
    
      	while(t-->0) {
      		String s = br.readLine();
      		int ans = 0;
      		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
      		int count =0;
      		for(char c: s.toCharArray()) {
      			if(c=='1') {
      				count++;
      			}else {
      				if(count!=0)
      					pq.add(count);
      				count =0;
      			}
      		}
      		pq.add(count);
      		boolean flag = true;
      		while(!pq.isEmpty()) {
      			int val = pq.poll();
      			if(flag)
      				ans+=val;
      			flag = !flag;
      		}
      		System.out.println(ans);
      		
      	}
      	
	}	   
}
