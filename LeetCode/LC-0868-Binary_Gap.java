class Solution {
   public int binaryGap(int n) {
       int ans = 0;
       int d = -32;
       while(n>0){
           if(n%2==1){
               ans = Math.max(d,ans);
               d=0;
           }
           
           d++;    
           n/=2;
       }
       return ans;
    }
}