class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long sum = 0;
        long ans = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i=0; i<nums.length; i++) {
            sum+=nums[i];
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);

            if (i>=k-1) {
                if (map.size() == k) ans= Math.max(ans,sum);
                sum-=nums[i-k+1];
                map.put(nums[i - k + 1], map.get(nums[i - k + 1]) - 1);

                if (map.get(nums[i - k + 1]) == 0) map.remove(nums[i - k + 1]);
            }
        }


        return ans;
    }
}