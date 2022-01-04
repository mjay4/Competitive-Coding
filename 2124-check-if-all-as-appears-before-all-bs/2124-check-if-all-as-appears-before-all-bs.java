class Solution {
    public boolean checkString(String s) {
        boolean reachedB = false;
        boolean ans = true;
        for(char ch: s.toCharArray()){
            if(ch == 'a' && reachedB) {
                ans = false;
            } else if(ch == 'b') {
                reachedB = true;
            }
        }
        return ans;
    }
}