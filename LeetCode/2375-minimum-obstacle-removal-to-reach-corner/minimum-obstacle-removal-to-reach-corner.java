class Solution {
    private int[][] directions = {{0, 1},{1, 0},{0, -1},{-1, 0}};
    public int minimumObstacles(int[][] grid) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        
        pq.offer(new int[]{0, 0, 0});
        
        while(!pq.isEmpty())
        {
            int[] current = pq.poll();
            int r = current[0], c = current[1];
            int cost = current[2];
            if(r == rows - 1 && c == cols - 1)
                return cost;
            
            for(int i = 0; i < 4; i++)
            {
                int x = r + directions[i][0];
                int y = c + directions[i][1];
                
                if(x > -1 && x < rows && y > -1 && y < cols && !visited[x][y])
                {
                    if(grid[x][y] == 1)
                        pq.offer(new int[]{x, y, cost + 1});
                    else
                        pq.offer(new int[]{x, y, cost});
                    
                    visited[x][y] = true;
                }
            }
        }
        return -1;
    }
}