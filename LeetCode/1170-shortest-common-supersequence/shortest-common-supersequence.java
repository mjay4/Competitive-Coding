class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length(), n = str2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i+1][j+1] = dp[i][j] +1;
                } else {
                    dp[i+1][j+1] = Math.max(dp[i][j+1],dp[i+1][j]);
                }
            }
        }

        // Use the LCS to get the result. 
        StringBuilder sb = new StringBuilder();
        for (int i=m-1, j=n-1; i>=0 || j>=0;) {
            if (i<0) {
                sb.append(str2.charAt(j--));
                continue;
            } else if (j<0) {
                sb.append(str1.charAt(i--));
                continue;
            }

            int val = dp[i+1][j+1];
            if (val == dp[i][j+1]) {
                sb.append(str1.charAt(i--));
            } else if (val == dp[i+1][j]) {
                sb.append(str2.charAt(j--));
            } else {
                sb.append(str1.charAt(i));
                i--;
                j--;
            }
        }
        
        return sb.reverse().toString();
    }
}