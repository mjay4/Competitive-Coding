class Solution {
    public int maxProductDifference(int[] nums) {
        int min = nums[0];
        int min2 = 100000;
        int max = nums[0];
        int max2 = -1;

        for (int i =1; i<nums.length; i++) {
            if (max <= nums[i]) {
                max2 = max;
                max = nums[i];
            } else if (max2 < nums[i]) {
                max2 = nums[i];
            }

            if (min >= nums[i]) {
                min2 = min;
                min = nums[i];
            } else if (min2 > nums[i]) min2 = nums[i];
        }

        return (max * max2) - (min * min2);
    }
}