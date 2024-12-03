class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount+1];
        // Final values can never be more then amount. 
        Arrays.fill(dp,amount+1);

        // Ways to get 0 Amount = 0.
        dp[0]=0;
        
        for(int j=1;j<=amount;j++){
            for(int i:coins){
                // Only check the condition when the coin is smaller then amount. Because if it is bigger it won't make sense to compare. 
                if(i<=j){
                    dp[j] = Math.min(dp[j-i]+1,dp[j]);
                }
            }
        }
        return dp[amount]>amount ? -1 : dp[amount];
    }   
}