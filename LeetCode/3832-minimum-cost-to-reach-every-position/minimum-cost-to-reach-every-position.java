class Solution {
    public int[] minCosts(int[] cost) {
        int n = cost.length;
        int ans[] = new int[n];
        ans[0] = cost[0];

        for (int i =1; i<n; i++) {
            ans[i] = Math.min(ans[i-1],cost[i]);
        }

        return ans;
    }
}