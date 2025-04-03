class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long res = 0;
        long maxd =0;
        long maxi = 0;
        for (int i=0; i<n; i++){
            res = Math.max(res, nums[i]*maxd);
            maxd = Math.max(maxd, maxi-nums[i]);
            maxi = Math.max(maxi, nums[i]);
        }
        return res;
    }
}