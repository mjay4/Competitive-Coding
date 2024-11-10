class Solution {
    public int maxProfit(int[] prices) {
        int dp[][] = new int[2][prices.length];
        Arrays.fill(dp[0],-1);
        Arrays.fill(dp[1],-1);
        return Math.max(-prices[0] + fun(prices,1,1, dp), fun(prices, 0,1, dp));
    }

    private int fun(int[] prices, int buying, int idx, int dp[][]) {
        if (idx == prices.length) return 0;
        if (dp[buying][idx] != -1) return dp[buying][idx];
        if (buying == 1) {
            dp[buying][idx] = Math.max(prices[idx] + fun(prices, 0, idx+1, dp), 0+fun(prices, 1, idx+1, dp));    
        } else {
            dp[buying][idx] = Math.max(-prices[idx] + fun(prices, 1, idx+1, dp), 0+fun(prices, 0, idx+1, dp)); 
        }
        return dp[buying][idx];
    }
}