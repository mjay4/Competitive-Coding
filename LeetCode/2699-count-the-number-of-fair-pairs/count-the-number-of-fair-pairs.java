class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        long ans = 0;   
        Arrays.sort(nums);

        for (int left = 0; left < nums.length - 1; left++) {
            int minRight = lower - nums[left];
            int maxRight = upper - nums[left];
            
            // Use binary search to find the range of valid `right` indices
            long start = binarySearchLeft(nums, minRight, left + 1);
            long end = binarySearchRight(nums, maxRight, left + 1);
            
            // If there are valid pairs in the range, add them to `ans`
            if (start <= end) {
                ans += end - start + 1;
            }
        }

        return ans;
    }

    // Binary search to find the leftmost index with nums[right] >= target
    private int binarySearchLeft(int[] nums, int target, int start) {
        int left = start, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // Binary search to find the rightmost index with nums[right] <= target
    private int binarySearchRight(int[] nums, int target, int start) {
        int left = start, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
}