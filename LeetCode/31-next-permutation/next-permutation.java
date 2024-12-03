class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length-1;
        while(i>0){
            if(nums[i-1]<nums[i])
                break;
            i--;
        }
        if(i==0)
            Arrays.sort(nums);
        else{
            i=i-1;
            int min = i;
            for(int j = nums.length-1; j>i;j--){
                if(nums[j]>nums[i]){
                    min = j;
                    break;   
                }
            }
            int temp = nums[min];
            nums[min] = nums[i];
            nums[i] = temp;
            Arrays.sort(nums,i+1, nums.length);
        }
    }
}