class Solution {
    public long findScore(int[] nums) {
         int n = nums.length;
        int[][] ar = new int[n][2];

        for (int i = 0; i < n; i++) {
            ar[i][0] = nums[i];
            ar[i][1] = i;
        }

        Arrays.sort(ar, (a, b) -> a[0] - b[0]);

        boolean[] marked = new boolean[n];
        long result = 0;

        for (int[] a : ar) {
            int val = a[0];
            int ind = a[1];

            if (!marked[ind]) {
                result += val;

                marked[ind] = true;
                if (ind > 0)
                    marked[ind - 1] = true;
                if (ind < n - 1) 
                    marked[ind + 1] = true;
            }
        }

        return result;
    }
}