class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int n = arr.length;
        for(int i =0;i<=n-3;i++){
            if(arr[i]%2!=0){
                if(arr[i+1]%2 ==1 && arr[i+2]%2 ==1){
                    return true;
                }
            }
        }
        return false;
    }
}