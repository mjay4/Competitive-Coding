class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        int[] vertical = new int[n];
        int[] horizontal = new int[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < n; j++) {
                max = Math.max(max, grid[i][j]);
                vertical[j] = Math.max(grid[i][j], vertical[j]);
            }
            horizontal[i] = max;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] < horizontal[i] && grid[i][j] < vertical[j]) {
                    ans += Math.min(horizontal[i], vertical[j]) - grid[i][j];
                }
            }
        }
        return ans;
    }
}