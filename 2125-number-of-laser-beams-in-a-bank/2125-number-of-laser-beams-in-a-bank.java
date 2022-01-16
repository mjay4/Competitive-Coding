class Solution {
    public int numberOfBeams(String[] bank) {
        int previousRowBeamCount = 0;
        int ans = 0;
        for(String s : bank) {
            int currentRowBeamCount = 0;
            for(char ch: s.toCharArray()) {
                if(ch == '1') {
                    currentRowBeamCount++;
                }
            }
            ans += currentRowBeamCount*previousRowBeamCount;
            if(currentRowBeamCount != 0 ) previousRowBeamCount = currentRowBeamCount;
        }
        return ans;
    }
}