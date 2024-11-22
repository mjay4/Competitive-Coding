class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> map = new HashMap<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int ans = 0;

        for (int i=0; i<m; i++){
            StringBuilder sb = new StringBuilder();
            int first = matrix[i][0];
            
            // Iterate through each element in the Row and check for pattern.
            for (int j=0; j<n; j++) {
                if (matrix[i][j] == first) sb.append('T');
                else sb.append('F');
            }
            String s = sb.toString();
            map.put(s, map.getOrDefault(s,0) +1);
        }

        for (String key: map.keySet()) {
            ans = Math.max(ans, map.get(key));
        }
        return ans;
    }
}