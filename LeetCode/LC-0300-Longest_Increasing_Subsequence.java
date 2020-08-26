class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        int ans[] = new int[nums.length];
        Arrays.fill(ans,1);
        int max = 1;
        
        for(int i =nums.length-2;i>=0;i--){
            int prev = nums[i];
            int count = ans[i];
            for(int j = i+1;j<nums.length;j++){
                if(nums[j]>prev){
                    count=Math.max(count,ans[i]+ans[j]);
                }
            }
            ans[i]=count;
        }
        
        for(int i =0;i<nums.length;i++)
            max = Math.max(max,ans[i]);
        return max;
    }
}