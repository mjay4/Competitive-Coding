class Solution {
    public int minAddToMakeValid(String s) {
        int ans =0;
        int currCount = 0;

        for (int i =0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                if (currCount < 0) {
                    ans-=currCount;
                    currCount = 0;
                }
                currCount ++; 
            } else {
                currCount--;
            }
        }
        if (currCount!=0) {
            ans += Math.abs(currCount);
        }
        return ans; 
    }
}