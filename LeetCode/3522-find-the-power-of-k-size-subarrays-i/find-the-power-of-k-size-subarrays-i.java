class Solution {
    public int[] resultsArray(int[] nums, int k) {
        if (k==1) return nums;
        int n = nums.length;

        int ans[] = new int[n-k+1];
        int left = 0;
        int right = 1;
        int ansIdx = 0;

        while (right <n) {
            // Check if consecutive.

            boolean isConsecutive = nums[right] - nums[right-1] == 1;

            if (!isConsecutive) {
                // If not consecutive, move left to right and mark all as invalid.
                while (left<right && (left+k-1) < n) {
                    ans[ansIdx++] = -1;
                    left++;
                }
                left = right;
            } else if (right-left == k-1){
                ans[ansIdx++] = nums[right];
                left++;
            }
            right++;
        }

        return ans;
    }
}