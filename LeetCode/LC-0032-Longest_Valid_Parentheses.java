class Solution {
    public int longestValidParentheses(String s) {
        int val = 0;
        int count = 0;
        int max = 0;
        // Check from the front.
        for(char ch : s.toCharArray()){
            if(ch=='(')
                val++;
            else 
                val--;
            if(val<0){
                val = 0;
                count = 0;
            }else{
                count++;
                if(val==0)
                    max = Math.max(count,max);
            }        
        }
        val = 0;
        count = 0;
        // From reverse.
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') 
                val++;
            else 
                val--;
            if(val<0){
                val = 0;
                count = 0;
            }else{
                count++;
                if(val==0)
                    max = Math.max(count,max);
            }    
        }
        return max;
    }
}