class Solution {
    public boolean canPartition(int[] nums) {
        int sum =0;
        for (int i: nums) sum+=i;
        if (sum%2!=0) return false;
        sum/=2;
        int dp[][] = new int[sum+1][nums.length];
        for (int i=0; i<=sum; i++) {
            Arrays.fill(dp[i],-1);
        }
        return f(nums, 0, sum, dp);
    }

    private boolean f(int[]nums, int idx, int target, int[][] dp) {
        if(target == 0) return true;
        if(idx>=nums.length) return false;
        if(nums[idx] == target) return true;

        if(dp[target][idx] != -1) return dp[target][idx] == 1;
        boolean notTake = f(nums,idx+1,target, dp);
        boolean take = false;
        if (nums[idx]<=target) take = f(nums,idx+1, target-nums[idx], dp);
        dp[target][idx] = (take || notTake) ? 1:0;
        return dp[target][idx]==1;
    }
}