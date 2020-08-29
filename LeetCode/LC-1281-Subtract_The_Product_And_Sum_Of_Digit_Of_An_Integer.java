class Solution {
    public int subtractProductAndSum(int n) {
        int prod = 1;
        int sum = 0;
        while(n>0){
            sum+= n%10;
            prod*= n%10;
            n/=10;
        }
        return prod-sum;
    }
}