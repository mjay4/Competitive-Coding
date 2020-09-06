class Solution {
    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int ans=0;
        for(int i =0; i<n;i++){
            ans+= mat[i][i];
            ans+= mat[i][n-i-1];
        }
        if(n%2!=0)
            ans-=mat[n/2][n/2];
        return ans;
    }
}