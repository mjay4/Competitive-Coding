package Sorting_Techniques;

import java.util.*;

public class InsertionSort {
	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
		int[] arr= new int[5];
		for(int i=0; i<5; i++)
			arr[i]=s.nextInt();
		 for(int j=1; j<5; j++ ){
            int key = arr[j];
            int i=j-1;
            for(; (i>=0)&& (arr[i])>key; i--){
                arr[i+1]=arr[i];
                arr[i]=key;
            }

            arr[i+1]=key;
        }
        for(int i=0; i<5; i++)
        	System.out.println(arr[i]);
	}
}