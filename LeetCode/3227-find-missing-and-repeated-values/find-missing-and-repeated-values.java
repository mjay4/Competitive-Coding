class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] ans = new int[2];
        int len = grid.length;
        int[] present = new int[(len*len) +1];
        for (int i = 0; i<len; i++){
            for (int j =0; j<len; j++) {
                present[grid[i][j]]++;
            }
        }
        for (int i =1; i<=len*len; i++){
            if (present[i] == 0) ans[1] = i;
            if (present[i] == 2) ans[0] = i;
        }
        return ans;
    }
}