class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        
    
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(j==0 && i==0){
                    dp[i][j] = grid[0][0];
                }else{
                    if(j==0){
                        dp[i][j] = dp[i-1][j]+grid[i][j];
                    }else{
                        if(i==0){
                            dp[i][j] = dp[i][j-1]+grid[i][j];
                        }else{
                            dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
                        }
                    }
                }
            }
        }
        return dp[grid.length-1][grid[0].length-1]; 
    }
    
    /* Better solution : 
      public int minPathSum(int[][] grid) {/*        
        
        for(int i = 1;i<grid[0].length;i++)
            grid[0][i] = grid[0][i-1]+grid[0][i];
        
        for(int i = 1;i<grid.length;i++)
            grid[i][0] = grid[i-1][0]+grid[i][0];
        
        for (int i = 1; i < grid.length; ++i) 
            for (int j = 1; j < grid[0].length; ++j) 
                grid[i][j] = Math.min(grid[i-1][j], grid[i][j-1]) + grid[i][j];
          
 
        return grid[grid.length-1][grid[0].length-1];
    }
    
    */
}