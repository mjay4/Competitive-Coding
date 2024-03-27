class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        
        if (k == 0) return 0;

        int count = 0;
        int prod = 1;
        for (int i =0, j=0; j<nums.length; j++) {
            prod *= nums[j];

            while (i <=j && prod >= k) {
                prod /= nums[i++];
            }

            count += j-i+1;
        }

        return count;
    }
}