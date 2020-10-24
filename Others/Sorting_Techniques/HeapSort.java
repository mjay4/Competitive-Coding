package Sorting_Techniques;

import java.io.*;
import java.util.*;

class HeapSort{
	
	public void sort(int arr[], int n){
		
		for(int i =(n/2)-1; i>=0; i--)
			heapify(arr,n,i);
		
		for(int i=n-1; i>=0; i--){
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			
			heapify(arr,i,0);
		}
	}
	
	void heapify(int arr[], int n, int i){
		int largest = i;
		int l = 2*i +1;
		int r = 2*i +2;
		
		if(l<n && arr[l]>arr[largest])
			largest = l;
		if(r<n && arr[r]>arr[largest])
			largest = r;
		
		if(largest != i){
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;
			
			heapify(arr,n,largest);
		}
	}
	
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int A[] = new int[20];
		int n;
		System.out.println("Enter the no. of elements you want to sort:");
		n = Integer.parseInt(br.readLine());
		System.out.println(n);
		for(int i=0;i<n;i++){
			A[i]= Integer.parseInt(br.readLine());
		}
		HeapSort ob = new HeapSort();
		System.out.println("Array is : ");
		for(int i=0;i<n;i++){
			System.out.println(A[i]+"");
		}
		ob.sort(A,n);
		
		System.out.println("Sorted Array is : ");
		for(int i=0;i<n;i++){
			System.out.println(A[i]+"");
		}
	}
}