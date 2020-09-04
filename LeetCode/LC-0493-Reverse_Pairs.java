class Solution {
    public int reversePairs(int[] nums) {
        /* Brute force.
        int ans = 0;
        for(int i = nums.length-1; i>0 ; i--){
            for(int j = i-1; j>=0;j--){
                if((long)nums[j] > (long)2l*nums[i])
                    ans++;
            }
        }
        return ans;

        Time Complexity = O(N^2).
        */

     return mergeSort(nums, 0, nums.length-1);

    }
    private int mergeSort(int[] ar, int left, int right) {
			int mid = 0, count=0;
			if(right > left) {
				mid = left + (right-left)/2;
				
				count+= mergeSort(ar, left, mid);
				count+= mergeSort(ar, mid+1, right);
				
				count+= merge(ar, left, mid+1, right);
			}
			return count;
	}

	private int merge(int[] ar , int left, int mid, int right) {
			int count =0;
			int i = left; // index of left subarray
			int j = mid;  // index of right subarray
			
            while(i<mid){
                while(j<=right && ar[i] > (2* (long) ar[j]))
                    j++;
                count+= (j-mid);
                i++;
            }

            ArrayList<Integer> temp = new ArrayList<>();
            i = left;
            j = mid;
            while(i<mid && j <= right){
                if(ar[i] <= ar[j])
                    temp.add(ar[i++]);
                else
                    temp.add(ar[j++]);
            }


			while(i < mid)
				temp.add(ar[i++]);
			while(j <= right)
				temp.add(ar[j++]);
			
			for(i =left; i<=right ;i++) {
				ar[i] = temp.get(i-left);
			}
				
			return count;
	}
}