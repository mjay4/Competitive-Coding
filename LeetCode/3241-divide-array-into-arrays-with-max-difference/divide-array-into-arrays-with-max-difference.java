class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int[] count = new int[100001];
        int len = nums.length;
        int ans[][] = new int[len/3][3];
        for (int i = 0; i < len; i++) {
            count[nums[i]]++;
        }
        int iteratorX =0;
        int iteratorY = 0;
        int diff = 0;
        for (int i = 0; i<100001; i++) {
            if (count[i]==0) continue;
            while (count[i]>0) {
                if (iteratorY == 3) {
                    iteratorY = 0;
                    iteratorX++;
                    diff = 0;
                } else {
                    if (iteratorX == 0 && iteratorY == 0) diff = 0;
                    else diff = i - ans[iteratorX][0];
                    //System.out.println(diff);
                    if (diff > k) {
                        ans = new int[0][0];
                        return ans;
                    }
                }
                count[i]--;
                ans[iteratorX][iteratorY++] = i;
            }
        }
        return ans;
    }
}