class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long ans = 0;
        long min = Integer.MAX_VALUE;
        boolean countEven = true;
        for (int i=0; i<matrix.length; i++){
            for (int j=0; j<matrix[0].length; j++) {
                long value = matrix[i][j];
                if (value<0) {
                    ans-=value;
                    countEven=!countEven;
                    min = Math.min(-value,min);
                } else {
                    ans+=value;
                    min = Math.min(value, min);
                }
            }
        }
        if (!countEven) {
            // System.out.println(ans + " " + min);
            ans = ans-(2*min);
        }
        return ans;
    }
}