class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int l=0, r=0, count =0;
        while (r<nums.length) {
            int cur = nums[r++];
            map.put(cur,map.getOrDefault(cur,0)+1);
            while (map.get(cur) > k) {
                map.put(nums[l],map.get(nums[l])-1);              
                l++;
            }
            count = Math.max(count, r-l);
        }

        return count;
    }
}