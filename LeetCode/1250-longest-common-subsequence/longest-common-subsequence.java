class Solution {

    int dp[][] = null;
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        dp = new int[m][n];

        for (int i=0; i<m; i++) 
            for (int j=0; j<n; j++) 
                dp[i][j]=-1;

        return f(0,0,text1,text2);
    }

    private int f(int i, int j, String s1, String s2) {
        if (i==s1.length() || j == s2.length()) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        if (s1.charAt(i) == s2.charAt(j)) dp[i][j] = 1 + f(i+1,j+1,s1,s2);
        else dp[i][j] = Math.max(f(i+1,j,s1,s2), f(i,j+1,s1,s2));
        return dp[i][j];
    }
}