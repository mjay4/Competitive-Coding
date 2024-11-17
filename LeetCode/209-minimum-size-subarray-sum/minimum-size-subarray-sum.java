class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        long sum = 0;
        int minSubArrayLen = Integer.MAX_VALUE, from =0;

        for (int i =0; i < nums.length; i++) {
            sum += nums[i];

            while (sum >= target) {
                minSubArrayLen = Math.min(minSubArrayLen, i-from+1);
                sum -= nums[from++];
            }
        }

        return minSubArrayLen == Integer.MAX_VALUE ? 0 : minSubArrayLen;
    }
}