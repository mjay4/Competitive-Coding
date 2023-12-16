class Solution {
    public int removeAlmostEqualCharacters(String word) {
        char ch[] = new char[word.length()];
        int ans = 0;
        boolean isChanged[] = new boolean[word.length()];
        for (int i = 0; i<word.length(); i++) {
            ch[i] = word.charAt(i);
        }
        for (int i = 1; i<word.length(); i++) {
            if (ch[i] == ch[i-1] || (ch[i] == ch[i-1]-1) || (ch[i]==ch[i-1]+1))  {
                if(!isChanged[i-1]) {
                    ans++;
                    isChanged[i] = true;
                }
            }
        }
        return ans;
    }
}