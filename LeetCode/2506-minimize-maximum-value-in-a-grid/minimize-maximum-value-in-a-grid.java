class Solution {
    public int[][] minScore(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> grid[a[0]][a[1]] - grid[b[0]][b[1]]);
        
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                pq.offer(new int[]{i, j});
            }
        }
        
        int[] row_max = new int[rows], col_max = new int[cols];
        int[][] res = new int[rows][cols];
        
        while(pq.size() > 0){
            int[] curr = pq.poll();
            
            int curr_row = curr[0], curr_col = curr[1];
            
            int val = Math.max(row_max[curr_row], col_max[curr_col]) + 1;
            res[curr_row][curr_col] = val;
            row_max[curr_row] = val;
            col_max[curr_col] = val;
        }
        
        return res;
    }
}