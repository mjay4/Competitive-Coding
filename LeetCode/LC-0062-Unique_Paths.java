class Solution {
    /*
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        
        for(int i =0;i<dp.length;i++)
            dp[i][0]=1;
        for(int i =0;i<dp[0].length;i++)
            dp[0][i] = 1;
        
        for(int i =1;i<dp.length;i++){
            for(int j =1;j<dp[0].length;j++)
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
        }
        return dp[m-1][n-1];
    }
    */ 
    
    /* Best Solution would be when we calculate all
        the possible combinations.
            
    Because we know the number of rows and number of columns,
    so we can simply do nCr for number of rows with number of columns.
    */
    
    public int uniquePaths(int m, int n) {
        // Total number of combination 
        int N = n+m -2;
        int R = Math.min(n-1, m-1);
        int ans = (int) calc_ncr(N,R);
        return ans;
    }
    public double calc_ncr(int n, int r) {
		double ans = 1;
		for(int i= 0 ;i<r; i++) {
			ans*= (n-i);
		}
		for(int i= 0 ;i<r; i++) {
			ans/=(i+1);
		}
		return ans;
	}
}