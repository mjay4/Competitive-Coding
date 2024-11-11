class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return fun(nums,nums.length-1,target);
    }

    private int fun(int[] nums, int idx, int target) {
        if (idx == -1) {
            if (target == 0) return 1;
            else return 0;
        }

        return fun(nums, idx-1, target+nums[idx]) + fun(nums,idx-1,target-nums[idx]);
    }
}