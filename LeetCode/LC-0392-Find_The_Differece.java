class Solution {
    public char findTheDifference(String s, String t) {
        int ar[] = new int[26];
        for (char c : s.toCharArray()) {
            ar[c - 'a']--;
        }
        for (char c : t.toCharArray()) {
            ar[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (ar[i] > 0) {
                return (char) (i + 'a');
            }
        }
        return 'z';
    }

    /*
     * More optimal solution :
     * 
     * 
     * int n = t.length(); char c = t.charAt(n - 1); for (int i = 0; i < n - 1; ++i)
     * { c ^= s.charAt(i); c ^= t.charAt(i); } return c;
     * 
     */

}