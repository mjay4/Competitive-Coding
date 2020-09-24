class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        generate(sb,1,0,ans,n);
        
        return ans;
    }
    public void generate(StringBuilder sb, int open, int close, List<String> ans, int n ){
        if(n == open && n == close){
            //System.out.println(sb.toString());
            ans.add(new String(sb.toString()));
            return;
        }
       
        if(open < n ){
                sb.append("(");
                generate(sb,open+1, close,  ans,n);
                sb.deleteCharAt(sb.length()-1);
        }
        if( close < open ){
             sb.append(")");
             generate(sb,open, close+1,  ans,n);
             sb.deleteCharAt(sb.length()-1);
        }
    }
}