class Solution {
    public void sortColors(int[] nums) {
        int count0 = 0;
        int count1 = 0;
        for(int i : nums) {
            if(i==0) count0++;
            else if(i==1) count1++;
        }
        for(int i = 0; i<count0; i++) nums[i]=0;
        for(int i = 0; i<count1; i++) nums[count0+i]=1;
        for(int i = count0+count1; i<nums.length; i++) nums[i]=2;
    }
}