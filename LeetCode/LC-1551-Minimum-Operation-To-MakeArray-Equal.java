class Solution {
    public int minOperations(int n) {
        if(n<=3){
            if(n==1)
                return 0;
            if(n==2)
                return 1;
            if(n==3)
                return 2;    
        }
        int dif = n/2;
        int val = n%2 == 0 ? n/2 : n/2+1;
        return dif*val;
        
    }
}