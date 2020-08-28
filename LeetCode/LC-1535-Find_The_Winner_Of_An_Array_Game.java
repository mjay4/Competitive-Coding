class Solution {
    public int getWinner(int[] arr, int k) {
        long freq[] = new long[1000001];
        Arrays.fill(freq,0);
        int val = 0;
        int n = arr.length;
        int ans = -1;
        if(k>=n){
            Arrays.sort(arr);
            return arr[n-1];
        }
        while(val++ < n-2){
            int g = arr[0] > arr[1] ? arr[0] : arr[1];
            int s = arr[0] > arr[1] ? arr[1] : arr[0];
            arr[0] = g;
            arr[1] = arr[1+val];
            freq[g]++;
           
            if(freq[g]==k){
                
                ans = g;
                break; 
            }
        }
        return ans == -1 ? arr[0]>arr[1]? arr[0] : arr[1] : ans;
    }
}