class Solution {
    public long countSubarrays(int[] nums, int k) {
        long ans =0;
        long max =-1;
        List<Integer> maxElement = new ArrayList<>();
        for (int i=0; i<nums.length; i++) {
            if(nums[i]>max) {
                max = nums[i];
                maxElement = new ArrayList<>();
                ans = 0;
            } 
            if (nums[i] == max) {
                maxElement.add(i+1);
            }

            if(maxElement.size() >= k) {
                ans+=maxElement.get(maxElement.size()-k);
            }
        }

        return ans;
    }
}