class Solution {
    public boolean isThereAPath(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;

        if ((rows+columns)%2 == 0) return false;

        // Create Min and Max 2-D array. 
        int[][] min = new int[rows][columns];
        int[][] max = new int[rows][columns];
        min[0][0] = max[0][0] = grid[0][0];

        // Building the top row when we traverse it. 
        for (int i =1; i<rows; i++) {
            min[i][0] = min[i-1][0] + grid[i][0];
            max[i][0] = max[i-1][0] + grid[i][0];
        }

        // Building the First column when we traverse it. 
        for (int i =1; i<columns; i++) {
            min[0][i] = min[0][i-1] + grid[0][i];
            max[0][i] = max[0][i-1] + grid[0][i];
        }

        for (int i=1; i< rows; i++) {
            for (int j=1; j<columns; j++) {
                int minPrev = Math.min(min[i-1][j], min[i][j-1]);
                min[i][j] = minPrev + grid[i][j];
                int maxPrev = Math.max(max[i-1][j], max[i][j-1]);
                max[i][j] = maxPrev + grid[i][j];
            }
        }

        int totalOne = (rows + columns -1)/2;

        return min[rows-1][columns-1] <= totalOne && max[rows-1][columns-1] >=totalOne;    
    }
}