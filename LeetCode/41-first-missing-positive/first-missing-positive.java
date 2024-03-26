class Solution {
    public int firstMissingPositive(int[] nums) {
        int size = nums.length;
        for (int i=0; i<size; i++){
            while (nums[i] < size && nums[i] >0 && nums[i] != nums[nums[i]-1]) {
                int temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
            }
        }

        int missingNumber = 1;

        for (int i=0; i<size; i++) {
            // System.out.println(nums[i]);
            if (nums[i] == missingNumber) missingNumber++;
        }

        return missingNumber;
    }
}