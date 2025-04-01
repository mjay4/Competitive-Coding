class Solution {
    public int longestPalindrome(String s, String t) {
        t = new StringBuilder(t).reverse().toString();
        int[] palS = longestPalindromes(s);
        int[] palT = longestPalindromes(t);

        int m = s.length(), n = t.length(), res = 0;

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int longestMidPalindrome = 0;
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                    // i+1 and j+1 because the ith or jth character is already taken in main palindrome. 
                    longestMidPalindrome = Math.max(palS[i + 1], palT[j + 1]);
                } else {
                    dp[i + 1][j + 1] = 0;
                    longestMidPalindrome = Math.max(palS[i], palT[j]);
                }
                res = Math.max(res, 2 * dp[i + 1][j + 1] + longestMidPalindrome);
            }
        }
        return res;
    }

    // Checks if a particular string is palindrome.
    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }
        return true;
    }

    // This is to find the len of the longest palindome **starting** at index i.
    private int[] longestPalindromes(String s) {
        int[] res = new int[s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - 1; i <= j; j--) {
                res[i] = isPalindrome(s, i, j) ? j - i + 1 : 1;
                if (res[i] > 1) break;
            }
        }
        return res;
    }
}