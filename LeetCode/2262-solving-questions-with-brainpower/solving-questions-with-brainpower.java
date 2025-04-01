class Solution {
    public long mostPoints(int[][] questions) {
        int size = questions.length;
        long[] dp = new long[size]; 
        Arrays.fill(dp, -1);

        return solve(0,questions,dp,size);
    }

    public long solve(int idx, int[][] questions, long[] dp, int size) {
        if (idx >= size) return 0;

        if (dp[idx] != -1) {
            return dp[idx];
        }

        long take = questions[idx][0] + solve(idx+questions[idx][1]+1, questions, dp, size);
        long dontTake = solve(idx+1, questions, dp, size);

        return dp[idx] = Math.max(take, dontTake);
    }
}