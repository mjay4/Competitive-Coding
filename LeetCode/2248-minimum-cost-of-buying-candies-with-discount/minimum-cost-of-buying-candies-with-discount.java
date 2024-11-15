class Solution {
    public int minimumCost(int[] cost) {
        int ans = 0;
        Arrays.sort(cost);

        for (int i = cost.length-1, j = 0; i>=0; i--) {
            if (j<2) {
                ans+=cost[i];
                j++;
            } else {
                j = 0;
            }
        }

        return ans;
    }
}