class Solution {
    public long countSubarrays(int[] nums, int k) {
        long maxElement = -1;
        long len = nums.length;
        long ans =0; 
        long left =0, right =0;
        long maxElementCount =0;

        for (int i =0; i<len; i++) maxElement = Math.max(maxElement, nums[i]);

        while (left <= right && right < len) {

            if (nums[(int)right] == maxElement) maxElementCount++;

            while (maxElementCount >= k) {
                if (nums[(int)left] == maxElement) maxElementCount--;
                left++;

                ans+= len-right;
            }

            right++;
        }

        return ans;
    }
}