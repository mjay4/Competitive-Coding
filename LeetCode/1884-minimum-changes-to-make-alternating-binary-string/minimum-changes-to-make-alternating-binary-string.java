class Solution {
    public int minOperations(String s) {
        int count = 0;
        int count2 = 1;
        int prev = getVal(s,0);
        int prev2 = invert(getVal(s,0));
        for (int i = 1; i<s.length(); i++) {
            int cur = getVal(s,i);
            if (cur==prev) {
                count++;
                prev = invert(prev);
            } else {
                prev = cur;
            }
            if (cur == prev2) {
                count2++;
                prev2 = invert(prev2);
            } else {
                prev2 = cur;
            }
        }
        return Math.min(count,count2);
    }

    public int invert(int val) {
        return val == 0 ? 1 : 0;
    }

    public int getVal(String s, int pos)  {
        return s.charAt(pos)-'0';
    }
}