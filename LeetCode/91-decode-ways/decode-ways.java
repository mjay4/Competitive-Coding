class Solution {
    public int numDecodings(String s) {
        int ar[] = new int[s.length()+1];
        return helper(s,ar);
    }
    
    public int helper(String s, int[] ar){
        if(s.equals(""))
            return 1;
        if(s.charAt(0)=='0')
            return 0;
        if(s.length()>=2 && Integer.parseInt(Character.toString(s.charAt(0))+Character.toString(s.charAt(1)))<=26){
            if(ar[s.length()-1]!=0 && ar[s.length()-2]!=0){
                 
            }else{
                ar[s.length()-1] = helper(s.substring(1,s.length()),ar);
                ar[s.length()-2] = helper(s.substring(2,s.length()),ar);
            }
            return ar[s.length()-1] + ar[s.length()-2];
        } else{
            if(ar[s.length()-1]!=0)
                return ar[s.length()-1];
            else{
                ar[s.length()-1] = helper(s.substring(1,s.length()),ar);
                return ar[s.length()-1];
            } 
        }
    }
}