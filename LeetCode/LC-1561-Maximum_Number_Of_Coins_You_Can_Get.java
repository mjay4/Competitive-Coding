class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        reverse(piles);
        int val = piles.length/3;
        int ans = 0;
        for(int i =0;i<val;i++){
            ans+=piles[2*i+1];
        }
        return ans;
    }
    public void reverse(int[] ar){
        int start = 0;
        int end = ar.length-1;
        while(start<end){
            int temp = ar[start];
            ar[start++] = ar[end];
            ar[end--] = temp;
        }
    }
}