class Solution {
    public int[] getConcatenation(int[] nums) {
        int size = nums.length*2;
        int[] ans = new int[size];
        for(int i =0; i<size; i++) {
            if(i<nums.length) ans[i] = nums[i];
            else ans[i] = nums[i-nums.length];
            
        }
        return ans;
    }
}