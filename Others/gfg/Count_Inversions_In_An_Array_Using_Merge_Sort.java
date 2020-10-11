import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Count_Inversions_In_An_Array_Using_Merge_Sort {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     	int t = Integer.parseInt(br.readLine());
     	
     	long ans1 = 0;
     	long ans2 = 0;
     	long mod = 1_000_000_007;
     	int ar[] = new int[t];
     	StringTokenizer st = new StringTokenizer(br.readLine());
     	for(int i = 0;i<t ; i++) {
     		ar[i] = Integer.parseInt(st.nextToken());
     	}
     	
     	ans1 = CountInversion_brute(ar);
        ans2 = CountInversion_merge(ar); 	
        System.out.println(ans1 + " " + ans2);
	}

	private static long CountInversion_merge(int[] ar) { 
		long ans = 0;
		int n = ar.length;
		int temp[] = new int[n];
		ans = mergeSort(ar, temp, 0, n-1);
		return ans;
	}
	
	private static long mergeSort(int[] ar, int[] temp, int left, int right) {
		int mid = 0, count=0;
		if(right > left) {
			mid = left + (right-left)/2;
			
			count+= mergeSort(ar, temp, left, mid);
			count+= mergeSort(ar, temp, mid+1, right);
			
			count+= merge(ar, temp, left, mid+1, right);
		}
		return count;
	}

	private static int merge(int[] ar, int[] temp, int left, int mid, int right) {
		int count =0;
		int i = left; // index of left subarray
		int j = mid;  // index of right subarray
		int k = left; // index of resultant subrarray
		
		while(i<mid && j<= right) {
			if(ar[i] <= ar[j])
				temp[k++] = ar[i++];
			else {
				temp[k++] = ar[j++];
				count+= (mid-i);
			}
		}
		while(i < mid)
			temp[k++] = ar[i++];
		while(j <= right)
			temp[k++] = ar[j++];
		
		for( i =left; i<=right ;i++) {
			ar[i] = temp[i];
		}
			
		return count;
	}

	// Brute force O(N^2)
	private static long CountInversion_brute(int[] ar) {
		long ans = 0;
		for(int i =0;i<ar.length; i++) {
			for(int j = i+1; j<ar.length;j++)
				if(ar[j] < ar[i])
					ans++;
		}
		return ans;
	}

}
