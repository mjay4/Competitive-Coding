import java.util.*;
import java.io.*;

public class Timber{
	 public static void main(String args[]){
		    Scanner sc = new Scanner(System.in);
	        int T = sc.nextInt();
	        for(int t=1;t<=T;t++){
	            System.out.println("Case #"+t+":");
	            int n = sc.nextInt();
	            int ar[][] = new int[n][3];
	            for(int i =0;i<n;i++) {
	            	int p = sc.nextInt();
	            	int h = sc.nextInt();
	            	ar[i][0] = p-h;
	            	ar[i][1] = p;
	            	ar[i][2] = p+h;
	            	//System.out.println(ar[i][0]+" "+ar[i][1] +" "+ar[i][2]);
	            }
	            int[][] range = new int[n][2];
	            for(int[] r: range) {
	            	Arrays.fill(r,0);
	            }
	            int max[] = new int[1];
	            max[0] = 0;
	            simulate(ar,0,n,range,max);
	            System.out.println(max[0]);
	        }
	  } 
	 public static void simulate(int ar[][],int idx,int n, int range[][], int max[]) {
		 if(n==idx) {
			 int cur = calculate(range);
			 max[0] = cur>max[0] ? cur: max[0];
			 return;
		 }
		 range[idx][0] = ar[idx][0] ;
		 range[idx][1] = ar[idx][1] ;
		 //System.out.println("First : "+range[idx][0] + " "+ range[idx][1]);
		 simulate(ar,idx+1,n,range,max);
		 range[idx][0] = ar[idx][1];
		 range[idx][1] = ar[idx][2];
		 //System.out.println("Second : "+range[idx][0] + " "+ range[idx][1]);
		 simulate(ar,idx+1,n,range,max);
	 }
	 public static int calculate(int[][] range) {
		 //calculates the maximum interval in range.
		 int cur = 0;
		 int[][] range2 = range.clone();
		 Arrays.sort(range2,(a,b)-> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
		 HashMap<Integer,Integer> map = new HashMap<>();
		 for(int[] r: range2) {
			 //System.out.println(r[0] + " "+ r[1]);
			 if(map.containsKey(r[0])) {
				 map.put(r[1],map.get(r[0])+(r[1]-r[0]));
			 }else
				 map.put(r[1],r[1]-r[0]);
		 }
		 for(Map.Entry<Integer, Integer> e :map.entrySet()) {
			 cur = e.getValue() > cur ? e.getValue() : cur;
		 }
		 //System.out.println(cur);
		 return cur;
	 }
 }     