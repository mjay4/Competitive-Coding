class Solution {
    public List<String> generateParenthesis(int n) {
        List <String> ans = new ArrayList<>();
        getItDone(ans, 0, 0, n, "");
        return ans;
    }
    
    private void getItDone(List<String> result, int openCount, int closeCount, int maxValue, String currentString) {
        if(currentString.length() == maxValue*2) {
            result.add(currentString);
            return;
        }
        if(openCount < maxValue) {
            getItDone(result, openCount+1, closeCount, maxValue, currentString+"(");
        }
        if(openCount > closeCount) {
            getItDone(result, openCount, closeCount+1, maxValue, currentString+")");
        }
    }
}